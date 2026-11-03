package it.unibo.encapsulation.interfaces;

public class StrictBankAccount  implements BankAccount {  
    private double balance;
    private int transactions;
    public static double ATM_TRANSACTION_FEE = 1;
    private final int id;

    public StrictBankAccount(final int id, final double balance) {
        this.id = id;
        this.balance = balance;
    }

    public int getid() {
        return this.id;
    }

    public double getBalance() { //fa ottenere l'ammontare corrente del conto
        return this.balance;
    }

    public int getTransactionsCount() { //restituisce il numero di transazioni effettuate
        return this.transactions;
    }

    public void deposit(final int id, final double amount) { // amount: importo (operazione)
        if (id == this.id) {
            this.transactions++;
            this.balance  = this.balance + amount;   
        }
    }

    public void withdraw(final int id, final double amount) {
        if (id == this.id && amount <= balance) {
            this.transactions++;
            this.balance -= amount;
        }
    }

    public void depositFromATM(final int id, final double amount) {
        if (id == this.id){
             this.transactions++;
             this.balance = (this.balance + amount) - ATM_TRANSACTION_FEE;
        }
    }

    public void withdrawFromATM(final int id, final double amount) {
        if (id == this.id){
            this.transactions++;
            this.balance = (this.balance - amount) - ATM_TRANSACTION_FEE;
                if (this.balance <= 0){
                    System.out.println("Ammontare negativo");   
                }
        }
    }

    public void chargeManagementFees(final int id) {
        if (id == this.id) {
            balance = balance - 5;
            balance = balance - (transactions * 0.1); 
            
            // 'transactions' è un numero, non una sequenza di singole operazioni.

            /*
            * Esempio: ho 10 transazioni
            * Costo variabile: 10 * 0.1 = 1 €
            * Saldo iniziale: 100 €
            * Saldo finale: 100 - 1 = 99 €
            */
        }
    }
}