package it.unicam.cs.pa.chessboardgamespa.api.library;

/**
 * Questa interfaccia serve per definire le funzionalitá
 * per costruire una generica scacchiera.
 *
 * @param <P> parametro i tipo utilizzato per rappresentare
 *           un generico pezzo presente nella scacchiera.
 *
 * @author Tommaso Seresi
 */
public interface I_Board<P> {

    /**
     * Metodo che ci restituisce
     * la dimensione della scacchiera.
     *
     * @return dimensione della scacchiera.
     *
     */
    int getSize();

    /**
     * Metodo che restituisce
     * la scacchiera.
     *
     * @return scacchiera
     *
     */
    P[][] getMatrix();

    /**
     * Metodo che ha il compito
     * di costruirmi la scacchiera
     * per quel particolare gioco.
     *
     */
    void buildChessBoard();
}

