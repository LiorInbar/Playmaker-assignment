package com.example.playmakerassignment;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PlayersControllerTest {
    @Test
    public void playersControllerTest(){
        GetTopPlayersRequest request =
                new GetTopPlayersRequest(2,
                         List.of(List.of("Sharon", "Shalom" , "Sharon", "Ronaldo"),
                                List.of("Sharon", "Shalom" , "Myke", "Ronaldo"),
                                List.of("Yechiel", "Sivan" , "Messi", "Ronaldo"),
                                List.of("Yechiel", "Assaf" , "Shalom", "Ronaldo")));


        GetTopPlayersResponse response = PlayersControllerImpl.getTopPlayers(request);
        assertThat(response.mostParticipatedPlayers().size()==2).isTrue();
        assertThat(response.mostParticipatedPlayers().getFirst().equals("Ronaldo")).isTrue();
        assertThat(response.mostParticipatedPlayers().getLast().equals("Shalom")).isTrue();
    }
}
