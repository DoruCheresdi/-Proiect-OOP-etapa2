package utils;

import enums.Cities;

public class CityPair {
    private Cities city;
    private Double averageNiceScore;

    public CityPair(final Cities city, final Double averageNiceScore) {
        this.city = city;
        this.averageNiceScore = averageNiceScore;
    }

    /**
     * getter
     * @return
     */
    public Cities getCity() {
        return city;
    }

    /**
     * setter
     * @param city
     */
    public void setCity(final Cities city) {
        this.city = city;
    }

    /**
     * getter
     * @return
     */
    public Double getAverageNiceScore() {
        return averageNiceScore;
    }

    /**
     * setter
     * @param averageNiceScore
     */
    public void setAverageNiceScore(final Double averageNiceScore) {
        this.averageNiceScore = averageNiceScore;
    }
}
