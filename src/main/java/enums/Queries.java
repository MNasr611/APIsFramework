package enums;

import lombok.Getter;

public enum Queries {
    GETUSERINFOFORSPECIFICLOCATION("SELECT * FROM CustomerInfo WHERE Location = 'Asia' LIMIT 1;");



    @Getter
    private final String value;
    Queries(String value) {
        this.value = value;
    }
}
