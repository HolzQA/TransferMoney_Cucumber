package ru.netology.page;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.apache.commons.lang3.StringUtils;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPage {
    private SelenideElement personalAccount = $("[data-test-id='dashboard']");
    private ElementsCollection cardInfo = $$("[class='list__item']");
    private ElementsCollection refillButton = $$("[data-test-id='action-deposit']");

    public DashboardPage() {
        personalAccount.shouldBe(visible);
    }

    public String getCardBalance(int cardIndex) {
        String cardInfoAll = cardInfo.get(cardIndex-1).getText();
        String balance = StringUtils.substringBetween(cardInfoAll, "баланс:", "р.").trim();
        return balance;
    }

    public TransferPage refill(int toCardIndex) {
        refillButton.get(toCardIndex -1).click();
        return new TransferPage();
    }

}
