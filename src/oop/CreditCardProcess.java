package oop;

import java.util.Scanner;

/**
 * @author annasavasteeva
 * @date 21.03.2026
 */
public class CreditCardProcess {

    public void runCreditCardHomework() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Укажите сумму, которую необходимо положить на счет 1: ");
        CreditCard card1 = new CreditCard("407028100000000001111", sc.nextInt());
        System.out.print("Укажите сумму, которую необходимо положить на счет 2: ");
        CreditCard card2 = new CreditCard("407028100000000002222", sc.nextInt());
        System.out.print("Укажите сумму, которую необходимо положить на счет 3: ");
        CreditCard card3 = new CreditCard("407028100000000003333", sc.nextInt());
        showCreditCardsBalance(card1, card2, card3);

        System.out.print("Укажите сумму пополнения счета 1: ");
        card1.creditAccount(sc.nextInt());
        System.out.print("Укажите сумму пополнения счета 2: ");
        card2.creditAccount(sc.nextInt());
        System.out.print("Укажите сумму списания со счета 3: ");
        card3.withdrawMoney(sc.nextInt());
        showCreditCardsBalance(card1, card2, card3);

        sc.close();
    }

    private void showCreditCardsBalance(CreditCard... cards) {
        System.out.println("----------");
        for (CreditCard card : cards) card.showAccountBalance();
        System.out.println("----------");
    }
}
