package models.guest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GuestTokenRequest {

    @JsonProperty("grant_type")
    private String grantType;

    @JsonProperty("scope")
    private String scope;

    public GuestTokenRequest(String grantType, String scope) {
        this.grantType = grantType;
        this.scope = scope;
    }
}
