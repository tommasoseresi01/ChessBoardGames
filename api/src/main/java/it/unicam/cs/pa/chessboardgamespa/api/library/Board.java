package it.unicam.cs.pa.chessboardgamespa.api.library;

/**
 * Questa classe astratta implementa l'interfaccia I_Board essa
 * serve per costruire una generica scacchiera per qualsiasi gioco.
 *
 * @author Tommaso Seresi
 */
public abstract class Board implements I_Board<Pieces> {

    private final int size;

    private Pieces[][] matrix;

    public Board(int size1, int size2) {
        this.matrix= new Pieces[size1][size2];
        this.size = size1;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public Pieces[][] getMatrix() {
        return this.matrix;
    }

    @Override
    public abstract void buildChessBoard();
}
