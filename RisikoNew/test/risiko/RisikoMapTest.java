package risiko;

import risiko.map.Country;
import risiko.map.RisikoMap;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import risiko.map.Continent;
import risiko.missions.ContinentsMission;
import risiko.players.Player;

public class RisikoMapTest {

    private final int N_COUNTRIES = 42;
    private List<Player> players;
    private RisikoMap instance;

    public RisikoMapTest() {
        players = new ArrayList<>();
        players.add(new Player("player1", "RED"));
        players.add(new Player("player2", "GREEN"));
        instance = new RisikoMap();
        instance.initGame(players);
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of assignMissionToPlayers method, of class RisikoMap.
     */
    @Test
    public void testAssignMissionToPlayers() {
        System.out.println("assignMissionToPlayers");
        instance.assignMissionToPlayers(players);
        players.stream().forEach((player) -> {
            assertNotNull(player.getMission());
        });
    }

    /**
     * Test of assignCountriesToPlayers method, of class RisikoMap.
     */
    @Test
    public void testAssignCountriesToPlayers() {
        System.out.println("assignCountriesToPlayers");
        instance.assignCountriesToPlayers(players);
        players.stream().forEach((player) -> {
            assertNotNull(instance.getMyCountries(player));
        });

    }

    /**
     * Test of getCountriesList method, of class RisikoMap.
     */
    @Test
    public void testGetCountriesList() {
        System.out.println("getCountriesList");
        List<Country> result = instance.getCountriesList();
        assertNotNull(result);
        assertEquals(result.size(), N_COUNTRIES);
    }

    /**
     * Test of getPlayerByCountry method, of class RisikoMap.
     */
    @Test
    public void testGetPlayerByCountry() {
        //instance.initGame(players);
        System.out.println("getPlayerByCountry");
        for (Country country : instance.getCountriesList()) {
            Player owner = instance.getPlayerByCountry(country);
            assertTrue(instance.getMyCountries(owner).contains(country));
        }
    }

    /**
     * Test of computeBonusArmies method, of class RisikoMap.
     */
    @Test
    public void testComputeBonusArmies() {
        //instance.initGame(players);
        System.out.println("computeBonusArmies");
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            instance.computeBonusArmies(player);
            double bonusArmies = player.getBonusArmies();
            double nrCountries = instance.getMyCountries(player).size();
            assertTrue((bonusArmies) >= Math.floor(nrCountries / 3));
            //Maggiore uguale perchè non calcolo il bonus derivante dai continenti
        }
    }

///**
//     * Test of hasConqueredContinent method, of class RisikoMap.
//     */
//    @Test
//    public void testHasConqueredContinent() {
//        System.out.println("hasConqueredContinent");
//        Player player = players.get(0);
//        Country country = instance.getMyCountries(player).get(0);
//        Continent continent = instance.getContinentByCountry(country);
//        for (Country c : continent.getCountries()) {
//            if (instance.getPlayerByCountry(c) != player) {
//                instance.updateOnConquer(country, c);
//            }
//        }
//
//        boolean result = instance.hasConqueredContinent(player, country);
//        assertTrue(result);
//        Player otherPlayer = players.get(1);
//        Country otherCountry = instance.getMyCountries(otherPlayer).get(0);
//
//        for (Country c : continent.getCountries()) {
//            if (c != country) {
//                instance.updateOnConquer(otherCountry, c);        
//                break;
//            }
//        }
//        result = instance.hasConqueredContinent(player, country);
//        assertFalse(result);
//    }
    /**
     * Test of getContinentByCountry method, of class RisikoMap.
     */
    @Test
    public void testGetContinentByCountry() {
        System.out.println("getContinentByCountry");
        //instance.initGame(players);
        String[] countries = {"Alaska", "Venezuela", "Ucraina", "Madagascar", "India", "Indonesia"};
        String[] continents = {"Nord America", "Sud America", "Europa", "Africa", "Asia", "Oceania"};
        int i = 0;
        for (String countryName : countries) {
            Country country = instance.getCountryByName(countryName);
            Continent continent = instance.getContinentByCountry(country);
            assertEquals(continents[i], continent.getName());
            i++;
        }
    }

    /**
     * Test of getMyCountries method, of class RisikoMap.
     */
    @Test
    public void testGetMyCountries() {
        System.out.println("getMyCountries");
        List<Player> newPlayers = (List<Player>) ((ArrayList) players).clone();
        for (int i = 0; i < 4; i++) {
            newPlayers.add(new Player("", ""));
            instance.initGame(newPlayers);
            int total = 0;
            for (Player player : newPlayers) {
                List<Country> myCountries = instance.getMyCountries(player);
                total += myCountries.size();
                assertNotNull(myCountries);
                for (Country country : myCountries) {
                    assertNotNull(country);
                }
                assertTrue(Math.abs(myCountries.size() - N_COUNTRIES / (newPlayers.size())) <= 1);
            }
            assertEquals(N_COUNTRIES, total);
        }
    }

