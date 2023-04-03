package it.unicam.cs.pa.chessboardgamespa.api.library;

import java.awt.Color;

/**
 * La classe Pieces ha la responsabilitá di fornire
 * una base comune per tutte le tipologie di pezzi
 * di un gioco da tavolo, fornendo metodi e proprietà utili
 * per la gestione delle posizioni e delle sue regole di movimento.
 *
 * @param <C> parametro usato per indicare in quale direzione
 *           si deve spostare il pezzo(sinistra/destra).
 *
 * @author Tommaso Seresi
 *
 */
public abstract class Pieces<C> implements I_Pieces<C>{

    private Color colorPieces;
    private int positionX;
    private int positionY;

    private boolean isEmpty;

    public Pieces(int positionX, int positionY, Color colorPieces) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.colorPieces=colorPieces;
        this.isEmpty=false;
    }

    public Pieces(int positionX, int positionY){
        this.positionX=positionX;
        this.positionY=positionY;
        this.isEmpty=true;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    @Override
    public Color getColor() {
        return colorPieces;
    }

    @Override
    public int getPositionX() {
        return this.positionX;
    }

    @Override
    public int getPositionY() {
        return this.positionY;
    }

    @Override
    public void setPositionX(int x) {
        this.positionX=x;
    }

    @Override
    public void setPositionY(int y) {
    this.positionY=y;
    }

    public void setPositionXY(int x, int y){
        this.positionX=x;
        this.positionY=y;
    }

    @Override
    public abstract boolean ruleMove(Board board, int row, int column, C typeJack);
}
