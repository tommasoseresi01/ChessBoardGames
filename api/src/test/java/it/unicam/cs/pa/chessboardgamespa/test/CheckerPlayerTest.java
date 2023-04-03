package it.unicam.cs.pa.chessboardgamespa.test;

import it.unicam.cs.pa.chessboardgamespa.api.checkers.*;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

public class CheckerPlayerTest {

    @Test
    public void realPLayerApplyMoveEmptyBoxShouldBeDone() throws IllegalMovementException {
        CheckerBoard board= CheckerBoard.checkerBoard();
        board.buildChessBoard();
        CheckerPlayer playerWhite= new CheckerPlayer("Human");
        for(int i=0; i<3; i++){
            for(int j=0; j< board.getSize(); j++){
                if((i+j)%2==0){
                    playerWhite.getPiecesList().add((CheckerPiece) board.getMatrix()[i][j]);
                }
            }
        }
        CheckerPiece tryMove= (CheckerPiece) board.getMatrix()[2][0];
        playerWhite.applyMove(tryMove, board, 3,1, TypeJack.RIGHT);
        CheckerPiece empty=new CheckerPiece(2,0);
       assertEquals(board.getMatrix()[2][0].isEmpty(), empty.isEmpty());
        assertEquals(board.getMatrix()[3][1], tryMove);

    }

    @Test
    public void realPlayerApplyMoveCapturePieceShouldBeDone() throws IllegalMovementException {
        CheckerBoard board= CheckerBoard.checkerBoard();
        board.buildChessBoard();
        CheckerPlayer playerWhite= new CheckerPlayer("Human");
        CheckerPlayer playerBlack= new CheckerPlayer("Bot");
        for(int i=0; i<board.getSize(); i++){
            for(int j=0; j< board.getSize(); j++){
                if(i<3 && (i+j)%2==0){
                    playerWhite.getPiecesList().add((CheckerPiece) board.getMatrix()[i][j]);
                }
                if(i>4 && i<8 && (i+j)%2==0){
                    playerBlack.getPiecesList().add((CheckerPiece) board.getMatrix()[i][j]);
                }
            }
        }
        CheckerPiece tryMove= (CheckerPiece) board.getMatrix()[2][0];
        playerWhite.applyMove(tryMove, board, 3,1, TypeJack.RIGHT);
        tryMove= (CheckerPiece) board.getMatrix()[5][3];
        playerBlack.applyMove(tryMove, board, 4,2, TypeJack.LEFT);
        tryMove= (CheckerPiece) board.getMatrix()[3][1];
        playerWhite.applyMove(tryMove, board, 5,3, TypeJack.RIGHT);
        CheckerPiece empty=new CheckerPiece(4,2);
       assertEquals(board.getMatrix()[4][2].isEmpty(), empty.isEmpty());
        assertEquals(board.getMatrix()[5][3], tryMove);
    }

    @Test
    public void applyMoveBotShouldBeDone() {
        CheckerBoard board=CheckerBoard.checkerBoard();
        board.buildChessBoard();
        CheckerRealPlayer human= new CheckerRealPlayer("Sara");
        human.chooseColor(Color.white, board);
        CheckerBotPlayer bot= new CheckerBotPlayer(human);
        bot.addPiece(board);
        //bot.applyBotMove(board);
    }


