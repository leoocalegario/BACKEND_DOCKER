package app.auth;

public record User(String password, String clientId, String grantType, String username) {
}