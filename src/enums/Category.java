package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Category {

    @JsonProperty("Board Games")
    BOARD_GAMES("Board Games"),

    @JsonProperty("Books")
    BOOKS("Books"),

    @JsonProperty("Clothes")
    CLOTHES("Clothes"),

    @JsonProperty("Sweets")
    SWEETS("Sweets"),

    @JsonProperty("Technology")
    TECHNOLOGY("Technology"),

    @JsonProperty("Toys")
    TOYS("Toys");

    private String value;

    Category(final String value) {
        this.value = value;
    }

    /**
     * returns the Category entity with the given value string
     * @param value
     * @return
     */
    public static Category categoryOfValue(final String value) {
        for (Category e : values()) {
            if (e.value.equals(value)) {
                return e;
            }
        }
        return null;
    }

    /**
     * getter
     * @return
     */
    public String getValue() {
        return value;
    }
}
