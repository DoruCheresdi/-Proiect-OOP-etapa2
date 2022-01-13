package enums;


public enum GiftStrategy {
    ID("id"),

    NICE_SCORE("niceScore"),

    NICE_SCORE_CITY("niceScoreCity");

    private String value;

    GiftStrategy(final String value) {
        this.value = value;
    }

    /**
     * returns the GiftStrategy entity with the given value string
     * @param value
     * @return
     */
    public static GiftStrategy giftStrategyOfValue(final String value) {
        for (GiftStrategy e : values()) {
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
