package it.unibo.encapsulation.interfaces;

public class SimpleBankAccount implements BankAccount {

    /*
     * Aggiungere i seguenti campi:
     * - double balance: ammontare del conto
     * - int transactions: numero delle operazioni effettuate
     * - static double ATM_TRANSACTION_FEE = 1: costo delle operazioni via ATM
     */
    private double balance;
    private int transactions;
    public static double ATM_TRANSACTION_FEE = 1; //public perchè è una costante condivisa da tutti i conti
    private final int id;

    /*
     * Creare un costruttore pubblico che prenda in ingresso un intero (ossia l'id
     * dell'utente) ed un double (ossia, l'ammontare iniziale del conto corrente).
     * 'transactions' non serve passarlo perchè parte da 0. 'ATM_TRANSACTION_FEE' non serve passarlo perchè è una costante e condivisa tra tutti gli oggetti.
     */
    public SimpleBankAccount(final int id, final double balance) {
        this.id = id;
        this.balance = balance;
    }

    /*
     * Si aggiungano selettori per:
     * - ottenere l'id utente del possessore del conto
     * - ottenere il numero di transazioni effettuate
     * - ottenere l'ammontare corrente del conto.
     */
    public int getid() {
        return this.id;
    }

    public double getBalance() { //fa ottenere l'ammontare corrente del conto
        return this.balance;
    }

    public int getTransactionsCount() { //restituisce il numero di transazioni effettuate
        return this.transactions;
    }

 // account.deposit(1, 500)

    public void deposit(final int id, final double amount) { // amount: importo (operazione)
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto Nota: il deposito va a buon fine solo se l'id utente
         * corrisponde
         */
        if (id == this.id) {
            this.transactions++;
            this.balance  = this.balance + amount;   
        }
    }

    public void withdraw(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e rimuove amount al totale del
         * conto. Note: - Il conto puo' andare in rosso (ammontare negativo) -
         * Il prelievo va a buon fine solo se l'id utente corrisponde
         */
        if (id == this.id) {
            this.transactions++;
            this.balance -= amount;
            if(this.balance <= 0){
                System.out.println("Ammontare negativo");
            }
        }
    }

    public void depositFromATM(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e aggiunge amount al totale del
         * conto detraendo le spese (costante ATM_TRANSACTION_FEE) relative
         * all'uso dell'ATM (bancomat) Nota: il deposito va a buon fine solo se
         * l'id utente corrisponde
         */
        if (id == this.id){
             this.transactions++;
             this.balance = (this.balance + amount) - ATM_TRANSACTION_FEE;
        }
    }

    public void withdrawFromATM(final int id, final double amount) {
        /*
         * Incrementa il numero di transazioni e rimuove amount + le spese
         * (costante ATM_TRANSACTION_FEE) relative all'uso dell'ATM (bancomat)
         * al totale del conto. Note: - Il conto puo' andare in rosso (ammontare
         * negativo) - Il prelievo va a buon fine solo se l'id utente
         * corrisponde
         */
        if(id == this.id){
            this.transactions++;
            this.balance = (this.balance - amount) - ATM_TRANSACTION_FEE;
                if (this.balance <= 0){
                    System.out.println("Ammontare negativo");   
                }
        }
    }

    public void chargeManagementFees(final int id) {
    
    }
}
