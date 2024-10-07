package com.example.playmakerassignment;

import java.util.List;

public record GetTopPlayersRequest(int requiredTopPlayers,
                                   List<List<String>> participatedPlayers){}
