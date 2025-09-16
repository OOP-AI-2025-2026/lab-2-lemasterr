package ua.opnu;

public class BankAccount {
    String name;
    double balance;
    double transactionFee;

    void deposit(double amount) {
        // Якщо сума менше нуля - вихід
        if (amount <= 0){
            return;
        }
        // Інакше баланс поповнюється
        balance += amount;
    }

    double getBalance() {
        return this.balance;
    }

    boolean withdraw(double amount) {
        if (amount <= 0){
            return false;
        }
        // Рахуємо залишок балансу, якщо сума більша балансу - вихід
        double amountWithFee = amount + transactionFee;
       if (amountWithFee > balance){
           return false;
       }
       balance -= amountWithFee;
        return true;
    }

    boolean transfer(BankAccount receiver, double amount) {
        if (amount <= 0){
            return false;
        }
        // Рахуємо суму переказу та баланс відправника, та отримувача
        double totalTransfer = amount + transactionFee;
        if (totalTransfer > balance){
            return false;
        }
        this.balance -= totalTransfer;
        receiver.balance += amount;
        return true;
    }

}
