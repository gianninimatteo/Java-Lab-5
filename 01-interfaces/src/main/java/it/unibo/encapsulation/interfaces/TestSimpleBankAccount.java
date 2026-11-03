package it.unibo.encapsulation.interfaces;

public class TestSimpleBankAccount {

    private TestSimpleBankAccount() { //Serve a impedire che qualcuno crei un oggetto TestSimpleBankAccount.
        /*
         * Prevents object creation from the outside.
         */

    }

    public static void main(final String[] args) {
        // 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
        AccountHolder intestatario1 = new AccountHolder("Andrea", "Rossi", 1);

        // 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
        AccountHolder intestatario2 = new AccountHolder("Alex", "Bianchi", 2);

        // 3) Creare i due SimpleBankAccount corrispondenti
        SimpleBankAccount conto1 = new SimpleBankAccount(1, 500);
        SimpleBankAccount conto2 = new SimpleBankAccount(2, 1000);

        // 4) Effettuare una serie di depositi e prelievi
        conto1.deposit(1,100);
        conto2.deposit(2, 100);

        conto1.withdraw(1,100);
        conto2.withdraw(2,50);

        /*
         * 5) Stampare a video l'ammontare dei due conti e verificare la
         * correttezza del risultato
         */
        System.out.println("Conto 1: " + conto1.getBalance());
        System.out.println("Conto 2: " + conto2.getBalance());

        // 6) Provare a prelevare fornendo un id utente sbagliato
        conto1.withdraw(3,10);
        System.out.println("\nConto 1: " + conto1.getBalance()); // Essendo l'id sbagliato, il conto non viene toccato.

        // 7) Controllare nuovamente l'ammontare. I conti sono rimasti invariati.
        System.out.println("\nConto 1: " + conto1.getBalance());
        System.out.println("Conto 2: " + conto2.getBalance());

        System.out.println("\nIntestatario 1: " + intestatario1);
        System.out.println("Intestatario 2: " + intestatario2);
    }
}
