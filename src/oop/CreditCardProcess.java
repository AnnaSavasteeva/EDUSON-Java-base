package oop;

/**
 * @author annasavasteeva
 * @date 21.03.2026
 */
public class CreditCardProcess {

    public void runCreditCardHomework() {

        CreditCard card1 = new CreditCard("407028100000000001111", 100000);
        CreditCard card2 = new CreditCard("407028100000000002222", 200000);
        CreditCard card3 = new CreditCard("407028100000000003333", 300000);
        showCreditCardsBalance(card1, card2, card3);

        card1.creditAccount(50000);
        card2.creditAccount(20000);
        card3.withdrawMoney(75000);
        showCreditCardsBalance(card1, card2, card3);
    }

    private void showCreditCardsBalance(CreditCard... cards) {
        System.out.println("----------");
        for (CreditCard card : cards) card.showAccountBalance();
        System.out.println("----------");
    }
}
