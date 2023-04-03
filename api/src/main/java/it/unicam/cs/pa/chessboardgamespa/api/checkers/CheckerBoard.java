package it.unicam.cs.pa.chessboardgamespa.api.checkers;

import it.unicam.cs.pa.chessboardgamespa.api.library.Board;
import it.unicam.cs.pa.chessboardgamespa.api.library.I_Pieces;
import it.unicam.cs.pa.chessboardgamespa.api.library.Pieces;

import java.awt.Color;

/**
 * Questa classe definisce un tabellone di gioco specifico
 * per il gioco della dama. La classe ha la responsabilità di creare
 * il tabellone di gioco, verificare la validità delle posizioni all'interno della scacchiera.
 *
 * @author Tommaso Seresi
 *
 */
public class CheckerBoard extends Board {

    public final static int CHESSBOARD_DAMA_SIZE=8;
    private CheckerBoard() {
        super(CHESSBOARD_DAMA_SIZE, CHESSBOARD_DAMA_SIZE);
        for (int i = 0; i < CHESSBOARD_DAMA_SIZE; i++) {
            this.getMatrix()[i]= new Pieces[CHESSBOARD_DAMA_SIZE];
        }
    }

    public static CheckerBoard checkerBoard(){
        return new CheckerBoard();
    }

    public boolean isValidPosition(int row, int col){
        return row >= 0 && row <= 7 && col >= 0 && col <= 7;
    }

    @Override
    public void buildChessBoard() {
        for (int r = 0; r < this.getSize(); r++) {
            for (int c = 0; c < this.getSize(); c++) {
                if (r < 3 && (r + c) % 2 == 0) {
                    this.getMatrix()[r][c] = new CheckerPiece(r,c, Color.white);        //pezzi bianchi
                } else if (r > this.getSize() - 4 && (r + c) % 2 == 0) {
                    this.getMatrix()[r][c] = new CheckerPiece(r,c,Color.black);        //pezzi neri
                }
                else {
                    if((r==3 || r==4)&& (r+c)%2==0)  this.getMatrix()[r][c]= new CheckerPiece(r,c);
                 }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str= new StringBuilder();
        I_Pieces piece;
        for(int i=0; i<CHESSBOARD_DAMA_SIZE; i++){
            for(int j=0; j<CHESSBOARD_DAMA_SIZE; j++){
                piece =this.getMatrix()[i][j];
                if(piece==null){
                    str.append("[--]");}
                else{
                    str.append(piece);}
            }
            str.append("\n");
        }
        return str.toString();
    }
}
