package Model;
import java.io.*;
import java.util.HashMap;

public class Serialization {

    public static void read(HashMap<String, User> map, String fileName) {
        try {
            ObjectInputStream readFile = new ObjectInputStream(new FileInputStream(fileName));
            User user = null;
            while((user = (User)readFile.readObject()) != null)
                map.put(user.getUsername(),user);
            readFile.close();

        } catch (EOFException e) {
            System.out.println(fileName+" Reading completed...");
        }
        catch (Exception e) {
            System.out.println(e.toString());
        }
    }


    public static void write(HashMap<String,User> map,String fileName) throws Exception {

        ObjectOutputStream writeFile = new ObjectOutputStream(new FileOutputStream(fileName));
        for (User user : map.values())
            writeFile.writeObject(user);
        writeFile.close();
    }
}