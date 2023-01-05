package it.unicam.cs.pa.ChessBoardGames.Library.board;

/**
 *Questa interfaccia rappresenta una generica scacchiera composta da una matrice di caselle(Box).
 * Essa ha il compito di costruire una scacchiera per qualsiasi tipologia di gioco
 *
 * @author Tommaso Seresi
 */
public interface ChessBoard<B>{

    /**
     * Metodo che definisce la dimensione
     * della scacchiera
     *
     * @return dimensione della scacchiera
     */
    int getSize();

    /**
     * Metodo che restituisce la matrice
     * per costruire la scacchiera.
     *
     * @return matrice della scacchiera
     */
    B[][] getMatrix();

    /**
     * Metodo che costruisce una scacchiera
     * generica.
     */
    void buildChessBoard();


}

