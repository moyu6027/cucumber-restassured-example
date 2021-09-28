package steps;

import cucumber.api.java.en.Then;
import executors.BaseExecutor;

public class CommonSteps extends BaseExecutor {

    @Then("^the server response code (\\d+)$")
    public void AnswerProfileRequestHasStatusCode(int statusCode) {
        currentResponse.then().statusCode(statusCode);
    }
}
