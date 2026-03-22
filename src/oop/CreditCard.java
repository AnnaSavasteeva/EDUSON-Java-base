package oop;

/**
 * @author annasavasteeva
 * @date 21.03.2026
 */
public class CreditCard {

    private final String accountNumber;
    private int accountBalance;

    public CreditCard(String accountNumber, int accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public void creditAccount(int creditSum) {
        this.accountBalance += creditSum;
        System.out.printf("Счет %s пополнен на сумму %d%n", getAccountNumberByMask(), creditSum);
    }

    public void withdrawMoney(int withdrawalAmount) {
        if (this.accountBalance >= withdrawalAmount) {
            this.accountBalance -= withdrawalAmount;
            System.out.printf("Со счета %s списана сумма %d%n", getAccountNumberByMask(), withdrawalAmount);
        } else {
            System.out.printf("Баланс счета %s недостаточен для списания суммы %d%n", getAccountNumberByMask(), withdrawalAmount);
        }
    }

    public void showAccountBalance() {
        System.out.printf("Баланс счета %s: %d%n", getAccountNumberByMask(), this.accountBalance);
    }

    private String getAccountNumberByMask() {
        return "··" + this.accountNumber.substring(this.accountNumber.length() - 4);
    }
}
