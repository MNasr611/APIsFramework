package enums;

import lombok.Getter;


public enum Endpoints {
    GETUSERS("/users"),
    POSTS("/posts");



    @Getter
    private final String value;
    Endpoints(String value) {
        this.value = value;
    }
}
