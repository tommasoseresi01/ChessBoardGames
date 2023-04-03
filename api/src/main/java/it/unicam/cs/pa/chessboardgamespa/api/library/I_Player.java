package it.unicam.cs.pa.chessboardgamespa.api.library;

import it.unicam.cs.pa.chessboardgamespa.api.checkers.IllegalMovementException;

/**
 * Questa interfaccia serve per rappresentare le funzionalitá
 * che ogni giocatore potrebbe effettuare durante il corso di
 * una partita.
 *
 * @param <P> indica il tipo I_Pieces che un giocatore possiede
 *
 * @author Tommaso Seresi
 */
public interface I_Player<P, C> {

    /**
     * Questo metodo serve per far muovere uno
     * dei pezzi del giocatore sulla scacchiera
     *
     * @param pieces    pezzo da muovere
     * @param board scacchiera dove si concretizza la mossa
     * @param endRow    posizione x dove spostare il pezzo
     * @param endColumn posizione y dove spostare il pezzo
     * @param typeJack usato per indicare un tipo di mossa
     */
    void applyMove(P pieces, Board board, int endRow, int endColumn, C typeJack) throws IllegalMovementException;

    /**
     * Metodo che restituisce quanti pezzi
     * possiede questo giocatore.
     *
     * @return numero di pezzi che possiede
     *
     */
    int countPieces();


}