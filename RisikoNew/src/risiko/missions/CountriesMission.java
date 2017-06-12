package risiko.missions;

import java.util.List;
import java.util.Map;
import risiko.map.Continent;
import risiko.map.Country;

/**
 * Missione in cui bisogna conquistare <code>nrCountriesToConquer</code>
 * territori.
 *
 */
public class CountriesMission extends Mission {

    private int nrCountriesToConquer;

    public CountriesMission(String description, int points) {
        super(description, points);
    }

    public int getNrCountriesToConquer() {
        return this.nrCountriesToConquer;
    }

    @Override
    public boolean isCompleted(List<Country> countries) {
        return countries.size() >= nrCountriesToConquer;
    }

    @Override
    public void buildTarget(List<Continent> continents) {
        this.nrCountriesToConquer = Integer.parseInt(description.split(" ")[1]);
    }
}
