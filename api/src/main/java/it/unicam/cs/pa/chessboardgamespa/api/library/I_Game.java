package it.unicam.cs.pa.chessboardgamespa.api.library;

import java.awt.*;
import java.util.List;

/**
 * Questa interfaccia definisce tutte le configurazioni
 * standard di una generica partita di un gioco con
 * scacchiera.
 *
 * @param <G> rappresenta il tipo giocatore che partecipa
 *           ad una generica partita
 *
 * @author Tommaso Seresi
 */
public interface I_Game<G> {

    /**
     * Metodo che definisce il
     * numero minimo di giocatori
     * che possono partecipare a questa partita.
     * @return numero minimo di giocatori.
     *
     */
    int getMinPlayer();

    /**
     * Metodo che definisce il
     * numero massimo di giocatori
     * che possono partecipare a questa partita.
     * @return numero massimo di giocatori.
     *
     */
    int getMaxPlayer();

    /**
     * Metodo che restituisce tutta
     * la lista dei giocatori che partecipano
     * a questa partita.
     *
     * @return lista dei giocatori che partecipano.
     */
    List<G> getAllPlayer();


    /**
     * Metodo che definisce le
     * configurazioni iniziali quando
     * si incomincia un generico gioco.
     *
     * @param board parametro usato per costruire la scacchiera
     * @param color parametro usato per assegnare ai vari giocatori
     *              presenti un colore
     *
     */
    void startGame(I_Board board, Color color);

    /**
     * Metodo che definisce le
     * configurazioni finali quando
     * finisce un generico gioco.
     *
     */
    void endGame();

    /**
     * Metodo che restituisce il
     * vincitore di questa partita.
     *
     * @return il giocatore che ha vinto.
     *
     */
    G getWinner();
}

