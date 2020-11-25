package actions;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveEncounter {

    public static void saveEncounter(Encounter encounter){
        try {
            FileOutputStream saveFile = new FileOutputStream("EncounterSave.ser");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(encounter);
            save.close();
        } catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
