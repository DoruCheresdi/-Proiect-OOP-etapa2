package enums;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum ElvesType {

    @JsonProperty("yellow")
    YELLOW("yellow"),

    @JsonProperty("black")
    BLACK("black"),

    @JsonProperty("pink")
    PINK("pink"),

    @JsonProperty("white")
    WHITE("white");

    private String value;

    ElvesType(final String value) {
        this.value = value;
    }

    /**
     * returns the ElvesType entity with the given value string
     * @param value
     * @return
     */
    public static ElvesType elvesTypeOfValue(final String value) {
        for (ElvesType e : values()) {
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
