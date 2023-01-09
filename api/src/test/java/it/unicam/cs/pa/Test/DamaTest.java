package it.unicam.cs.pa.Test;

import it.unicam.cs.pa.ChessBoardGames.Dama.ChessBoardDama;
import it.unicam.cs.pa.ChessBoardGames.Dama.PlayerBot;
import it.unicam.cs.pa.ChessBoardGames.Dama.PlayerHuman;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class DamaTest {
    @Test
    public void buildChessBoardDamaShouldBeDone(){
        PlayerHuman player1= new PlayerHuman("Mario", Color.white);
        PlayerBot playerBot= new PlayerBot(Color.black);
        ChessBoardDama chessDama= new ChessBoardDama(player1, playerBot);
        //Controllo se la dimensione specificata é giusta
        assertEquals(8, chessDama.getSize());
        //Controllo se le caselle della scacchiera sono
        //colorate correttamente
        for(int i=0; i<chessDama.getSize(); i++){
            for(int j=0; j<chessDama.getSize(); j++){
                if ((i % 2 == 0 && j % 2 == 0) ||(i%2==1 && j%2==1)) {
                    assertTrue(chessDama.getMatrix()[i][j].getColor()== Color.white);
                }else {
                    assertTrue(chessDama.getMatrix()[i][j].getColor() == Color.black);
                }
            }
        }
        //Controllare se i pezzi sono inseriti correttamente


    }
}
