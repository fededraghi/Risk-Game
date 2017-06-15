package risiko.phase;

import risiko.map.Country;
import risiko.map.RisikoMap;

public class ReinforcePhase extends Phase {

    public ReinforcePhase(RisikoMap map) {
        super(map);
        this.index = REINFORCE_INDEX;
    }

    public void reinforce(Country country) {
        map.reinforce(country);
    }

    @Override
    public String toString() {
        return "REINFORCE";
    }

}
