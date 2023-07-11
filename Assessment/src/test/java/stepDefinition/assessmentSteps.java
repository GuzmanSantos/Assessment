package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebstarauntCheckOutPage;
import pages.WebstarauntHomePage;
import pages.WebstarauntSearchResultsPage;
import utilities.BrowserUtil;
import utilities.ConfigurationsReader;
import utilities.DriverUtil;

public class assessmentSteps extends BrowserUtil {
    // implement all our elements and methods encapsulated in pages to create test

    WebstarauntHomePage webstarauntHomePage = new WebstarauntHomePage();
    WebstarauntSearchResultsPage webstarauntSearchResultsPage = new WebstarauntSearchResultsPage();
    WebstarauntCheckOutPage webstarauntCheckOutPage = new WebstarauntCheckOutPage();



    @Given("User navigates to the WebstaurantStore homepage")
    public void i_am_on_the_webstaurant_store_homepage() {
        DriverUtil.getDriver().get(ConfigurationsReader.getProperties("webstaurantURL"));
        setWaitTime();
    }

    @When("User searches for {string}")
    public void i_search_for(String searchTerm) {
        webstarauntHomePage.enterSearch("stainless work table");
        webstarauntHomePage.pressSearchButton();
    }

    @Then("User should see search results with the word {string} in the title for every product")
    public void i_should_see_search_results_with_the_word_in_the_title_for_every_product(String string) {
        webstarauntSearchResultsPage.verifyTitle();
    }

    @Then("User adds the last item from the search results to the cart")
    public void i_add_the_last_item_from_the_search_results_to_the_cart() {
        webstarauntSearchResultsPage.clickLast3AddToCartButtons();
        webstarauntSearchResultsPage.clickViewCartButton();
    }

    @Then("User empties the cart")
    public void i_empty_the_cart() {
        webstarauntCheckOutPage.clickFirstEmptyCartButton();
        webstarauntCheckOutPage.clickSecondEmptyCartButton();
        webstarauntCheckOutPage.verifyCartIsEmpty();
    }


}
