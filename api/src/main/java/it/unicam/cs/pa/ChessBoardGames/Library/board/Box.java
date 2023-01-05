package it.unicam.cs.pa.ChessBoardGames.Library.board;

import it.unicam.cs.pa.ChessBoardGames.Library.pieces.Pieces;

import java.awt.*;

/**
        * Questa interfaccia rappresenta una casella all'interno di una scacchiera. Essa deve avere una posizione
        * derivata dalle righe e colonne della scacchiera, inoltre potrebbe avere un pezzo.
        * @param <P>  parametro per rappresentare il pezzo che si trova in questa casella
        *
        * @author Tommaso Seresi
        */
public interface Box<P extends Pieces> {

    /**
     * Metodo che restituisce l'esatta riga
     * in cui tale casella milita sulla scacchiera
     *
     * @return la riga della casella
     */
    int getRow();

    /**
     * Metodo che restituisce l'esatta colonna
     * in cui tale casella milita nella scacchiera
     *
     * @return la colonna della casella
     */
    int getColumn();

    /**
     * Metodo che restituisce il pezzo che si trova
     * su questa determinata casella.
     * @return P se un esiste un pezzo in questa casella,
     * null altrimenti
     */
    P getPieces();

    /**
     * Metodo che inserisce/modifica un pezzo
     * in questa casella.
     * @param newPieces nuovo pezzo da inserire
     */
    void setPieces(P newPieces);

    /**
     * Metodo che restituisce il colore
     * della casella
     * @return colore della casella
     */
    Color getColor();

    /**
     * Metodo che ci definisce se la casella
     * é occupata.
     * @return true se la casella é occupata,
     * false altrimenti.
     */
    boolean state();


}

