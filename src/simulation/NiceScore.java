package simulation;

import common.SimulationConstants;

public final class NiceScore {
    private Double niceScore;

    public static class Builder {
        private Double niceScore;
        private Double niceScoreBonus;

        public Builder(final Double niceScore) {
            this.niceScore = niceScore;
        }

        /**
         * method to add niceScoreBonus
         * @param niceScoreBonusAdd nicescore
         * @return builder
         */
        public Builder niceScoreBonus(final Double niceScoreBonusAdd) {
            this.niceScoreBonus = niceScoreBonusAdd;
            return this;
        }

        /**
         * Method to finish build
         * @return
         */
        public NiceScore build() {
            return new NiceScore(this);
        }
    }

    private NiceScore(final Builder builder) {
        this.niceScore = builder.niceScore;
        this.niceScore += builder.niceScore * builder.niceScoreBonus
                / SimulationConstants.ONE_HUNDRED;
        if (this.niceScore.compareTo(SimulationConstants.MAX_SCORE) > 0) {
            this.niceScore = SimulationConstants.MAX_SCORE;
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
