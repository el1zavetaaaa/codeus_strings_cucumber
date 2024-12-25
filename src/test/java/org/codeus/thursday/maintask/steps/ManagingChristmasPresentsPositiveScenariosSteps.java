package org.codeus.thursday.maintask.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.codeus.thursday.maintask.entity.Present;
import org.codeus.thursday.maintask.service.PresentService;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ManagingChristmasPresentsPositiveScenariosSteps {
    private final PresentService presentService = new PresentService();
    private Exception caughtException;

    @Given("the giftList contains some presents:")
    public void the_gift_list_contains_some_presents(List<Map<String, String>> presents) {
        presents.stream()
                .map(presentDetails -> new Present(presentDetails.get("name"), presentDetails.get("description")))
                .forEach(presentService::addPresent);
    }

    @When("I add a present with name {string} and description {string}")
    public void i_add_a_present_with_name_and_description(String name, String description) {
        try {
            presentService.addPresent(new Present(name, description));
        } catch (Exception exception) {
            caughtException = exception;
        }
    }

    @When("I remove the following presents:")
    public void i_remove_the_following_presents(List<Map<String, String>> presentsToRemove) {
        presentsToRemove.stream()
                .map(present -> present.get("name"))
                .forEach(presentService::removePresent);
    }

    @When("I remove a present with name {string}")
    public void i_remove_a_present_with_name(String name) {
        try {
            presentService.removePresent(name);
        } catch (Exception exception) {
            caughtException = exception;
        }
    }

    @Then("the gift list should (still) contain a present with the name {string}")
    public void the_gift_list_should_still_contain_a_present_with_name(String name) {
        assertTrue(String.format("Gift list should contain a present with name %s", name),
                giftListContainsPresentWithTheName(name));
    }

    @Then("the gift list should not contain a present with name {string}")
    public void the_gift_list_should_not_contain_a_present_with_name(String name) {
        assertFalse(String.format("Gift list should contain a present with name %s", name),
                giftListContainsPresentWithTheName(name));
    }


    @Then("I should receive an error saying {string}")
    public void i_should_receive_an_error_saying(String errorMessage) {
        assertEquals(caughtException.getMessage(), errorMessage);
    }

    private boolean giftListContainsPresentWithTheName(final String name) {
        return presentService.getGiftList().stream()
                .anyMatch(present -> present.getName().equals(name));
    }


}
