package thursday.maintask.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

/**
 * The ManagingChristmasPresentsPositiveScenariosSteps class is responsible for defining step definitions for Cucumber feature files related to test scenarios
 * for managing a gift list in the "Managing Christmas Presents" system. This class interacts with the PresentService to validate and manage operations
 * such as adding and removing presents while ensuring that the system's behavior aligns with the expected outcomes defined in the feature files.
 * ***/
public class ManagingChristmasPresentsPositiveScenariosSteps {
//   The caughtException field is used to capture exceptions thrown during the execution of When steps (e.g., adding a present or removing a present).
//    It enables the validation of expected errors in Then steps, ensuring that the correct exception and error message are raised when an operation fails.
    private Exception caughtException;

    /**
     * Step 1: Define the initial state of the gift list with some presents.
     *
     * @param presents List of maps where each map contains present details (name and description).
     */
    @Given("text you write in a feature under the given keyword")
    public void the_gift_list_contains_some_presents(List<Map<String, String>> presents) {
        // TODO: Step-by-step algorithm:
        // 1. Iterate over the list of maps (`presents`).
        // 2. For each map, extract the `name` and `description` keys.
        // 3. Create a new `Present` object using the extracted details.
        // 4. Add each `Present` object to the `presentService` gift list using the `addPresent` method.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Step 2: Add a new present with the specified name and description to the gift list.
     *
     * @param name        The name of the present to add.
     * @param description The description of the present to add.
     */
    @When("text you write in a feature under the when keyword")
    public void i_add_a_present_with_name_and_description(String name, String description) {
        // TODO: Step-by-step algorithm:
        // 1. Wrap the operation in a try-catch block to handle exceptions.
        // 2. Inside the try block:
        //    a. Create a new `Present` object using the provided `name` and `description`.
        //    b. Add the new `Present` to the `presentService` gift list using the `addPresent` method.
        // 3. In the catch block:
        //    a. Capture any exception thrown by the `addPresent` method.
        //    b. Assign the exception to the `caughtException` field for later validation in `Then` steps.
        throw new UnsupportedOperationException("Method not implemented");
    }

    /**
     * Step 3: Verify that the gift list still contains a present with the specified name.
     *
     * @param name The name of the present to check in the gift list.
     */
    @Then("text you write in a feature under the then keyword")
    public void the_gift_list_should_still_contain_a_present_with_name(String name) {
        // TODO: Step-by-step algorithm:
        // 1. Use the `presentService` to retrieve the current gift list.
        // 2. Check if any present in the gift list has the specified `name`.
        //    a. Use a stream or loop to compare the `name` of each present in the list.
        // 3. Use an assertion (e.g., `assertTrue`) to verify that the present exists in the gift list.
        throw new UnsupportedOperationException("Method not implemented");
    }
}
