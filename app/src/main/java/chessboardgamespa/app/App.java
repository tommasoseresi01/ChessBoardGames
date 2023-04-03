package chessboardgamespa.app;

import it.unicam.cs.pa.chessboardgamespa.api.checkers.*;
import it.unicam.cs.pa.chessboardgamespa.api.checkers.concurrentTurn.CheckersGame;
import it.unicam.cs.pa.chessboardgamespa.api.library.Board;
import java.awt.*;
import java.util.Random;
import java.util.Scanner;

public class App {
    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome Checker game");
        System.out.println("Inserire nome del giocatore ");
        String nome= sc.nextLine();
        CheckerRealPlayer human= new CheckerRealPlayer(nome);
        System.out.println("Inserire con chi vuoi giocare:");
        System.out.println("1-giocatore");
        System.out.println("2-bot");
        CheckerPlayer anotherPlayer = null;
        switch (provaScannerInt()) {
            case 1->{
                System.out.println("Inserire nome del giocatore 2");
                String nome1= sc.nextLine();
                anotherPlayer= new CheckerRealPlayer(nome1);
            }
            case 2->anotherPlayer= new CheckerBotPlayer(human);
        }
        CheckerGame game= new CheckerGame(human, anotherPlayer);
        CheckersGame gameTurn= new CheckersGame();
        CheckerBoard board= CheckerBoard.checkerBoard();
        boolean flag=false;
        Color coloreScelto = null;
        do {
            System.out.println(human.getNome()+"Inserisci il colore che vuoi scegliere:");
            System.out.println("1-bianco");
            System.out.println("2-nero");
            switch (provaScannerInt()) {
                case 1 -> {coloreScelto=Color.white;
                    game.startGame(board,coloreScelto);
                    flag=true;}
                case 2 -> {coloreScelto=Color.black;
                    game.startGame(board,coloreScelto);
                    flag=true;}
            }
        }while(!flag);



        while (true) {
            TypeJack random= randomType();
            try {
                if (gameTurn.isWhitesTurn()) {
                    if ((coloreScelto == Color.white)) {
                        applyMoveHuman(board, coloreScelto, human);
                    } else {
                        applyMovePlayer(anotherPlayer,board,coloreScelto,random);
                    }
                    gameTurn.whiteMove();
                    if (game.getWinner()!=null) {
                        break;
                    }
                } else {
                    if(coloreScelto==Color.white) {
                        applyMovePlayer(anotherPlayer,board,coloreScelto,random);
                    }
                    else{
                        applyMoveHuman(board, coloreScelto, human);
                    }
                    gameTurn.blackMove();
                    if (game.getWinner()!=null) {
                        break;
                    }
                }

            } catch (InterruptedException | IllegalMovementException e) {
                System.out.println("Operazione non corretta\n");
                System.out.println("Inserisci una nuova posizione\n");
            }
        }
        game.endGame();
    }

    private static void applyMovePlayer(CheckerPlayer player, Board board, Color coloreScelto, TypeJack typeJack ) throws IllegalMovementException {
        if(player instanceof CheckerRealPlayer rp) {
            if(coloreScelto==Color.white)
                applyMoveHuman(board, Color.black, rp);
            else applyMoveHuman(board,Color.white,rp);
        }
        else if(player instanceof CheckerBotPlayer bp)
            bp.applyBotMove(board,typeJack);
    }
    private static TypeJack randomType() {
        TypeJack[] typeJacks= TypeJack.values();
        int index= new Random().nextInt(typeJacks.length);
        return typeJacks[index];
    }


    private static void applyMoveHuman(Board board, Color coloreScelto, CheckerRealPlayer human) throws IllegalMovementException {
        System.out.println(board.toString());
        System.out.print("Legend: \n [WP]=pedone bianco \n [BP]=Pedone nero \n [WK]=Dama bianca \n [BK]=Dama nera \n");
        System.out.println("Inserire la posizione x del pezzo da scegliere");
        int x=sc.nextInt();
        System.out.println("Inserire la posizione y del pezzo da scegliere");
        int y=sc.nextInt();
        CheckerPiece pezzoScelto=new CheckerPiece(x,y,coloreScelto);
        System.out.println("Inserire la posizione x del pezzo da spostare ");
        int x1=sc.nextInt();
        System.out.println("Inserire la posizione y del pezzo da spostare ");
        int y1=sc.nextInt();
        System.out.println("Inserire la direzione dello spostamento");
        System.out.println("1-sinistra");
        System.out.println("2-destra");
        TypeJack typeJack = null;
        switch (provaScannerInt()) {
            case 1->typeJack=TypeJack.LEFT;
            case 2->typeJack=TypeJack.RIGHT;
        }
        human.applyMove(pezzoScelto,board,x1,y1,typeJack);
    }

    private static int provaScannerInt() {
        while (true) {
            try {
                int intero = sc.nextInt();
                sc.nextLine();
                return intero;
            } catch (Exception e) {
                System.out.println("Cio' che hai inserito non e' un valore numerico, ritenta ");
            }
        }
    }
}

