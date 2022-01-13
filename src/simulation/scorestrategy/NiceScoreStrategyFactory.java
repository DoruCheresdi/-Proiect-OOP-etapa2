package simulation.scorestrategy;

import enums.ChildType;

public class NiceScoreStrategyFactory {
    /**
     * Method that returns the appropriate strategy for calculating average nice score
     * @param childType
     * @return
     */
    public NiceScoreStrategy getNiceScoreStrategy(final ChildType childType) {
        switch (childType) {
            case BABY: return new BabyStrategy();
            case KID: return new KidStrategy();
            case TEEN: return new TeenStrategy();
            default: throw new IllegalArgumentException("This nice score strategy type is invalid");
        }
    }
}
