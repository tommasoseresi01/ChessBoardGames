package it.unicam.cs.pa.ChessBoardGames.Library.board;

/**
 * Questa classe astratta implementa l'interfaccia Box essa
 * serve per costruire una generica scacchiera per qualsiasi gioco
 *
 * @param <S> estende l'interfaccia Box, quindi rappresenta una generica casella di una scacchiera
 *
 * @author Tommaso Seresi
 */
public abstract class AbstractChessBoard<S extends Box<?>> implements ChessBoard<SimpleBox> {

    private int size;

    private SimpleBox[][] matrix;

    public AbstractChessBoard(int size) {
        this.size = size;
        this.matrix= new SimpleBox[size][size];
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public SimpleBox[][] getMatrix() {
        return this.matrix;
    }

    @Override
    public abstract void buildChessBoard();
}

