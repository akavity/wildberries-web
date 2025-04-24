package org.akavity.tests;

import org.akavity.annotations.TestData;
import org.akavity.models.sortTest.*;
import org.akavity.steps.CatalogSteps;
import org.akavity.steps.FiltersBlockSteps;
import org.akavity.steps.HeaderSteps;
import org.akavity.steps.NavigationSteps;
import org.akavity.utils.JsonReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SortTest extends BaseTest {
    HeaderSteps headerSteps = new HeaderSteps();
    NavigationSteps navigationSteps = new NavigationSteps();
    FiltersBlockSteps filtersBlockSteps = new FiltersBlockSteps();
    CatalogSteps catalogSteps = new CatalogSteps();

    @TestData(jsonFile = "priceData", model = "PriceData", folder = "sortTest")
    @Test(description = "Sort products by price within set limits", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void sortProductsByPrice(PriceData price) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(price.getMainListItem());
        navigationSteps.clickDropListItem(price.getMainListItem(), price.getFirstDropListItem(), price.getSecondDropListItem());
        filtersBlockSteps.clickFilterButton(price.getButton());
        filtersBlockSteps.enterMinMaxAmount(price.getMinPrice(), price.getMaxPrice());

        Assert.assertTrue(catalogSteps.areProductPricesWithinLimit(price.getMinPrice(), price.getMaxPrice()));
    }

    @TestData(jsonFile = "increasingPriceData", model = "IncreasingPriceData", folder = "sortTest")
    @Test(description = "Sort products by increasing price", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void sortByIncreasingPrice(IncreasingPriceData ascendingPrice) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(ascendingPrice.getMainListItem());
        navigationSteps.clickDropListItem(ascendingPrice.getMainListItem(), ascendingPrice.getFirstDropListItem(), ascendingPrice.getSecondDropListItem());
        filtersBlockSteps.clickSorterButton();
        filtersBlockSteps.selectSortType(ascendingPrice.getSortType());

        Assert.assertTrue(catalogSteps.checkSortByAscendingPrice(ascendingPrice.getElements()));
    }

    @TestData(jsonFile = "decreasingPriceData", model = "DecreasingPriceData", folder = "sortTest")
    @Test(description = "Sort products by decreasing price", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void sortByDecreasingPrice(DecreasingPriceData decreasingPrice) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(decreasingPrice.getMainListItem());
        navigationSteps.clickDropListItem(decreasingPrice.getMainListItem(), decreasingPrice.getFirstDropListItem(), decreasingPrice.getSecondDropListItem());
        filtersBlockSteps.clickSorterButton();
        filtersBlockSteps.selectSortType(decreasingPrice.getSortType());

        Assert.assertTrue(catalogSteps.checkSortByDecreasingPrice(decreasingPrice.getElements()));
    }

    @TestData(jsonFile = "noveltyData", model = "NoveltyData", folder = "sortTest")
    @Test(description = "Sort products by newness", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void sortByNewness(NoveltyData noveltyData) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(noveltyData.getMainListItem());
        navigationSteps.clickDropListItem(noveltyData.getMainListItem(), noveltyData.getFirstDropListItem(), noveltyData.getSecondDropListItem());
        filtersBlockSteps.clickSorterButton();
        filtersBlockSteps.selectSortType(noveltyData.getSortType());

        Assert.assertTrue(catalogSteps.checkNewTips(noveltyData.getElements()));
    }

    @TestData(jsonFile = "ratingData", model = "RatingData", folder = "sortTest")
    @Test(description = "Sort products by rating", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void sortByRating(RatingData ratingData) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(ratingData.getMainListItem());
        navigationSteps.clickDropListItem(ratingData.getMainListItem(), ratingData.getFirstDropListItem(), ratingData.getSecondDropListItem());
        filtersBlockSteps.clickSorterButton();
        filtersBlockSteps.selectSortType(ratingData.getSortType());

        Assert.assertTrue(catalogSteps.checkRatingTips(ratingData.getElements(), ratingData.getMinRating()));
    }

    @TestData(jsonFile = "benefitData", model = "BenefitData", folder = "sortTest")
    @Test(description = "Sort products by benefit", dataProviderClass = JsonReader.class, dataProvider = "getData")
    public void sortByBenefit(BenefitData benefitData) {
        headerSteps.clickCatalogButton();
        navigationSteps.clickMainListItem(benefitData.getMainListItem());
        navigationSteps.clickDropListItem(benefitData.getMainListItem(), benefitData.getFirstDropListItem(), benefitData.getSecondDropListItem());
        filtersBlockSteps.clickSorterButton();
        filtersBlockSteps.selectSortType(benefitData.getSortType());

        Assert.assertTrue(catalogSteps.checkSaleTips(benefitData.getElements()));
    }
}