    /**
     * Test of getNeighbors method, of class RisikoMap.
     */
    @Test
    public void testGetNeighbors() {
        System.out.println("getNeighbors");
        //instance.initGame(players);
        Country country = instance.getCountryByName("Alaska");
        List<Country> result = instance.getNeighbors(country);
        assertNotNull(result);
    }

    /**
     * Test of playerCanAttack method, of class RisikoMap.
     */
    @Test
    public void testPlayerCanAttack() {
        System.out.println("playerCanAttack");
        //instance.initGame(players);

        for (Country country : instance.getCountriesList()) {
            country.setArmies(1);
        }
        assertFalse(instance.playerCanAttack(players.get(0)));
        assertFalse(instance.playerCanAttack(players.get(1)));

        for (Country country : instance.getCountriesList()) {
            country.setArmies(3);
        }
        assertTrue(instance.playerCanAttack(players.get(0)));
        assertTrue(instance.playerCanAttack(players.get(1)));

    }

    /**
     * Test of controlAttacker method, of class RisikoMap.
     */
    @Test
    public void testControlAttacker() {
        System.out.println("controlAttacker");
        //instance.initGame(players);
        Player player0 = players.get(0);
        Player player1 = players.get(1);
        for (int i = 0; i < instance.getMyCountries(player0).size(); i++) {
            Country countryOfPlayer0 = instance.getMyCountries(player0).get(i);
            countryOfPlayer0.setArmies(3);
            assertTrue(instance.controlAttacker(countryOfPlayer0, player0));
        }
        for (int i = 0; i < instance.getMyCountries(player0).size(); i++) {
            Country countryOfPlayer0 = instance.getMyCountries(player0).get(i);
            countryOfPlayer0.setArmies(3);
            assertFalse(instance.controlAttacker(countryOfPlayer0, player1));
        }
        for (int i = 0; i < instance.getMyCountries(player0).size(); i++) {
            Country countryOfPlayer0 = instance.getMyCountries(player0).get(i);
            countryOfPlayer0.setArmies(1);
            assertFalse(instance.controlAttacker(countryOfPlayer0, player0));
        }
        for (int i = 0; i < instance.getMyCountries(player0).size(); i++) {
            Country countryOfPlayer0 = instance.getMyCountries(player0).get(i);
            countryOfPlayer0.setArmies(1);
            assertFalse(instance.controlAttacker(countryOfPlayer0, player1));
        }
    }

    /**
     * Test of controlFromCountryPlayer method, of class RisikoMap.
     */
    @Test
    public void testControlFromCountryPlayer() {//qualcosa non torna
        System.out.println("controlFromCountryPlayer");
        //instance.initGame(players);
        Country country = instance.getCountryByName("Alaska");
        Player player0 = players.get(0);

        boolean expResult = false;
        Player subjectPlayer = instance.getPlayerByCountry(country);
        for (Country neighbor : country.getNeighbors()) {
            Player neighborPlayer = instance.getPlayerByCountry(neighbor);
            if (neighborPlayer.equals(subjectPlayer)) {
                expResult = true;
            }
        }
        expResult = country.getArmies() > 1 && subjectPlayer.equals(player0);
        boolean result = instance.controlFromCountryPlayer(country, player0);
        assertEquals(expResult, result);
    }

    /**
     * Test of controlPlayer method, of class RisikoMap.
     */
    @Test
    public void testControlPlayer() {
        System.out.println("controlPlayer");
        //instance.initGame(players);
        Country country = instance.getCountryByName("Alaska");
        Player player0 = players.get(0);
        List<Country> player0Countries = instance.getMyCountries(player0);
        boolean expResult = player0Countries.contains(country);
        boolean result = instance.controlPlayer(country, player0);
        assertEquals(expResult, result);
    }

