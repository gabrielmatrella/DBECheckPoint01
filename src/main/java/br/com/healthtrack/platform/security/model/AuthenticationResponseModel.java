package br.com.healthtrack.platform.security.model;

public class AuthenticationResponseModel {

    private String accessToken;

    public AuthenticationResponseModel(String token) {
        this.accessToken = token;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
}
