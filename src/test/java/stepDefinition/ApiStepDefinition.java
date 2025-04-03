package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStepDefinition {

    ApiPage apiPage;

    public ApiStepDefinition() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare URL for {string}")
    public void prepareURLFor(String url) {
        apiPage.prepareURLFor(url);
    }

    @Then("validation status code is equal to {int}")
    public void validationStatusCodeIsEqualsTo(int status_code) {
        apiPage.validationStatusCodeIsEqualsTo(status_code);
    }

    @Then("validation response JSON with JSONSchema {string}")
    public void validationResponseJSONWithJSONSchema(String filename) {
        apiPage.validationResponseJSONWithJSONSchema(filename);
    }

    @And("hit api GET list users")
    public void hitApiGETListUsers() {
        apiPage.hitApiGETListUsers();
    }

    @Then("validation response body GET list users")
    public void validationResponseBodyGETListUsers() {
        apiPage.validationResponseBodyGETListUsers();
    }

    @And("hit api GET list specific users")
    public void hitApiGETListSpecificUsers() {
        apiPage.hitApiGETListSpecificUsers();
    }

    @Then("validation response body GET list specific user")
    public void validationResponseBodyGETListSpecificUser() {
        apiPage.validationResponseBodyGETListSpecificUser();
    }

    @And("hit api GET list data invalid users")
    public void hitApiGETListDataInvalidUsers() {
        apiPage.hitApiGETListDataInvalidUsers();
    }

    @Then("validation response body GET list invalid user")
    public void validationResponseBodyGETListInvalidUser() {
        apiPage.validationResponseBodyGETListInvalidUser();
    }

    @And("hit api POST new user")
    public void hitApiPOSTNewUser() {
        apiPage.hitApiPOSTNewUser();
    }

    @Then("validation response body POST new users")
    public void validationResponseBodyPOSTNewUsers() {
        apiPage.validationResponseBodyPOSTNewUsers();
    }

    @And("hit api POST new user using existing email")
    public void hitApiPOSTNewUserUsingExistingEmail() {
        apiPage.hitApiPOSTNewUserUsingExistingEmail();
    }

    @Then("validation response body POST new user using existing email")
    public void validationResponseBodyPOSTNewUserUsingExistingEmail() {
        apiPage.validationResponseBodyPOSTNewUserUsingExistingEmail();
    }

    @And("hit api POST new user using invalid gender and status")
    public void hitApiPOSTNewUserUsingInvalidGenderAndStatus() {
        apiPage.hitApiPOSTNewUserUsingInvalidGenderAndStatus();
    }

    @Then("validation response body POST new user using invalid gender and status")
    public void validationResponseBodyPOSTNewUserUsingInvalidGenderAndStatus() {
        apiPage.validationResponseBodyPOSTNewUserUsingInvalidGenderAndStatus();
    }

    @And("hit api PATCH update user")
    public void hitApiPATCHUpdateUser() {
        apiPage.hitApiPATCHUpdateUser();
    }

    @Then("validation response body PATCH update user")
    public void validationResponseBodyPATCHUpdateUser() {
        apiPage.validationResponseBodyPATCHUpdateUser();
    }

    @And("hit api DELETE user")
    public void hitApiDELETEUser() {
        apiPage.hitApiDELETEUser();
    }

    @And("hit api DELETE invalid user")
    public void hitApiDELETEInvalidUser() {
        apiPage.hitApiDELETEInvalidUser();
    }

    @Then("validation response body DELETE invalid user")
    public void validationResponseBodyDELETEInvalidUser() {
        apiPage.validationResponseBodyDELETEInvalidUser();
    }
}
