package enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Cities {

    @JsonProperty("Bucuresti")
    BUCURESTI("Bucuresti"),

    @JsonProperty("Constanta")
    CONSTANTA("Constanta"),

    @JsonProperty("Buzau")
    BUZAU("Buzau"),

    @JsonProperty("Timisoara")
    TIMISOARA("Timisoara"),

    @JsonProperty("Cluj-Napoca")
    CLUJ("Cluj-Napoca"),

    @JsonProperty("Iasi")
    IASI("Iasi"),

    @JsonProperty("Craiova")
    CRAIOVA("Craiova"),

    @JsonProperty("Brasov")
    BRASOV("Brasov"),

    @JsonProperty("Braila")
    BRAILA("Braila"),

    @JsonProperty("Oradea")
    ORADEA("Oradea");

    private String value;

    Cities(final String value) {
        this.value = value;
    }

    /**
     * returns the Cities entity with the given value string
     * @param value
     * @return
     */
    public static Cities cityOfValue(final String value) {
        for (Cities e : values()) {
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
