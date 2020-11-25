package actions;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * A class which represents an Encounter
 * @author Connor Henderson (chenderson1190@gmail.com)
 */
public class Encounter implements Serializable {
    private TreeMap<Integer, String> initiativeOrder;

    public Encounter(){
        initiativeOrder = new TreeMap<>();
    }

    public String toString(){
        return initiativeOrder.toString();
    }

    public void add(String name, Integer initiative){
        initiativeOrder.put(initiative, name);
    }

    public Map<Integer, String> getInitiativeOrder(){
        return initiativeOrder.descendingMap();
    }
    private void readObject(ObjectInputStream inputStream) throws ClassNotFoundException, IOException {
        //always perform the default de-serialization first
        initiativeOrder = (TreeMap) inputStream.readObject();
    }

    private void writeObject(ObjectOutputStream outputStream) throws IOException {
        //perform the default serialization for all non-transient, non-static fields
        outputStream.writeObject(initiativeOrder);
    }

}
