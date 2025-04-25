# Automated Tests for the www.wildberries.by

## General info:

* Test 1. Catalog navigation.
* Test 2. Product search.
* Test 3. Service menu navigation.
* Test 4. Select a currency type.
* Test 5. Select a pickup point.
* Test 6. Select a product from the local warehouse.
* Test 7. Select a promotion.
* Test 8. View reviews.
* Test 9. Open product popup.
* Test 10. View questions.
* Test 11. Add product to basket.
* Test 12. Select a frequently asked question (FAQ).
* Test 13. Check information about refund and payment methods.
* Test 14. Search for a question in FAQ.
* Test 15. Sort products by price within set limits.
* Test 16. Sort products by increasing price.
* Test 17. Sort products by decreasing price.
* Test 18. Sort products by newness.
* Test 19. Sort products by rating.
* Test 20. Sort products by benefit.

## Technologies:

* Java 17
* Maven
* TestNG 7.10.2
* Selenide 7.7.1
* Allure 2.29.1
* Apache Log4j 2.24.3
* Gson 2.12.0
* Project Lombok 1.18.36

## Launch:

to run the default test go to project dir and run:

```
mvn clean test
```

to run sort tests in a local Chrome browser:

```
mvn clean test -Dsuite=src/test/resources/local_sort_test.xml
```

to run all tests in a Docker Selenoid browser:

```
mvn clean test -Dsuite=src/test/resources/docker_test.xml
```

## Report:

![Maven TestNG](https://github.com/akavity/wildberries-web/raw/develop/report.jpg)
