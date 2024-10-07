package com.example.playmakerassignment;


import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

public  class PlayersControllerImpl {
    public static GetTopPlayersResponse getTopPlayers(GetTopPlayersRequest request){
        Map<String,Long> playerToNumberOfAppearances =
                request.participatedPlayers().stream()
                .flatMap(l -> l.stream().distinct())
                .collect(groupingBy(Function.identity(),
                        Collectors.counting()));

        List<String> res = playerToNumberOfAppearances.entrySet().stream()
                .sorted(Comparator.comparing(player ->
                        -player.getValue()))
                .limit(request.requiredTopPlayers())
                .map(Map.Entry::getKey)
                .toList();

        return new GetTopPlayersResponse( res);
    }
}
