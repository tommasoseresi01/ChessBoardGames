package it.unicam.cs.pa.chessboardgamespa.api.checkers;

import it.unicam.cs.pa.chessboardgamespa.api.library.Board;
import it.unicam.cs.pa.chessboardgamespa.api.library.Player;

import java.awt.Color;

/**
 * Questa classe è responsabile di gestire le mosse dei pezzi di dama per un giocatore,
 * applicandole sulla scacchiera.
 *
 * @author Tommaso Seresi
 *
 */
public class CheckerPlayer extends Player<CheckerPiece, TypeJack> {

    private boolean capture;
    public CheckerPlayer(String nome) {
        super(nome);
        capture=false;
    }

    public boolean isCapture() {
        return capture;
    }

    public void setCapture(boolean capture) {
        this.capture = capture;
    }

    @Override
    public void applyMove(CheckerPiece piece, Board board, int endRow, int endColumn, TypeJack typeJack) throws IllegalMovementException {
        checkOwnership(piece);
        if(piece.ruleMove(board,endRow,endColumn, typeJack)){
            if(Math.abs(piece.getPositionX()-endRow)==1){
                performSingleMove(piece, board, endRow, endColumn);
            }
            else if(Math.abs(piece.getPositionX()-endRow)==2){
                performCaptureMove(piece, board, endRow, endColumn, typeJack);
            }
        }
        else throw new IllegalMovementException("Mossa non valida per questo pezzo");
    }

    /**
     *Metodo privato usato per controllare
     * se il pezzo in cui sto applicando la mossa
     * é di prioprietá del giocatore
     */
    private void checkOwnership(CheckerPiece piece) throws IllegalMovementException {
        if(!this.getPiecesList().contains(piece)) throw new IllegalMovementException("Il pezzo non appartiene a questo giocatore");
    }

    /**
     *Metodo privato serve per applicare una
     * mossa di spostamento ad un pezzo del giocatore.
     *
     */
    private void performSingleMove(CheckerPiece piece, Board board, int endRow, int endColumn) {
        CheckerPiece emptyPiece = new CheckerPiece(piece.getPositionX(),piece.getPositionY());
        board.getMatrix()[piece.getPositionX()][piece.getPositionY()] = emptyPiece;
        board.getMatrix()[endRow][endColumn] = piece;
        this.getPiecesList().stream().filter(p->p.equals(piece)).forEach(p->p.setPositionXY(endRow,endColumn));
        piece.pawnTransformChecker();
    }

    /**
     *Metodo privato usato per applicare una
     * mossa di cattura ad un pezzo del giocatore
     */
    private void performCaptureMove(CheckerPiece piece, Board board, int endRow, int endColumn, TypeJack typeJack) {
        CheckerPiece emptyPiece = new CheckerPiece(piece.getPositionX(),piece.getPositionY());
        CheckerPiece currentPieceRight = new CheckerPiece(endRow-1, endColumn-1);
        CheckerPiece currentPieceLeft = new CheckerPiece(endRow-1, endColumn+1);
        boolean isWhite = piece.getColor() == Color.white;
        boolean isRight = typeJack == TypeJack.RIGHT;
        if(isWhite) {
            CheckerPiece currentPiece = isRight ? currentPieceRight : currentPieceLeft;
            if(piece.getColor() != board.getMatrix()[endRow-1][endColumn+(isRight? -1 : 1)].getColor()) {
                capturePiece(board, currentPiece, endRow-1, endColumn+(isRight? -1 : 1));
            }
        }
        else {
            CheckerPiece currentPiece = isRight ? currentPieceLeft : currentPieceRight;
            if(endColumn!=0 && piece.getColor() != board.getMatrix()[endRow+1][endColumn+(isRight? 1 : -1)].getColor()) {
                capturePiece(board, currentPiece, endRow+1, endColumn+(isRight? 1 : -1));
            } else if(endColumn==0) {
                capturePiece(board, currentPiece, endRow+1, endColumn+1);
            }
        }
        capture=true;
        board.getMatrix()[piece.getPositionX()][piece.getPositionY()] = emptyPiece;
        board.getMatrix()[endRow][endColumn] = piece;
        piece.setPositionXY(endRow, endColumn);
        this.getPiecesList().stream().filter(p->p.equals(piece)).forEach(p->p.setPositionXY(endRow,endColumn));
        piece.pawnTransformChecker();
    }

    private void capturePiece(Board board, CheckerPiece piece, int row, int column) {
        capture=true;
        board.getMatrix()[row][column] = piece;
        piece.setPositionXY(row, column);
    }

    /**
     *Metodo privato usato per rimuovere
     * dalla lista dei pezzi dell'avversario
     * il pezzo catturato dal giocatore.
     *
     */
    public void removeCapturedPiece(CheckerPlayer opposingPlayer, CheckerPiece piece, Board board, int endRow, int endColumn, TypeJack typeJack) {
        int targetRow = (piece.getColor() == Color.white) ? endRow - 1 : endRow + 1;
        int targetColumn = (typeJack == TypeJack.LEFT) ? endColumn + 1 : endColumn - 1;

        opposingPlayer.getPiecesList().removeIf(p -> p.getPositionX() == targetRow && p.getPositionY() == targetColumn);
        CheckerPiece empty=new CheckerPiece(targetRow,targetColumn);
        board.getMatrix()[targetRow][targetColumn]=empty;
    }

    @Override
    public String toString() {
        if(this instanceof CheckerRealPlayer) return this.getNome()+":)";
        else if(this instanceof CheckerBotPlayer) return this.getNome()+"*)";
        else return "";
    }
}
