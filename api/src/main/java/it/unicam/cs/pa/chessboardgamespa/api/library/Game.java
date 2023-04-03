package it.unicam.cs.pa.chessboardgamespa.api.library;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * Questa classe serve per rappresentare una generica
 * partita di un gioco scacchiera.
 *
 * @param <P> parametro usato per indicare i player che partecipano al gioco
 *
 * @author Tommaso Seresi
 *
 */
public abstract class Game<P extends I_Player<? extends I_Pieces, ?>> implements I_Game<P> {

    private final int MIN_PLAYER;

    private final int MAX_PLAYER;

    private List<P> playerList;

    public Game(int min_player, int max_player) {
        this.MIN_PLAYER=min_player;
        this.MAX_PLAYER=max_player;
        this.playerList = new ArrayList<>();
    }

    @Override
    public int getMinPlayer() {
        return MIN_PLAYER;
    }

    @Override
    public int getMaxPlayer() {
        return MAX_PLAYER;
    }

    @Override
    public List<P> getAllPlayer() {
        return this.playerList;
    }

    @Override
    public abstract void startGame(I_Board board, Color color);

    @Override
    public abstract void endGame();

    @Override
    public abstract P getWinner();

}

