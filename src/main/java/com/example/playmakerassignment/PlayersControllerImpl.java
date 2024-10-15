package com.example.playmakerassignment;


import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

@Component
public class PlayersControllerImpl {

    //mapping each player to the number of games he played
    private  Map<String,Long>
    getPlayerToNumberOfAppearances(GetTopPlayersRequest request){
        return request.participatedPlayers().stream()
                .flatMap(l -> l.stream().distinct()) //remove duplicates
                .collect(groupingBy(Function.identity(),
                        Collectors.counting()));
    }

    public   GetTopPlayersResponse
    getTopPlayersImpl(GetTopPlayersRequest request){
        //mapping each player to the number of games he played
        Map<String,Long> playerToNumberOfAppearances =
                getPlayerToNumberOfAppearances(request);
        //getting the top N players
        List<String> res = playerToNumberOfAppearances
                .entrySet()
                .stream()
                .sorted(Comparator.comparing(player ->
                        -player.getValue()))  //using minus values to get reverse order
                .limit(request.requiredTopPlayers()) // getting top N
                .map(Map.Entry::getKey)
                .toList();

        return new GetTopPlayersResponse(res);
    }

    @Cacheable(cacheNames="requests")
    public GetTopPlayersResponse
    getTopPlayersCached(GetTopPlayersRequest request) {
        return getTopPlayersImpl(request);
    }

}
