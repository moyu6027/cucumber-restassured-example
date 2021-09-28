package steps;

import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import executors.BaseExecutor;
import models.guest.GuestTokenResponse;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GuestTokenSteps extends BaseExecutor {

    private GuestTokenResponse guestTokenResponse;

    @When("^we send a request to get a guest token$")
    public void SendRequestOnGetTokenGuest() {
        currentResponse = getGuestToken("client_credentials", "guest:default");
        currentResponse.then().log().all();
    }

    @Then("^the server response contains a guest token$")
    public void AnswerServersContendTokenGuest() {
        guestTokenResponse = currentResponse.then().extract().as(GuestTokenResponse.class);
        assertThat(guestTokenResponse.getAccessToken(), is(not(emptyString())));
        guestToken = guestTokenResponse.getAccessToken();
    }

}
