package it.unicam.cs.pa.chessboardgamespa.api.checkers;

import it.unicam.cs.pa.chessboardgamespa.api.library.Board;

import java.awt.Color;

/**
 * Questa classe rappresenta un giocatore reale
 * per il gioco di dama. La sua responsabilità principale
 * è quella di applicarla un mossa valida sulla scacchiera,
 * utilizzando le regole del gioco.
 *
 * @author Tommaso Seresi
 *
 */
public class CheckerRealPlayer extends CheckerPlayer {
    private final String name;
    private Color colorChoose;
    public CheckerRealPlayer(String name) {
        super(name);
        this.name = name;
    }

    public Color getColorChoose() {
        return colorChoose;
    }


    public void applyRealMove(CheckerPlayer opposingPlayer, CheckerPiece piece, Board board, int endRow, int endColumn, TypeJack typeJack) throws IllegalMovementException {
        applyMove(piece, board, endRow, endColumn, typeJack);
        if (isCapture()) {
            this.removeCapturedPiece(opposingPlayer, piece, board, endRow, endColumn, typeJack);
            setCapture(false);
        }
    }

    /**
     * Metodo utilizzato per aggiungere le pedine iniziali
     * del giocatore reale alla sua lista di pedine.
     *
     */
    public void chooseColor(Color color, Board board){
        for(int i=0; i< board.getSize(); i++){
            for(int j=0; j< board.getSize(); j++){
                if(color== Color.white){
                    colorChoose=Color.white;
                    if(i<3 && (i+j)%2==0){
                        if(board.getMatrix()[i][j] instanceof CheckerPiece pc)
                        this.getPiecesList().add(pc);
                    }
                } else if(color==Color.black){
                    colorChoose=Color.black;
                    if(i>4 && i<8 && (i+j)%2==0){
                        if(board.getMatrix()[i][j] instanceof CheckerPiece pc)
                        this.getPiecesList().add(pc);
                    }
                }
            }
        }
    }


}
