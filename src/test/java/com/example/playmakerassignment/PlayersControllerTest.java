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

        GetTopPlayersRequest request2 =
                new GetTopPlayersRequest(1,
                        List.of(List.of("Modric", "Neuer" , "Rodri", "Haaland"),
                                List.of("Haaland" , "Modric", "Haaland"),
                                List.of("Mbape", "Modric" , "Messi", "Foden")));
        GetTopPlayersResponse response2 = PlayersControllerImpl.getTopPlayers(request2);
        assertThat(response2.mostParticipatedPlayers().size()==1).isTrue();
        assertThat(response2.mostParticipatedPlayers().getFirst().equals("Modric")).isTrue();
        assertThat(response2.mostParticipatedPlayers().getFirst().equals("Haaland")).isFalse();

    }
}
