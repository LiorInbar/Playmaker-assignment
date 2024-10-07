package com.example.playmakerassignment;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayersController {

    /*
    using post method and not get because the request has
    a body.
     */
    @PostMapping("/topN")
    public GetTopPlayersResponse getTopPlayers(@RequestBody GetTopPlayersRequest request) {
        return PlayersControllerImpl.getTopPlayers(request);
    }
}
