package ru.netology.page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class TransferPage {
    private SelenideElement cardRefill = $x("//*[text()='Пополнение карты']");
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");

    public TransferPage() {
        cardRefill.shouldBe(visible);
    }

    public DashboardPage validTransfer(String amount, String fromCardNumber) {
        amountField.setValue(amount);
        fromField.sendKeys(fromCardNumber);
        transferButton.click();
        return new DashboardPage();
    }

}
