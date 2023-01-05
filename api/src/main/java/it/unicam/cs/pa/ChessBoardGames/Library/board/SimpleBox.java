package it.unicam.cs.pa.ChessBoardGames.Library.board;

import it.unicam.cs.pa.ChessBoardGames.Library.pieces.Pieces;

import java.awt.*;

/**
 * CLasse che implementa l'interfaccia {@link Box} rappresenta una
 * casella di una scacchiera.
 *
 * @author Tommaso Seresi
 */
public class SimpleBox implements Box<Pieces> {

    private final int row;

    private final int column;

    private Pieces pezzo;

    private final Color colorBox;

    public SimpleBox(int row, int column, Color colorBox) {
        this.row = row;
        this.column = column;
        this.pezzo=null;
        this.colorBox=colorBox;
    }


    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public int getColumn() {
        return this.column;
    }

    @Override
    public Pieces getPieces() {
        return this.pezzo;
    }

    @Override
    public void setPieces(Pieces newPieces) {
        this.pezzo=newPieces;
    }

    @Override
    public Color getColor(){return this.colorBox;}

    @Override
    public boolean state() {
        return pezzo!=null; //se pezzo non é nullo allora restituisci true, false altrimenti
    }
}

