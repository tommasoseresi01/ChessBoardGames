package it.unicam.cs.pa.chessboardgamespa.api.checkers;

import it.unicam.cs.pa.chessboardgamespa.api.library.Board;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *Questa classe rappresenta un giocatore automatico
 * per il gioco di dama. La sua responsabilità principale
 * è quella di generare una mossa casuale valida e applicarla
 * sulla scacchiera, utilizzando le regole del gioco.
 *
 * @author Tommaso Seresi
 */
public class CheckerBotPlayer extends CheckerPlayer {

    private static final String NOME="BOT";

    private CheckerPiece generatePiece;

    private final CheckerRealPlayer realPlayerAssociated;

    List<CheckerPiece> adjacentGeneratePiece;

    int solutionX;
    int solutionY;
    public CheckerBotPlayer(CheckerRealPlayer realPlayerAssociated) {
        super(NOME);
        this.realPlayerAssociated=realPlayerAssociated;
    }

public void applyBotMove(Board board, TypeJack typeJack) throws IllegalMovementException {
        this.generateRandomPosition(board, typeJack);
        this.applyMove(generatePiece,board,solutionX,solutionY, typeJack);
        if(this.isCapture()){
            this.removeCapturedPiece(realPlayerAssociated,generatePiece,board,solutionX,solutionY,typeJack);
            this.setCapture(false);
        }
}

    /**
     *Metodo privato utilizzato per generare
     * una mossa casuale valida.
     *
     */
    private void generateRandomPosition(Board board, TypeJack typeJack) throws IllegalMovementException {
        List<CheckerPiece> solution = new ArrayList<>();
        int attempts = 0;
        while (solution.isEmpty() && attempts < 100) {
            generatePiece = this.getPiecesList().get((int) (Math.random() * this.getPiecesList().size()));
            if (generatePiece.isChecker()) {
                adjacentGeneratePiece = new ArrayList<>();
                adjacentGeneratePiece.addAll(this.adjacentPawnWhite(generatePiece, board));
                adjacentGeneratePiece.addAll(this.adjacentPawnBlack(generatePiece, board));
            } else {
                adjacentGeneratePiece = (generatePiece.getColor() == Color.black) ?
                        this.adjacentPawnBlack(generatePiece, board) :
                        this.adjacentPawnWhite(generatePiece, board);
            }
            adjacentGeneratePiece.removeIf(p->!p.isEmpty());
            if (!adjacentGeneratePiece.isEmpty()) {
                CheckerPiece solutionPiece = adjacentGeneratePiece.get((int) (Math.random() * adjacentGeneratePiece.size()));
                solutionX = solutionPiece.getPositionX();
                solutionY = solutionPiece.getPositionY();
                solution.addAll(this.getPiecesList());
                solution.removeIf(p -> !p.ruleMove(board, solutionX, solutionY, typeJack));
            }
            attempts++;
        }
        if (solution.isEmpty()) {
            throw new IllegalMovementException();
        } else {
            generatePiece = solution.get((int) (Math.random() * solution.size()));
        }
    }

    /**
     *Metodo utilizzato per aggiungere le pedine iniziali
     *del bot alla sua lista di pedine.
     *
     */
    public void addPiece(Board board){
        if(realPlayerAssociated.getPiecesList().get(0).getColor()== Color.black){
            for(int i=0; i<3; i++){
                for(int j=0; j< board.getSize(); j++){
                    if((i+j)%2==0){
                        if(board.getMatrix()[i][j] instanceof CheckerPiece pc)
                        this.getPiecesList().add(pc);
                    }
                }
            }
        }
        else { for(int i=0; i<board.getSize(); i++){
            for(int j=0; j< board.getSize(); j++){
                if(i>4 && i<8 && (i+j)%2==0){
                    if(board.getMatrix()[i][j] instanceof CheckerPiece pc)
                    this.getPiecesList().add(pc);
                }
            }
        }
        }
    }

    /**
     *Questi tre metodi privati sono utilizzati per identificare
     *le posizioni adiacenti valide per una pedina nera o bianca
     *e per ottenere le pedine adiacenti ad una data posizione sulla scacchiera.
     *
     */
    private List<CheckerPiece> adjacentPawnBlack(CheckerPiece piece, Board board){
        //Metodo che restituisce i nodi adiacenti corretti di un pezzo nero
        List<CheckerPiece> adjacentList = new ArrayList<>();
        int row=piece.getPositionX();
        int col=piece.getPositionY();

        int[][] directions = {{-1, -1}, {-1, 1}, {-2, -2}, {-2, 2}};

        return getCheckerPieces(board, adjacentList, row, col, directions);
    }

    private List<CheckerPiece> adjacentPawnWhite(CheckerPiece piece, Board board){
        //Metodo che restituisce i nodi adiacenti corretti di un pezzo bianco
        List<CheckerPiece> adjacentList = new ArrayList<>();
        int row=piece.getPositionX();
        int col=piece.getPositionY();

        int[][] directions = {{1, -1}, {1, 1}, {2, 2}, {2, -2}};

        return getCheckerPieces(board, adjacentList, row, col, directions);
    }

    private List<CheckerPiece> getCheckerPieces(Board board, List<CheckerPiece> adjacentList, int row, int col, int[][] directions) {
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if(board instanceof CheckerBoard bb){
                if(bb.isValidPosition(newRow,newCol)){
                    CheckerPiece adjacentPiece= (CheckerPiece) board.getMatrix()[newRow][newCol];
                    adjacentList.add(adjacentPiece);
                }
            }
        }
        return adjacentList;
    }

}
