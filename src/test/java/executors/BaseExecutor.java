package executors;

import constants.Endpoints;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.authorization.AuthorizationRequest;
import models.guest.GuestTokenRequest;
import models.register.RegisterPlayerRequest;

import static io.restassured.RestAssured.given;
import static utils.Util.convertStringToBase64;

public class BaseExecutor {

    private final String authorizationBasicHeader = "Basic " + convertStringToBase64("front_2d6b0a8391742f5d789d7d915755e09e:");
    public static Response currentResponse;
    public static String guestToken;
    public static String tokenAfterLogin;
    public static Integer userId;
    public static String username;
    public static String userPassword;
    public static String userEmail;


    private RequestSpecification requestSpecification = new RequestSpecBuilder()
            .setBaseUri(Endpoints.BASE_URL)
            .setContentType(ContentType.JSON)
            .setAccept(ContentType.JSON)
            .log(LogDetail.ALL)
            .addFilter(new AllureRestAssured())
            .build();

    /**
     * POST
     */
    public Response getGuestToken(String grantType, String scope) {

        return given()
                .spec(requestSpecification)
                .header("Authorization", authorizationBasicHeader)
                .body(new GuestTokenRequest(grantType, scope))
                .post(Endpoints.CLIENT_CREDENTIALS_GRANT);
    }

    /**
     * POST
     */
    public Response registerPlayer(RegisterPlayerRequest body, String guestToken) {
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + guestToken)
                .body(body)
                .post(Endpoints.REGISTRATION);
    }

    /**
     * POST
     */
    public Response authorizationByCreatedPlayer(AuthorizationRequest body) {
        return given()
                .spec(requestSpecification)
                .header("Authorization", authorizationBasicHeader)
                .body(body)
                .post(Endpoints.AUTHORIZATION);
    }

    /**
     * GET
     */
    public Response getUserProfile(Integer userId, String tokenAfterLogin) {
        return given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + tokenAfterLogin)
                .get(Endpoints.GET_PROFILE + userId);
    }
}
