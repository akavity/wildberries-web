package org.akavity.steps;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.ProductPage;
import org.akavity.utils.Utils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;

@Log4j2
public class ProductSteps {
    String PARAMETER = "{behavior: \"instant\", block: \"center\", inline: \"center\"}";
    ProductPage productPage = new ProductPage();

    @Step
    public void clickCommentsButton() {
        log.info("Click comments button");
        productPage.getCommentsButton().scrollTo().click();
    }

    @Step
    public void clickQuestionsButton() {
        SelenideElement element = productPage.getQuestionsButton();
        element.scrollTo();
        productPage.getQuestionsCounter().shouldNotHave(text("0"), Duration.ofMillis(5000));
        int number = Utils.extractIntegerFromText(productPage.getQuestionsCounter().getText());
        if (number == 0) {
            log.info("There are no questions");
        } else {
            log.info("There are questions: {}", number);
            log.info("Click questions button");
            productPage.getQuestionsButton().shouldBe(clickable, Duration.ofMillis(2000)).click();
        }
    }

    @Step
    public void clickViewAllCommentsButton() {
        Utils.sleep(1500);
        log.info("Click \"View All Comments\" button");
        productPage.getViewAllCommentsButton().scrollIntoView(PARAMETER).click();
    }

    @Step
    public void clickViewAllQuestionButton() {
        Utils.sleep(1500);
        log.info("CLick \"View All Question\" button");
        productPage.getViewAllQuestionsButton().scrollTo().click();
    }
}