    /**
     * Test of controlDefender method, of class RisikoMap. FAILED :(
     */
    @Test
    public void testControlDefender() {
        System.out.println("controlDefender");
        //instance.initGame(players);
        Country attackerCountry = instance.getCountriesList().get((int) (Math.random() * N_COUNTRIES));
        Player player0 = players.get(0);
        Country defenderCountry = instance.getCountriesList().get((int) (Math.random() * N_COUNTRIES));
        boolean expResult = !instance.getPlayerByCountry(defenderCountry).equals(player0) && instance.getNeighbors(attackerCountry).contains(defenderCountry);

        boolean result = instance.controlDefender(attackerCountry, defenderCountry);
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of controlMovement method, of class RisikoMap.
//     */
//    @Test
//    public void testControlMovement() {
//        System.out.println("controlMovement");
//        Country fromCountry = null;
//        Country toCountry = null;
//        Player player = null;
//        RisikoMap instance = new RisikoMap();
//        boolean expResult = false;
//        boolean result = instance.controlMovement(fromCountry, toCountry, player);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of move method, of class RisikoMap.
//     */
//    @Test
//    public void testMove() {
//        System.out.println("move");
//        Country fromCountry = null;
//        Country toCountry = null;
//        int nrArmies = 0;
//        RisikoMap instance = new RisikoMap();
//        instance.move(fromCountry, toCountry, nrArmies);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getMaxArmies method, of class RisikoMap.
//     */
//    @Test
//    public void testGetMaxArmies() {
//        System.out.println("getMaxArmies");
//        Country country = null;
//        boolean isAttacker = false;
//        RisikoMap instance = new RisikoMap();
//        int expResult = 0;
//        int result = instance.getMaxArmies(country, isAttacker);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateOnConquer method, of class RisikoMap.
//     */
//    @Test
//    public void testUpdateOnConquer() {
//        System.out.println("updateOnConquer");
//        Country attackerCountry = null;
//        Country defenderCountry = null;
//        int armies = 0;
//        RisikoMap instance = new RisikoMap();
//        instance.updateOnConquer(attackerCountry, defenderCountry, armies);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of checkIfWinner method, of class RisikoMap.
//     */
//    @Test
//    public void testCheckIfWinner() {
//        System.out.println("checkIfWinner");
//        Player player = null;
//        RisikoMap instance = new RisikoMap();
//        boolean expResult = false;
//        boolean result = instance.checkIfWinner(player);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of isConquered method, of class RisikoMap.
//     */
//    @Test
//    public void testIsConquered() {
//        System.out.println("isConquered");
//        Country country = null;
//        RisikoMap instance = new RisikoMap();
//        boolean expResult = false;
//        boolean result = instance.isConquered(country);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//

    /**
     * Test of hasLost method, of class RisikoMap.
     */
    @Test
    public void testHasLost() {
        System.out.println("hasLost");
        Player player = players.get(0);
        Player otherPlayer = players.get(1);
        Country attackerCountry=instance.getMyCountries(otherPlayer).get(0);
        for (Country country : instance.getCountriesList()) {
            if (instance.getPlayerByCountry(country) == player) {
                instance.updateOnConquer(attackerCountry, country);
            }
        }
        boolean result = instance.hasLost(player);
        assertTrue(result);
        
        result=instance.hasLost(otherPlayer);
        assertFalse(result);
    }

    /**
     * Test of addArmies method, of class RisikoMap.
     */
    @Test
    public void testAddArmies() {
        System.out.println("addArmies");
        int armies;
        int bonus = 3;
        for (Country country : instance.getCountriesList()) {
            armies = country.getArmies();
            instance.addArmies(country, bonus);
            assertEquals(country.getArmies(), armies + bonus);
        }
    }

    /**
     * Test of removeArmies method, of class RisikoMap.
     */
    @Test
    public void testRemoveArmies() {
        System.out.println("removeArmies");
        for (Country country : instance.getCountriesList()) {
            int nArmies = country.getArmies();
            instance.removeArmies(country, nArmies);
            assertTrue(country.getArmies() == 0);
        }
    }

    /**
     * Test of canAttackFromCountry method, of class RisikoMap.
     */
    @Test
    public void testCanAttackFromCountry() {
        System.out.println("canAttackFromCountry");
        boolean result;
        for (Country country : instance.getCountriesList()) {
            Player player = instance.getPlayerByCountry(country);
            if (instance.getMyCountries(player).containsAll(country.getNeighbors())) {
                result = instance.canAttackFromCountry(country);
                assertFalse(result);
                break;
            }
            for (Country c : country.getNeighbors()) {
                // The neighbor is not a country of the player's
                if (instance.getPlayerByCountry(c) != player) {
                    result = instance.canAttackFromCountry(country);
                    assertTrue(result);
                    // The country has only 1 army
                    country.removeArmies(country.getArmies() - 1);
                    result = instance.canAttackFromCountry(country);
                    assertFalse(result);
                    break;
                }

            }

            for (Country c : country.getNeighbors()) {
                // The neighbor is a country of the player's
                if (instance.getPlayerByCountry(c) == instance.getPlayerByCountry(country)) {
                    result = instance.canAttackFromCountry(country);
                    assertFalse(result);
                    break;
                }

            }
        }

    }
//xxxxxxxxxxxxxxxxx

    /**
     * Test of getMaxArmies method, of class RisikoMap.
     */
    @Test
    public void testGetMaxArmies() {
        System.out.println("getMaxArmies");
        instance.initGame(players);
        Country country0 = instance.getCountriesList().get((int) (Math.random() * N_COUNTRIES));
        country0.setArmies(3);
        boolean isAttacker = true;
        int expResult0 = 2;
        int result0 = instance.getMaxArmies(country0, isAttacker);
        assertEquals(expResult0, result0);

        Country country1 = instance.getCountriesList().get((int) (Math.random() * N_COUNTRIES));
        country1.setArmies(3);
        int expResult1 = 3;
        isAttacker = false;
        int result1 = instance.getMaxArmies(country1, isAttacker);
        assertEquals(expResult1, result1);
    }

    /**
     * Test of updateOnConquer method, of class RisikoMap.
     */
    @Test
    public void testUpdateOnConquer() {
        System.out.println("updateOnConquer");
        instance.initGame(players);
        Country attackerCountry = instance.getCountryByName("Alaska");
        Country defenderCountry = instance.getCountryByName("Alberta");
        instance.updateOnConquer(attackerCountry, defenderCountry);
        Player player0 = instance.getPlayerByCountry(attackerCountry);
        Player player1 = instance.getPlayerByCountry(defenderCountry);
        assertEquals(player0, player1);
    }

    /**
     * Test of checkIfWinner method, of class RisikoMap.
     */
    @Test
    public void testCheckIfWinner() {
        System.out.println("checkIfWinner");
        instance.initGame(players);
        Player player = players.get(0);
        List <Country> targetList = instance.getMyCountries(player);
        ContinentsMission mission = new ContinentsMission("test", 0);
        mission.setTargetList(targetList);
        player.setMission(mission);
        boolean expResult = true;
        boolean result = instance.checkIfWinner(player);
        assertEquals(expResult, result);

    }

    /**
     * Test of isConquered method, of class RisikoMap.
     */
    @Test
    public void testIsConquered() {
        System.out.println("isConquered");
        instance.initGame(players);
        Country country = instance.getCountryByName("Egitto");
        country.setArmies(0); 
        
        boolean expResult = true;
        boolean result = instance.isConquered(country);
        assertEquals(expResult, result);
    } 
//    /**
//     * Test of hasLost method, of class RisikoMap.
//     */
//    @Test
//    public void testHasLost() {
//        System.out.println("hasLost");
//        Player defenderPlayer = null;
//        RisikoMap instance = new RisikoMap();
//        boolean expResult = false;
//        boolean result = instance.hasLost(defenderPlayer);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addArmies method, of class RisikoMap.
//     */
//    @Test
//    public void testAddArmies() {
//        System.out.println("addArmies");
//        Country country = null;
//        int nArmies = 0;
//        RisikoMap instance = new RisikoMap();
//        instance.addArmies(country, nArmies);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeArmies method, of class RisikoMap.
//     */
//    @Test
//    public void testRemoveArmies() {
//        System.out.println("removeArmies");
//        Country country = null;
//        int nArmies = 0;
//        RisikoMap instance = new RisikoMap();
//        instance.removeArmies(country, nArmies);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of canAttackFromCountry method, of class RisikoMap.
//     */
//    @Test
//    public void testCanAttackFromCountry() {
//        System.out.println("canAttackFromCountry");
//        Country country = null;
//        RisikoMap instance = new RisikoMap();
//        boolean expResult = false;
//        boolean result = instance.canAttackFromCountry(country);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCountryByName method, of class RisikoMap.
//     */
//    @Test
//    public void testGetCountryByName() {
//        System.out.println("getCountryByName");
//        String countryName = "";
//        RisikoMap instance = new RisikoMap();
//        Country expResult = null;
//        Country result = instance.getCountryByName(countryName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getCountriesColors method, of class RisikoMap.
//     */
//    @Test
//    public void testGetCountriesColors() {
//        System.out.println("getCountriesColors");
//        RisikoMap instance = new RisikoMap();
//        String[] expResult = null;
//        String[] result = instance.getCountriesColors();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getPlayerColorByCountry method, of class RisikoMap.
//     */
//    @Test
//    public void testGetPlayerColorByCountry() {
//        System.out.println("getPlayerColorByCountry");
//        Country country = null;
//        RisikoMap instance = new RisikoMap();
//        String expResult = "";
//        String result = instance.getPlayerColorByCountry(country);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of changeOwner method, of class RisikoMap.
//     */
//    @Test
//    public void testChangeOwner() {
//        System.out.println("changeOwner");
//        Player oldOwner = null;
//        Player newOwner = null;
//        RisikoMap instance = new RisikoMap();
//        instance.changeOwner(oldOwner, newOwner);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
