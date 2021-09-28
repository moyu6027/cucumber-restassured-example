package models.guest;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class GuestTokenResponse {

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("expires_in")
    private Integer expiresIn;

    @JsonProperty("access_token")
    private String accessToken;

}
