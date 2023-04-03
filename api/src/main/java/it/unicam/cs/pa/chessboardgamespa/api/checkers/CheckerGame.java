package it.unicam.cs.pa.chessboardgamespa.api.checkers;


import it.unicam.cs.pa.chessboardgamespa.api.library.Board;
import it.unicam.cs.pa.chessboardgamespa.api.library.Game;
import it.unicam.cs.pa.chessboardgamespa.api.library.I_Board;

import java.awt.Color;

/**
 * Questa classe é responsabile di configurare e gestire le impostazioni
 * del gioco della dama.
 *
 * @param <G> parametro usato per indicare un giocatore generico(umano/bot).
 *
 * @author Tommaso Seresi
 *
 */
public class CheckerGame<G extends CheckerPlayer> extends Game<CheckerPlayer> {

    private final int count;
    private static final int FIX_PLAYER=2;

    private final CheckerRealPlayer human;
    private final G anotherPlayer;



    public CheckerGame(CheckerRealPlayer human, G anotherPlayer) {
        super(FIX_PLAYER, FIX_PLAYER);
        count=0;
        this.human=human;
        this.anotherPlayer=anotherPlayer;
        this.getAllPlayer().add(human);
        this.getAllPlayer().add(anotherPlayer);
    }

    @Override
    public void startGame(I_Board board, Color color) {
    board.buildChessBoard();
    if(board instanceof CheckerBoard bd) {
        this.human.chooseColor(color,bd);
    applyAddPiecePlayer(anotherPlayer,bd,color);}
    }

    private void applyAddPiecePlayer(CheckerPlayer player, Board board, Color color){
        if(player instanceof CheckerRealPlayer rp) {
            if(color==Color.white)
                rp.chooseColor(Color.black, board);
            else rp.chooseColor(Color.white,  board);
        }
        else if(player instanceof CheckerBotPlayer bp)
            bp.addPiece(board);
    }

    @Override
    public void endGame() {
        System.out.println("The winner is"+this.getWinner());
    }

    @Override
    public CheckerPlayer getWinner() {
        if(this.human.getPiecesList().size()==0)
            return this.anotherPlayer;
        else if(this.anotherPlayer.getPiecesList().size()==0)
            return this.human;
        else if(count==50 && this.human.getPiecesList().size()!=0 && this.anotherPlayer.getPiecesList().size()!=0)
        return null;
        return null;
    }


}

