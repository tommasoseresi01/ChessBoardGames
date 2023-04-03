package it.unicam.cs.pa.chessboardgamespa.test;

import it.unicam.cs.pa.chessboardgamespa.api.checkers.CheckerBoard;
import it.unicam.cs.pa.chessboardgamespa.api.checkers.TypeJack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CheckerPieceTest {
    @Test
    public void testPawnMovement() {
        // Crea la scacchiera
        CheckerBoard board = CheckerBoard.checkerBoard();
        board.buildChessBoard();
        boolean tryMove1 =board.getMatrix()[2][0].ruleMove(board,3,1, TypeJack.RIGHT);
        boolean tryMove2 =board.getMatrix()[2][2].ruleMove(board,3,3, TypeJack.RIGHT);
        boolean tryMove3 =board.getMatrix()[2][4].ruleMove(board,3,5, TypeJack.RIGHT);
        boolean tryMove4 =board.getMatrix()[2][6].ruleMove(board,3,7, TypeJack.RIGHT);
        assertTrue(tryMove1);
        assertTrue(tryMove2);
        assertTrue(tryMove3);
        assertTrue(tryMove4);
        tryMove1=board.getMatrix()[0][0].ruleMove(board,1,1, TypeJack.RIGHT);
        tryMove2=board.getMatrix()[0][2].ruleMove(board,1,3, TypeJack.RIGHT);
        tryMove3=board.getMatrix()[0][4].ruleMove(board,1,5, TypeJack.RIGHT);
        tryMove4=board.getMatrix()[0][6].ruleMove(board,1,7, TypeJack.RIGHT);
        assertFalse(tryMove1);
        assertFalse(tryMove2);
        assertFalse(tryMove3);
        assertFalse(tryMove4);
    }


}
