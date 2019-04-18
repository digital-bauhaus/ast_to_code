import deserializer.Deserializer;

public class ASTToCode {

    public static void main(String[] args) {
        String path = args[0];
        // deserialize
        Deserializer deserializer = new Deserializer();
        deserializer.deserialize(path);
    }
}
