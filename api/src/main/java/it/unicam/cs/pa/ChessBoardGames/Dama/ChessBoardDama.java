package it.unicam.cs.pa.ChessBoardGames.Dama;

import it.unicam.cs.pa.ChessBoardGames.Library.board.AbstractChessBoard;
import it.unicam.cs.pa.ChessBoardGames.Library.pieces.Pieces;
import it.unicam.cs.pa.ChessBoardGames.Library.board.SimpleBox;

import java.awt.*;

/**
 * Questa classe serve per costruire
 * una scacchiera per giocare al gioco Dama.
 *
 * @author Tommaso Seresi
 */
public class ChessBoardDama extends AbstractChessBoard<SimpleBox> {

    public static final int SIZE_CHESSBOARDDAMA=8;
    public ChessBoardDama() {
        super(SIZE_CHESSBOARDDAMA);
        this.buildChessBoard();
    }

    @Override
    public void buildChessBoard() {
        SimpleBox box=null;
    for(int i=0; i<getSize(); i++){
        for(int j=0; j<getSize(); j++){
            this.insertWhiteBox(i,j,box);
            this.insertPawnsBlackBox(i,j,box);
            if(getMatrix()[i][j]==null) {
                box = new SimpleBox(i, j, Color.black);
                getMatrix()[i][j] = box;
            }
        }
    }

    }
    private void insertWhiteBox(int i, int j, SimpleBox box){
        if((i%2==0 && j%2==0) || (i%2==1 && j%2==1)){
            getMatrix()[i][j]= box= new SimpleBox(i,j, Color.WHITE);
        }
    }
    private void insertPawnsBlackBox(int i, int j, SimpleBox box){
        if(((i>=0 && i<=2) || (i>=5 && i<=7)) && getMatrix()[i][j]==null) {
            box= new SimpleBox(i,j,Color.black);
            Pieces Pawns=null;
            box.setPieces(Pawns);
            getMatrix()[i][j]=box;
        }
    }
}
