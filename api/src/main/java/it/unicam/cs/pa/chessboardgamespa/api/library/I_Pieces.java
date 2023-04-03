package it.unicam.cs.pa.chessboardgamespa.api.library;

import java.awt.*;

/**
 * Questa interfaccia serve per rappresentare un generico
 * pezzo che si trova su una scacchiera.
 *
 * @author Tommaso Seresi
 */
public interface I_Pieces<C> {

    /**
     * Metodo che restituisce
     * il colore di una pedina.
     *
     * @return colore della pedina
     */
    Color getColor();

    /**
     * Metodo che restituisce
     * la posizione sulla scacchiera.
     *
     * @return posizione x
     */
    int getPositionX();

    /**
     * Metodo che restituisce
     * la posizione sulla scacchiera.
     *
     * @return posizione y
     */
    int getPositionY();

    /**
     * Metodo che modifica la
     * posizione x del pezzo sulla
     * scacchiera.
     *
     * @param x indica la nuova posizione x.
     *
     */
    void setPositionX(int x);

    /**
     * Metodo che modifica la
     * posizione x del pezzo sulla
     * scacchiera.
     *
     * @param y indica la nuova posizione y.
     *
     */
    void setPositionY(int y);

    /**
     * Metodo che definisce le
     * regole per lo spostamento
     * di questa semplice pedina.
     *
     * @return true se é possibile effettuare la mossa,
     * false altrimenti.
     *
     */
    boolean ruleMove(Board board, int row, int column, C typeJack);


}
