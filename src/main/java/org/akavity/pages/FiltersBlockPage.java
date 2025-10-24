package org.akavity.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class FiltersBlockPage {
    private final SelenideElement titleField = $(By.cssSelector("[class='catalog-title']"));
    private final SelenideElement salesButton = $(By.xpath("//span[text()='РАСПРОЖАРА']/.."));
    private final SelenideElement minPrice = $(By.xpath("//div[@data-testid='catalog-filter']//div[contains(@class,'filter__price')]//input[contains(@name,'start')]/.."));
    private final SelenideElement maxPrice = $(By.cssSelector("div[data-testid='catalog-filter'] div[class*='filter__price'] input[name*='end']"));
    private final SelenideElement priceReadyButton = $(By.xpath("//div[@data-testid='catalog-filter']//button[contains(.,'Готово')]"));
    private final SelenideElement sorterButton = $(By.xpath("//button[contains(@class,'sorter')]/.."));
    private final SelenideElement allFiltersButton = $(By.cssSelector("button[class*='filter__btn--all']"));

    public SelenideElement getButton(String name) {
        return $(By.xpath("//div[@data-testid='catalog-filter']/button[contains(.,'" + name + "')]"));
    }

    public SelenideElement getRadioButton(String name) {
        return $(By.xpath("//span[contains(@class,'radio-with-text') and contains(.,'" + name + "')]/../.."));
    }

    public SelenideElement getCheckBox(String name) {
        return $(By.xpath("//span[@class='checkbox-with-text__text' and .='" + name + "']"));
    }

    public SelenideElement getTitleField() {
        return titleField;
    }

    public SelenideElement getSalesButton() {
        return salesButton;
    }

    public SelenideElement getMinPrice() {
        return minPrice;
    }

    public SelenideElement getMaxPrice() {
        return maxPrice;
    }

    public SelenideElement getPriceReadyButton() {
        return priceReadyButton;
    }

    public SelenideElement getSorterButton() {
        return sorterButton;
    }

    public SelenideElement getAllFiltersButton() {
        return allFiltersButton;
    }
}
