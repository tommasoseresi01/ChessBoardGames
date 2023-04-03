package it.unicam.cs.pa.chessboardgamespa.api.library;

import it.unicam.cs.pa.chessboardgamespa.api.checkers.IllegalMovementException;

import java.util.ArrayList;
import java.util.List;

/**
 *Questa classe definisce un generico giocatore
 * che ha il compito di applicare le mosse dei
 * propri pezzi che possiede.
 *
 * @param <P> parametro usato per indicare i pezzi che un giocatore possiede.
 * @param <C> parametro usato per indicare in quale direzione un giocatore vuole
 *           spostare il proprio pezzo.
 *
 * @author Tommaso Seresi
 */
public abstract class Player<P extends I_Pieces, C> implements I_Player<P, C> {

    private String nome;
    private List<P> piecesList;

    public Player(String nome) {
        this.nome = nome;
        this.piecesList= new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<P> getPiecesList() {
        return piecesList;
    }

    @Override
    public abstract void applyMove(P pieces, Board board, int endRow, int endColumn, C typeJack) throws IllegalMovementException;

    @Override
    public int countPieces() {
        return piecesList.size();
    }

}

