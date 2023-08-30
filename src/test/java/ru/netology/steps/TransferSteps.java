package ru.netology.steps;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.junit.jupiter.api.Assertions;
import ru.netology.page.DashboardPage;
import ru.netology.page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static ru.netology.data.DataGenerator.*;


public class TransferSteps {
    private static DashboardPage dashboardPage;

    @Пусть("пользователь залогинен с именем {string} и паролем {string}")
    public void loginWithNameAndPassword(String login, String password) {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var verificationPage = loginPage.validLogin(login, password);
        dashboardPage = verificationPage.validVerify(getVerificationCode());
    }


    @Когда("пользователь переводит {string} рублей с карты с номером {string} на свою {int} карту с главной страницы")
    public void transferMoney(String amount, String fromCardNumber, int toCardIndex) {
        var transferPage = dashboardPage.refill(toCardIndex);
        dashboardPage = transferPage.validTransfer(amount, fromCardNumber);
    }


    @Тогда("баланс его {int} карты из списка на главной странице должен стать {string} рублей")
    public void verifyToCardBalance(int toCardIndex, String expectedToCardBalance) {
        String actualToCardBalance = dashboardPage.getCardBalance(toCardIndex);
        Assertions.assertEquals(expectedToCardBalance, actualToCardBalance);
    }
}
