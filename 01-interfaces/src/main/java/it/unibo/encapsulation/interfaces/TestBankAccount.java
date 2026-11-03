package it.unibo.encapsulation.interfaces;

public class TestBankAccount {

    private TestBankAccount() {
    }

    public static void main(final String[] args) {
        /*
         * 1) Creare l' AccountHolder relativo a Andrea Rossi con id 1
         */ AccountHolder intestatario1 = new AccountHolder("Andrea", "Rossi", 1);
           System.out.println("\nIntestatario 1: " + intestatario1);
        /*
        
         * 2) Creare l' AccountHolder relativo a Alex Bianchi con id 2
         */ AccountHolder intestatario2 = new AccountHolder("Alex", "Bianchi", 2);
            System.out.println("Intestatario 2: " + intestatario2);
        /*

        

         * 3) Dichiarare due variabili di tipo BankAccount ed inizializzarle,
         * rispettivamente, con oggetti di tipo SimpleBankAccount per il conto di
         * Rossi (ammontare iniziale = 0), e di tipo StrictBankAccount per il conto di
         * Bianchi (ammontare iniziale = 0)
         */ BankAccount contoRossi = new SimpleBankAccount(1,0);
            BankAccount contoBianchi = new StrictBankAccount(2,0);
        /*

         * 4) Prima riflessione: perché è stato possibile fare la new di due classi
         * diverse in variabili dello stesso tipo?
         * 
         * Perché entrambe le classi implementano la stessa interfaccia BankAccount, quindi possono essere assegnate a variabili dello stesso tipo BankAccount.
        /*

         * 5) Depositare €10000 in entrambi i conti
         */ contoRossi.deposit(1, 10000);
            contoBianchi.deposit(2, 10000);
        /*

         * 6) Prelevare €15000$ da entrambi i conti
         */ contoRossi.withdraw(1, 15000);
            contoBianchi.withdraw(2, 15000);
        /*

         * 7) Stampare in stdout l'ammontare corrente
         */ System.out.println("\nConto 1: " + contoRossi.getBalance());
            System.out.println("Conto 2: " + contoBianchi.getBalance());
        /*

         * 8) Qual è il risultato e perché?
         * Il primo stampa il saldo negativo, mentre il secondo non stampa nulla perchè il saldo è insufficiente (funzionamento previsto dai rispettivi metodi delle 2 classi)
        /*

         * 9) Depositare nuovamente €10000 in entrambi i conti
         */ contoRossi.deposit(1, 10000);
            contoBianchi.deposit(2, 10000);
        /*

         * 10) Invocare il metodo chargeManagementFees su entrambi i conti
         */ contoRossi.chargeManagementFees(1);
            contoBianchi.chargeManagementFees(2);
        /*

         * 11) Stampare a video l'ammontare corrente
         */ System.out.println("\nConto 1: " + contoRossi.getBalance());
            System.out.println("Conto 2: " + contoBianchi.getBalance());
        /*

         * 12) Qual è il risultato e perché?
         * Rossi non paga commissioni perchè la classe ha il metodo vuoto
         * 
         * Bianchi paga le commissioni perchè la classe prevede il metodo. Le transazioni sono 2 perchè 1 è rifiutata, i 5 euro vengono sottratti una sola volta quando chiamo il metodo 'chargeManagementFees', e sottrae 0.10 per ogni transazione. 
         * Totale sottratto = 5 euro e 20 centesimi
         */
    }
}
