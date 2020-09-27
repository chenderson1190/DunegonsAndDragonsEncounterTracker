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
    private TreeMap<Float, String> initiativeOrder;

    Encounter(){
        initiativeOrder = new TreeMap<>();
    }

    public String toString(){
        return initiativeOrder.toString();
    }

    void add(String name, Float initiative){
        initiativeOrder.put(initiative, name);
    }

    public Map<Float, String> getInitiativeOrder(){
        return initiativeOrder;
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
