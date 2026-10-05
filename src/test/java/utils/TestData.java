package utils;

public class TestData {

    public static final String LOGO_TEXT = "Swag Labs";

    public static final String ERROR_EMPTY_USERNAME =
            "Epic sadface: Username is required";
    public static final String ERROR_EMPTY_PASSWORD =
            "Epic sadface: Password is required";
    public static final String ERROR_LOCKED_USER =
            "Epic sadface: Sorry, this user has been locked out.";
    public static final String ERROR_WRONG_CREDENTIALS =
            "Epic sadface: Username and password do not match any user in this service";

    public static String getLoginError(String errorType) {

        return switch (errorType) {
            case "locked user" -> ERROR_LOCKED_USER;
            case "wrong credentials" -> ERROR_WRONG_CREDENTIALS;
            case "empty username" -> ERROR_EMPTY_USERNAME;
            case "empty password" -> ERROR_EMPTY_PASSWORD;
            default -> throw new IllegalArgumentException("Unknown error type: " + errorType);

        };
    }
}
