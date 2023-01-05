package it.unicam.cs.pa.ChessBoardGames.Library.pieces;

import it.unicam.cs.pa.ChessBoardGames.Library.player.Player;

/**
 * Questa classe astratta serve per rappresentare
 * un generico pezzo di un gioco con la scacchiera
 *
 * @param <P> parametro per rappresentare un giocatore
 *           che possiede questo pezzo
 *
 * @author Tommaso Seresi
 */
public abstract class AbstractPieces<P extends Player> implements Pieces<P> {

    private P player;

    public AbstractPieces(P player) {
        this.player = player;
    }

    @Override
    public P getPlayer() {
        return this.player;
    }

    @Override
    public abstract void move();
}
