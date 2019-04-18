package deserializer;

import com.github.javaparser.ast.Node;
import com.github.javaparser.serialization.JavaParserJsonDeserializer;

import javax.json.Json;
import java.io.*;

public class Deserializer {
    private final JavaParserJsonDeserializer deserializer = new JavaParserJsonDeserializer();
    public void deserialize(String path) {
        try {
            String json_string = readFile(path);
            Node node = deserializer.deserializeObject(Json.createReader(new StringReader(json_string)));
            System.out.println(node.toString());
        } catch (FileNotFoundException e) {
            System.out.println("File " + path + " could not be found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String readFile(String path) throws FileNotFoundException, IOException {
        File file = new File(path);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String content = "";
        String line;
        while ((line = reader.readLine()) != null) {
            content += line;
        }
        return content;
    }
}
