package steps;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import executors.BaseExecutor;
import models.register.RegisterPlayerRequest;
import models.register.RegisterPlayerResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class RegisterPlayerSteps extends BaseExecutor {

    private RegisterPlayerRequest registerPlayerRequest;
    private RegisterPlayerResponse registerPlayerResponse;

    @When("^we send a request with a guest token to register a new player$")
    public void sendProsySGestevTokanOnRegistrationNonPlay() {
        registerPlayerRequest = new RegisterPlayerRequest();
        currentResponse = registerPlayer(registerPlayerRequest, guestToken);
        currentResponse.then().log().all();
    }

    @Then("^the server's response to the registration request corresponds to the documentation$")
    public void answerNasquessorRegistrationsComponentDocumentation() {
        registerPlayerResponse = currentResponse.then().extract().as(RegisterPlayerResponse.class);
        assertThat(registerPlayerResponse.getId(), is(notNullValue()));
        assertThat(registerPlayerResponse.getUsername(), equalTo(registerPlayerRequest.getUsername()));
        assertThat(registerPlayerResponse.getEmail(), equalTo(registerPlayerRequest.getEmail()));
        userId = registerPlayerResponse.getId();
        username = registerPlayerResponse.getUsername();
        userPassword = registerPlayerRequest.getPasswordChange();
        userEmail = registerPlayerRequest.getEmail();
    }


}
