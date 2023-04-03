package it.unicam.cs.pa.chessboardgamespa.api.checkers;

import it.unicam.cs.pa.chessboardgamespa.api.library.Board;
import it.unicam.cs.pa.chessboardgamespa.api.library.Pieces;

import java.awt.Color;

/**
 *Questa classe rappresenta un singolo pezzo nel gioco delle dama.
 *La classe CheckerPiece è responsabile di mantenere le informazioni riguardanti
 * la posizione del pezzo sulla scacchiera, il suo colore e se è una dama o meno.
 *
 * @author Tommaso Seresi
 *
 */
public class CheckerPiece extends Pieces<TypeJack> {

    private boolean isChecker;          //true indica che il pezzo é una dama, false altrimenti

    public CheckerPiece(int positionX, int positionY, Color colorPieces) {
            super(positionX, positionY, colorPieces);
            isChecker=false;
            if(colorPieces!= Color.white && colorPieces!= Color.BLACK)
                throw new IllegalArgumentException();
    }

    public CheckerPiece(int positionX, int positionY){
        super(positionX, positionY);
    }

    public boolean isChecker() {
        return isChecker;
    }

    /**
     * Metodo che trasforma una pedina
     * in una dama, quando la pedina é arrivata
     * all'altra parte della scacchiera.
     *
     */
    public void pawnTransformChecker(){
        if(!isChecker && ( this.getPositionX()==0 || this.getPositionX()==CheckerBoard.CHESSBOARD_DAMA_SIZE-1)){
            this.isChecker=true;
        }
    }

    @Override
    public boolean ruleMove(Board board, int endRow, int endColumn, TypeJack typeJack) {
        int distance = Math.abs(this.getPositionX() - endRow);
        int distanceColumn=Math.abs(this.getPositionY() - endColumn);
        if (distance == 1 && distanceColumn == 1) {
            return checkSingleMove(board, endRow, endColumn);
        } else if (distance == 2 && distanceColumn == 2) {
            return checkDoubleMove(board, endRow, endColumn, typeJack);
        } else {
            return false;
        }
    }

    /**
     * Metodo privato utilizzato per definire
     * se viene correttamente effettuato uno
     * spostamento del pezzo.
     *
     * @param board parametro per indicare la scacchiera
     * @param endRow parametro per indicare spostamento posizione x
     * @param endColumn parametro per indicare spostamento posizione y
     *
     * @return true se lo spostamento é corretto secondo le regole del gioco,
     * false altrimenti.
     */
    private boolean checkSingleMove(Board board, int endRow, int endColumn) {
        return board.getMatrix()[endRow][endColumn].isEmpty();
    }

    /**
     * Metodo privato serve per definirmi se una
     * cattura viene effettuata correttamente secondo le regole
     * del gioco.
     *
     * @return true cattura corretta, false altrimenti
     *
     */
    private boolean checkDoubleMove(Board board, int endRow, int endColumn, TypeJack typeJack) {
        if (board.getMatrix()[endRow][endColumn].isEmpty()) {
            if (!this.isChecker) {
                if (this.getColor() == Color.white) {
                    return checkWhiteDoubleMove(board, endRow, endColumn, typeJack);
                } else {
                    return checkBlackDoubleMove(board, endRow, endColumn, typeJack);
                }
            } else {
                return true;
            }
        } else {
            return false;
        }
    }

    /**
     * Metodo privato serve per definirmi se una cattura
     * da parte di un pezzo bianco viene effettuata
     * correttamente.
     *
     * @return true cattura corretta, false altrimenti
     *
     */
    private boolean checkWhiteDoubleMove(Board board, int endRow, int endColumn, TypeJack typeJack) {
        CheckerPiece capturePiece;
        if (typeJack == TypeJack.RIGHT) {
            capturePiece = (CheckerPiece) board.getMatrix()[endRow-1][endColumn-1];
        } else {
            capturePiece = (CheckerPiece) board.getMatrix()[endRow-1][endColumn+1];
        }
        if (capturePiece.isChecker) {
            return false;
        }
        return capturePiece.getColor() != this.getColor();
    }

    /**
     * Metodo privato serve per definirmi se una cattura
     * da parte di un pezzo nero viene effettuata correttamente
     * secondo le regole del gioco.
     *
     * @return true cattura corretta, false altrimenti.
     *
     */
    private boolean checkBlackDoubleMove(Board board, int endRow, int endColumn, TypeJack typeJack) {
        CheckerPiece capturePiece;
        if (typeJack == TypeJack.LEFT) {
            capturePiece = (CheckerPiece) board.getMatrix()[endRow+1][endColumn+1];
        } else {
            capturePiece = (CheckerPiece) board.getMatrix()[endRow+1][endColumn-1];
        }
        if (capturePiece.isChecker) {
            return false;
        }
        return capturePiece.getColor() != this.getColor();
    }


    @Override
    public boolean equals(Object o) {
        if(o == null) return false;
        if(o instanceof CheckerPiece p){
            return p.getPositionX() == this.getPositionX() && p.getPositionY() == this.getPositionY() && p.getColor() == this.getColor();
        }
        else  return false;
    }


    @Override
    public String toString() {
        if(!this.isChecker && this.getColor()==Color.white)      return "[WP]";
        else if(!this.isChecker && this.getColor()==Color.black) return "[BP]";
        else if (this.isChecker && this.getColor()==Color.white) return "[WK]";
        else if (this.isChecker && this.getColor()==Color.black) return "[BK]";
        else return "[--]";
    }
}
