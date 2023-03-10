package it.unicam.cs.pa.ChessBoardGames.Library.player;


import it.unicam.cs.pa.ChessBoardGames.Library.pieces.Pieces;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Questa classe astratta implementa l'interfaccia Player
 * serve per rappresentare un generico giocatore di un gioco
 * della scacchiera. Esso decide quale mossa applicare ad un
 * pezzo di sua proprietá.
 *
 * @author Tommaso Seresi
 */
public abstract class AbstractPlayer implements Player {

    private UUID idPlayer;
    private String namePlayer;
    private Color colorPlayer;

    private List<Pieces> listaPezzi;

    public AbstractPlayer(String namePlayer, Color colorPlayer) {
        this.idPlayer=UUID.randomUUID();
        this.namePlayer = namePlayer;
        this.colorPlayer = colorPlayer;
        listaPezzi=new ArrayList<>();
    }

    @Override
    public UUID getID() {
        return this.idPlayer;
    }

    @Override
    public String getName() {
        return this.namePlayer;
    }

    /**
     * Metodo che restituisce il colore
     * del giocatore(di solito il giocatore
     * deve scegliere tra due colori nero
     * o bianco.
     *
     * @return colore del giocatore
     */
    @Override
    public Color getColor() {
        return this.colorPlayer;
    }

    @Override
    public List<Pieces> getCountPieces() {
        return this.listaPezzi;
    }

    @Override
    public abstract void applyMove();
}
