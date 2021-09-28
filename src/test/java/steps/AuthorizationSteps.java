package steps;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import executors.BaseExecutor;
import models.authorization.AuthorizationRequest;
import models.authorization.AuthorizationResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class AuthorizationSteps extends BaseExecutor {

    private AuthorizationRequest authorizationRequest;
    private AuthorizationResponse authorizationResponse;

    @When("^we send an authorization request under the created player$")
    public void sendRequirementNaAuthorizationSubsiddedPlay() {
        authorizationRequest = new AuthorizationRequest(username, userPassword);
        currentResponse = authorizationByCreatedPlayer(authorizationRequest);
        currentResponse.then().log().all();
    }

    @Then("^the server response to the authorization request contains a token$")
    public void AnswerServerNaRequestAuthorizationSocondToken() {
        authorizationResponse = currentResponse.then().extract().as(AuthorizationResponse.class);
        assertThat(authorizationResponse.getAccessToken(), is(not(emptyString())));
        tokenAfterLogin = authorizationResponse.getAccessToken();
    }

}
