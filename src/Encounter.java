import java.io.Serializable;
import java.util.Map;

/**
 * A class which represents an Encounter
 * @author Connor Henderson (chenderson1190@gmail.com)
 */
public class Encounter implements Serializable {
    private Map<String, Integer> characterInitiativePair;

    /**
     * Constructor for this.
     * @param characterInitiativePair A key-value pair representing a characters name and initiative value
     */
    Encounter(Map<String, Integer> characterInitiativePair){
        this.characterInitiativePair = characterInitiativePair;
    }

    void addPair(String characterName, int initiativeValue){
        characterInitiativePair.put(characterName, initiativeValue);
    }

}
