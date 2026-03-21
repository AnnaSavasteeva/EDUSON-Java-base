package oop;

/**
 * @author annasavasteeva
 * @date 21.03.2026
 */
public class CreditCard {

    private String accountNumber;
    private long accountBalance;

    public CreditCard(String accountNumber, long accountBalance) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
    }

    public void creditAccount(long creditSum) {
        this.accountBalance += creditSum;
        System.out.printf("Счет %s пополнен на сумму %d%n", getAccountNumberByMask(), creditSum);
    }

    public void withdrawMoney(long withdrawalAmount) {
        if (withdrawalAmount >= this.accountBalance) {
            this.accountBalance -= withdrawalAmount;
            System.out.printf("Списана сумма %d со счета %s%n", withdrawalAmount, getAccountNumberByMask());
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
