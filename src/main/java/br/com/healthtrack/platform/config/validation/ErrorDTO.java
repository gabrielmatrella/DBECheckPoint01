package br.com.healthtrack.platform.config.validation;

public class ErrorDTO {

    private final String field;
    private final String message;

    public ErrorDTO(String field, String message) {
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }
}
