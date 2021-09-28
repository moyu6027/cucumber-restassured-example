package models.authorization;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AuthorizationRequest {

    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    public AuthorizationRequest(String username, String password) {
        this.grantType = "password";
        this.username = username;
        this.password = password;
    }


}
