package simulation;

public class NiceScore {
    private Double niceScore;

    public static class Builder {
        private Double niceScore;
        private Double niceScoreBonus;

        public Builder(final Double niceScore) {
            this.niceScore = niceScore;
        }

        public Builder niceScoreBonus(final Double niceScoreBonus) {
            this.niceScoreBonus = niceScoreBonus;
            return this;
        }

        public NiceScore build() {
            return new NiceScore(this);
        }
    }

    private NiceScore(Builder builder) {
        this.niceScore = builder.niceScore;
        this.niceScore += builder.niceScore * builder.niceScoreBonus / 100;
        if (this.niceScore.compareTo(10d) > 0) {
            this.niceScore = 10d;
        }
    }

    /**
     * getter
     * @return
     */
    public Double getNiceScore() {
        return niceScore;
    }
}
