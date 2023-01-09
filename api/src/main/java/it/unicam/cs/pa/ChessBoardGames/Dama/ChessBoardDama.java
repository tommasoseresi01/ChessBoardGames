package it.unicam.cs.pa.ChessBoardGames.Dama;

import it.unicam.cs.pa.ChessBoardGames.Library.board.AbstractChessBoard;
import it.unicam.cs.pa.ChessBoardGames.Library.pieces.Pieces;
import it.unicam.cs.pa.ChessBoardGames.Library.board.SimpleBox;
import it.unicam.cs.pa.ChessBoardGames.Library.player.AbstractPlayer;

import java.awt.*;

/**
 * Questa classe serve per costruire
 * una scacchiera per giocare al gioco Dama.
 *
 * @author Tommaso Seresi
 */
public class ChessBoardDama extends AbstractChessBoard<SimpleBox> {

    private static final int SIZE_CHESSBOARDDAMA=8;

    private PlayerHuman player;

    private PlayerBot playerBot;

    public ChessBoardDama(PlayerHuman player, PlayerBot playerBot) {
        super(SIZE_CHESSBOARDDAMA);
        this.player=player;
        this.playerBot=playerBot;
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
        if((i>=0 && i<=2) && getMatrix()[i][j]==null) {
            box= new SimpleBox(i,j,Color.black);
            Pieces pawns=new Pawns();
            if(player.getColor()==Color.white)
            {player.getCountPieces().add(pawns);}
            else {playerBot.getCountPieces().add(pawns);}
            box.setPieces(pawns);
            getMatrix()[i][j]=box;
        }
        if((i>=5 && i<=7) && getMatrix()[i][j]==null){
            box= new SimpleBox(i,j,Color.black);
            Pieces pawns=new Pawns();
            if(player.getColor()==Color.black)
            {player.getCountPieces().add(pawns);}
            else{playerBot.getCountPieces().add(pawns);}
            box.setPieces(pawns);
            getMatrix()[i][j]=box;
        }
    }
}
