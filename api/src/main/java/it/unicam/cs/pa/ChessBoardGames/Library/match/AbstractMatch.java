package it.unicam.cs.pa.ChessBoardGames.Library.match;

import it.unicam.cs.pa.ChessBoardGames.Library.player.Player;

/**
 * Questa classe astratta serve per poter rappresentare una partita di
 * un qualsiasi gioco di scacchiera dove sará formata da un numero esatto
 * di due giocatori e potranno decidere quando incominciare la partita, se
 * ricominciarla e stabilisce anche chi vince la partita.
 *
 * @param <P> parametro usato per indicare un generico player
 *
 * @author Tommaso Seresi
 */
public abstract class AbstractMatch<P extends Player> implements Match<P> {

    private P player1;
    private P player2;

    public AbstractMatch(P player1, P player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public P getPlayer1() {
        return this.player1;
    }

    @Override
    public P getPlayer2() {
        return this.player2;
    }

    @Override
    public abstract P winPlayer();

    @Override
    public abstract void startMatch();

    @Override
    public abstract void resumeMatch();
}
