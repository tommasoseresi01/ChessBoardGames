package it.unicam.cs.pa.ChessBoardGames.Library.pieces;

import it.unicam.cs.pa.ChessBoardGames.Library.player.Player;

/**
 * Questa classe astratta serve per rappresentare
 * un generico pezzo di un gioco con la scacchiera
 *
 *
 * @author Tommaso Seresi
 */
public abstract class AbstractPieces implements Pieces {


    public AbstractPieces() {
    }


    @Override
    public abstract void move();
}
