package it.unicam.cs.pa.ChessBoardGames.Library.pieces;

/**
 * Questa interfaccia rappresenta un generico pezzo che ha la caratteristica
 * di essere posseduto da un giocatore ed effettuare delle mosse all'interno
 * di una scacchiera.
 *
 * @author Tommaso Seresi.
 */
public interface Pieces<P> {

    /**
     * Metodo che restituisce a quale giocatore
     * appartiene questo pezzo
     *
     * @return giocatore in possesso di questo pezzo
     */
    P getPlayer();

    /**
     * Metodo che non restituisce niente,
     * me effettua una determinata mossa
     * in base alla caratteristica del pezzo.
     *
     */
    void move();
}
