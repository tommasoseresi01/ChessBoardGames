package it.unicam.cs.pa.ChessBoardGames.Library.player;


import it.unicam.cs.pa.ChessBoardGames.Library.pieces.Pieces;

import java.awt.*;
import java.util.List;
import java.util.UUID;

/**
 * Questa interfaccia rappresenta un generico giocatore
 * designato da un numero identificativo che all'interno del
 * gioco dovrá possedere dei pezzi e applicare le loro mosse
 * utilizzando una strategia vincente.
 *
 * @author Tommaso Seresi
 */
public interface Player {
    /**
     * Metodo che restituisce l'id
     * univoco per ogni giocatore.
     *
     * @return id giocatore
     */
    UUID getID();

    /**
     * Metodo che restituisce il nome
     * del giocatore.
     *
     * @return nome giocatore
     */
    String getName();

    /**
     * Metodo che restituisce il colore
     * scelto dal giocatore.
     *
     * @return colore del giocatore
     */
    Color getColor();

    /**
     * Metodo che visualizza la lista dei
     * pezzi che  possiede il giocatore
     *
     * @return pezzi del giocatore
     */
    List<Pieces> getCountPieces();

    /**
     * Metodo che consente di applicare
     * una mossa ad un pezzo di suo
     * possesso.
     */
    void applyMove();


}
