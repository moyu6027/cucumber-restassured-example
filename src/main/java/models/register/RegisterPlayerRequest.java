package models.register;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import static utils.Util.convertStringToBase64;
import static utils.Util.generateRandomValue;

@Data
public class RegisterPlayerRequest {

    @JsonProperty("username")
    private String username;

    @JsonProperty("password_change")
    private String passwordChange;

    @JsonProperty("password_repeat")
    private String passwordRepeat;

    @JsonProperty("email")
    private String email;

    @JsonProperty("name")
    private String name;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("currency_code")
    private String currencyCode;

    public RegisterPlayerRequest() {
        String uniqueName = "test_user_" + generateRandomValue();
        String password = convertStringToBase64("password_example");
        username = uniqueName;
        passwordChange = password;
        passwordRepeat = password;
        email = uniqueName + "@example.com";
    }

}
