package actions;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class LoadEncounter {
    public static Encounter loadEncounter(){
        try {
            FileInputStream saveFile = new FileInputStream("EncounterSave.ser");
            ObjectInputStream save = new ObjectInputStream(saveFile);
            Encounter encounter = (Encounter) save.readObject();
            save.close();
            return encounter;
        }catch(Exception exc){
            exc.printStackTrace();
        }
        return null;
    }
}
