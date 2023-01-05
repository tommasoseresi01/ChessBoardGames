package it.unicam.cs.pa.ChessBoardGames.Library.match;

/**
 * Questa interfaccia rappresenta una generica partita,
 * dove possono partecipare un numero esatto di giocatori
 * e ci indica chi saranno i vincitori/perdenti della partita.
 *
 * @author Tommaso Seresi
 */
public interface Match<P> {

    /**
     * Metodo che restituisce il primo
     * giocatore a partecipare alla partita
     * @return primo giocatore
     */
    P getPlayer1();

    /**
     * Metodo che restituisce il secondo
     * giocatore a partecipare alla partita
     * @return secondo giocatore
     */
    P getPlayer2();

    /**
     * Metodo che restituisce il vincitore della
     * partita.
     *
     * @return  vincitore della partita
     */
    P winPlayer();

    /**
     * Metodo che serve per incominciare
     * la partita.
     */
    void startMatch();

    /**
     * Metodo che serve per ricominciare
     * la partita.
     */
    void resumeMatch();
}
