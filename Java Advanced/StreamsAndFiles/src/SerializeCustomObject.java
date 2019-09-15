import java.io.*;

public class SerializeCustomObject {
    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        String path = userDir + "/res/output.txt";
        Cube cube = new Cube("green", 15.3, 12.4, 3.0);;
        serializeObject(cube,path);
        Cube o = (Cube) deserialize(path);
        System.out.println(o.getColor());
    }
    private static void serializeObject(Object object, String path){
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path));
            oos.writeObject(object);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Object deserialize(String path){
        Cube cube = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path));
            cube = (Cube) ois.readObject();

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return cube;
    }
}

class Cube implements Serializable {
    String color;
    double width;
    double height;
    double depth;

    public Cube(String color, double width, double height, double depth) {
        this.color = color;
        this.width = width;
        this.height = height;
        this.depth = depth;
    }

    public String getColor() {
        return color;
    }

}
