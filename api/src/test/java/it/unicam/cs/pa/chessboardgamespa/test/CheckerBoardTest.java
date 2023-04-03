package it.unicam.cs.pa.chessboardgamespa.test;

import it.unicam.cs.pa.chessboardgamespa.api.checkers.CheckerBoard;
import it.unicam.cs.pa.chessboardgamespa.api.checkers.CheckerPiece;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CheckerBoardTest {

    @Test
    public void positionCheckerPawnsShouldBeDone() {
        CheckerBoard board = CheckerBoard.checkerBoard();
        board.buildChessBoard();

        assertNotNull(board.getMatrix());

        assertEquals(8, CheckerBoard.CHESSBOARD_DAMA_SIZE);
        assertEquals(8, board.getMatrix()[0].length);

        for (int r = 0; r < board.getSize(); r++) {
            for (int c = 0; c < board.getSize(); c++) {
                if (r < 3 && (r + c) % 2 == 0) {
                    assertNotNull(board.getMatrix()[r][c]);
                    assertTrue(Color.white == board.getMatrix()[r][c].getColor());
                } else if (r > 4 && (r + c) % 2 == 0) {
                    assertNotNull(board.getMatrix()[r][c]);
                    assertFalse(Color.white == board.getMatrix()[r][c].getColor());
                } else if((r==3 || r==4) && (r+c)%2==0) {
                    assertTrue(board.getMatrix()[r][c].isEmpty());
                } else{
                    assertNull(board.getMatrix()[r][c]);
                }
            }
        }

    }


}
