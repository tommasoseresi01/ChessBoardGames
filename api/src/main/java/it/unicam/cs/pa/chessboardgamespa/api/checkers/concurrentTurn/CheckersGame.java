package it.unicam.cs.pa.chessboardgamespa.api.checkers.concurrentTurn;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Questa classe ha la responsabilità di gestire il turno dei giocatori
 * durante il gioco delle dama.
 *
 * @author Tommaso Seresi
 *
 */
public class CheckersGame {
    private Lock lock = new ReentrantLock();
    private Condition whiteTurn = lock.newCondition();
    private Condition blackTurn = lock.newCondition();
    private boolean isWhitesTurn = true;

    public boolean isWhitesTurn() {
        return isWhitesTurn;
    }

    public void whiteMove() throws InterruptedException {
        lock.lock();
        try {
            while (!isWhitesTurn) {
                whiteTurn.await();
            }
            isWhitesTurn = false;
            blackTurn.signal();
        } finally {
            lock.unlock();
        }
    }

    public void blackMove() throws InterruptedException {
        lock.lock();
        try {
            while (isWhitesTurn) {
                blackTurn.await();
            }
            isWhitesTurn = true;
            whiteTurn.signal();
        } finally {
            lock.unlock();
        }
    }
}