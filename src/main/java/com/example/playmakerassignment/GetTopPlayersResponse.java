package com.example.playmakerassignment;

import java.io.Serializable;
import java.util.List;


public record GetTopPlayersResponse(List<String> mostParticipatedPlayers)
        implements Serializable {}