    @Test
    public void applyCaptureMoveShouldBeDone() throws IllegalMovementException {
        CheckerBoard board= CheckerBoard.checkerBoard();
        board.buildChessBoard();
        CheckerRealPlayer human1= new CheckerRealPlayer("Human");
        human1.chooseColor(Color.black, board);
        CheckerRealPlayer human2=  new CheckerRealPlayer("human2");
        human2.chooseColor(Color.white, board);
        CheckerPiece pieceWhite=new CheckerPiece(2,0,Color.white);
        CheckerPiece pieceBlack=new CheckerPiece(5,3,Color.black);
        human1.applyRealMove(human2, pieceBlack, board, 4, 2, TypeJack.LEFT);
        human2.applyRealMove(human1, pieceWhite,board,3,1, TypeJack.RIGHT);
        CheckerPiece pieceWhiteCapture= new CheckerPiece(3,1,Color.white);
        human2.applyRealMove(human1,pieceWhiteCapture,board,5,3, TypeJack.RIGHT);
        CheckerPiece empty= new CheckerPiece(4,2);
        assertEquals(board.getMatrix()[4][2].isEmpty(), empty.isEmpty());
        assertEquals(human1.getPiecesList().size(),11);
    }
    @Test
    public void applyCaptureDiagonalLeftShouldBeDone() throws IllegalMovementException {
        CheckerBoard board= CheckerBoard.checkerBoard();
        board.buildChessBoard();
        CheckerRealPlayer human1= new CheckerRealPlayer("Human");
        human1.chooseColor(Color.black, board);
        CheckerRealPlayer human2=  new CheckerRealPlayer("human2");
        human2.chooseColor(Color.white, board);
        CheckerPiece pieceWhite=new CheckerPiece(2,6,Color.white);
        CheckerPiece pieceBlack=new CheckerPiece(5,3,Color.black);
        human2.applyRealMove(human1,pieceWhite,board,3,5, TypeJack.LEFT);
        human1.applyRealMove(human2,pieceBlack,board,4,4, TypeJack.RIGHT);
        CheckerPiece pieceWhiteCapture= new CheckerPiece(3,5,Color.white);
        human2.applyRealMove(human1,pieceWhiteCapture,board,5,3, TypeJack.LEFT);
        CheckerPiece empty= new CheckerPiece(4,4);
        assertEquals(board.getMatrix()[4][4].isEmpty(), empty.isEmpty());
        assertEquals(human1.getPiecesList().size(),11);
    }

    @Test
    public void applyCaptureDiagonalRightShouldBeDone() throws IllegalMovementException {
        CheckerBoard board= CheckerBoard.checkerBoard();
        board.buildChessBoard();
        CheckerRealPlayer human1= new CheckerRealPlayer("Human");
        human1.chooseColor(Color.black, board);
        CheckerRealPlayer human2=  new CheckerRealPlayer("human2");
        human2.chooseColor(Color.white, board);
        CheckerPiece pieceWhite=new CheckerPiece(2,0,Color.white);
        CheckerPiece pieceBlack=new CheckerPiece(5,3,Color.black);
        human2.applyRealMove(human1,pieceWhite,board,3,1, TypeJack.RIGHT);
        human1.applyRealMove(human2,pieceBlack,board,4,4, TypeJack.RIGHT);
        CheckerPiece anotherPiece= new CheckerPiece(3,1,Color.white);
        human2.applyRealMove(human1,anotherPiece,board,4,2, TypeJack.RIGHT);
        CheckerPiece captureBlack= new CheckerPiece(5,1,Color.black);
        human1.applyRealMove(human2,captureBlack,board,3,3, TypeJack.RIGHT);
        CheckerPiece empty= new CheckerPiece(4,2);
        assertEquals(board.getMatrix()[4][2].isEmpty(), empty.isEmpty());
        assertEquals(human2.getPiecesList().size(),11);
    }

    @Test
    public void applyCapturePlayerBlackShouldBeDone() throws IllegalMovementException {
        CheckerBoard board= CheckerBoard.checkerBoard();
        board.buildChessBoard();
        CheckerRealPlayer human1= new CheckerRealPlayer("Human");
        human1.chooseColor(Color.black, board);
        CheckerRealPlayer human2=  new CheckerRealPlayer("human2");
        human2.chooseColor(Color.white, board);
        CheckerPiece pieceWhite=new CheckerPiece(2,0,Color.white);
        CheckerPiece pieceBlack=new CheckerPiece(5,3,Color.black);
        human2.applyRealMove(human1,pieceWhite,board,3,1, TypeJack.RIGHT);
        human1.applyRealMove(human2,pieceBlack,board,4,2, TypeJack.LEFT);
        CheckerPiece anotherPiece= new CheckerPiece(2,2,Color.white);
        human2.applyRealMove(human1,anotherPiece,board,3,3, TypeJack.RIGHT);
        CheckerPiece captureBlack= new CheckerPiece(4,2,Color.black);
        human1.applyRealMove(human2,captureBlack,board,2,0, TypeJack.LEFT);
        CheckerPiece empty= new CheckerPiece(3,1);
        assertEquals(board.getMatrix()[3][1].isEmpty(), empty.isEmpty());
        assertEquals(human2.getPiecesList().size(),11);
    }


}
