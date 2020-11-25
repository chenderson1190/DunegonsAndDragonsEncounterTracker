package actions;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveEncounter {

    public void saveEncounter(Encounter encounter){
        try {
            FileOutputStream saveFile = new FileOutputStream("EncounterSave.txt");
            ObjectOutputStream save = new ObjectOutputStream(saveFile);
            save.writeObject(encounter);
            save.close();
        } catch(Exception exc){
            exc.printStackTrace();
        }
    }
}
