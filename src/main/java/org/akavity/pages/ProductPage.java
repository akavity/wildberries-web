package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class ProductPage {
    private final SelenideElement commentsButton = $(By.cssSelector("button[id='a-Comments']"));
    private final SelenideElement questionsButton = $(By.xpath("//button[contains(text(),'Вопросы')]/.."));
    private final SelenideElement viewAllCommentsButton = $(By.cssSelector("div[class*='comments'] a[class*='comments__btn-all']"));
    private final SelenideElement viewAllQuestionsButton = $(By.cssSelector("div[class*='questions'] a[class*='comments__btn-all']"));
    private final SelenideElement aboutProductField = $(By.cssSelector("h2[class*='richPreviewHeader']"));
    private final SelenideElement questionsCounter = $(By.cssSelector("li[data-content*='Questions'] span[class='user-activity__count']"));

    public SelenideElement getCommentsButton() {
        return commentsButton;
    }

    public SelenideElement getQuestionsButton() {
        return questionsButton;
    }

    public SelenideElement getViewAllCommentsButton() {
        return viewAllCommentsButton;
    }

    public SelenideElement getViewAllQuestionsButton() {
        return viewAllQuestionsButton;
    }

    public SelenideElement getAboutProductField() {
        return aboutProductField;
    }

    public SelenideElement getQuestionsCounter() {
        return questionsCounter;
    }
}
