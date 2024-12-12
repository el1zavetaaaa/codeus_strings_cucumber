package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EbayHomeSteps {
    @Given("I am on Ebay Home Page")
    public void i_am_on_ebay_home_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I am on Ebay Home Page");
    }
    @When("I click on Advanced Link")
    public void i_click_on_advanced_link() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I click on Advanced Link");
    }
    @Then("I navigate to Advanced Search page")
    public void i_navigate_to_advanced_search_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("I navigate to Advanced Search page");
    }
}
