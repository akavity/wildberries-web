package org.akavity.steps;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.akavity.pages.FiltersBlockPage;
import org.akavity.utils.Utils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.visible;

@Log4j2
public class FiltersBlockSteps {
    FiltersBlockPage filter = new FiltersBlockPage();

    @Step
    public void clickFilterButton(String button) {
        log.info("Click dropdown-filter button: {}", button);
        filter.getButton(button).click();
    }

    @Step
    public void clickSorterButton() {
        log.info("Click sorter button");
        filter.getSalesButton().shouldBe(visible, Duration.ofSeconds(5));
        filter.getSorterButton().shouldBe(clickable, Duration.ofSeconds(5));
        filter.getSorterButton().click();
    }

    @Step
    public void selectSortType(String type) {
        log.info("Select sort type: {}", type);
        Utils.sleep(1000);
        filter.getRadioButton(type).shouldBe(visible);
        filter.getRadioButton(type).click();
        filter.getTitleField().click();
    }

    @Step
    public void enterMinPrice(String min) {
        log.info("Enter min price: {}", min);
        Utils.cleanFieldAndSetPrice(filter.getMinPrice(), min);
    }

    @Step
    public void enterMaxPrice(String max) {
        log.info("Enter max price: {}", max);
        Utils.cleanFieldAndSetPrice(filter.getMaxPrice(), max);
    }

    @Step
    public void clickPriceReadyButton() {
        log.info("Click \"Price is ready\" button");
        filter.getPriceReadyButton().click();
    }

    @Step
    public void enterMinMaxPrice(String min, String max) {
        log.info("Enter min {} and max {} price", min, max);
        Utils.cleanFieldAndSetPrice(filter.getMinPrice(), min);
        Utils.cleanFieldAndSetPrice(filter.getMaxPrice(), max);
        log.info("Click submit button");
        filter.getPriceReadyButton().click();
    }
}
