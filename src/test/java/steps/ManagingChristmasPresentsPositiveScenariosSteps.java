package steps;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.entity.Present;
import org.example.service.PresentService;

import java.util.List;
import java.util.Set;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class ManagingChristmasPresentsPositiveScenariosSteps {
    private PresentService presentService = new PresentService();

    @BeforeAll
    public void setUp(){
        Set<Present> presents = Set.of(new Present("Lego Set", "A colorful building set"),
                new Present("Chocolate Box", "A box of delicious sweets"),
                new Present("Remote Control Car", "A fun RC car"));
        presents.forEach(present -> presentService.addPresent(present));
    }

    @Given("the giftList contains some presents")
    public void i_am_on_ebay_home_page() {

    }

    @Given("the gift list contains a present with name {string} and description {string}")
    public void the_gift_list_contains_a_present_with_name_and_description(String string, String string2) {
        presentService.addPresent(new Present("Toy Car", "A remote-controlled car"));
    }

    @When("I add a present with name {string} and description {string}")
    public void i_add_a_present_with_name_and_description(String name, String description) {
        presentService.addPresent(new Present(name, description));
    }

    @When("I remove a present with name {string} and description \"A colorful building set\"")
    public void i_remove_a_present_with_name_and_description(String name) {
        presentService.removePresent(name);
    }
    @When("I add a new present with name {string} and description \"\"Cutting-edge performance with stunning display and camera.\"")
    public void i_add_a_new_present_with_name_and_description_cutting_edge_performance_with_stunning_display_and_camera(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("the gift list should contain a present with the name {string}")
    public void the_gift_list_should_contain_a_present_with_the_name(String name) {
        List<Present> matchingPresents = presentService.getGiftList().stream()
                .filter(p -> p.getName().equals(name))
                .toList();
        assertFalse(matchingPresents.isEmpty());
        assertEquals(matchingPresents.get(0).getName(), name);
    }

    @Then("the gift list should not contain a present with name {string}")
    public void the_gift_list_should_not_contain_a_present_with_name(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("the gift should contain a present named {string}")
    public void the_gift_should_contain_a_present_named(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
