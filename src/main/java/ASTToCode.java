import com.github.javaparser.ast.Node;
import com.github.javaparser.serialization.JavaParserJsonDeserializer;

import javax.json.Json;
import java.io.StringReader;

public class ASTToCode {
    public static void main(String[] args) {
        assert args.length == 1;

        String json_string = args[0];

        //String json_string = "{\"!\":\"com.github.javaparser.ast.body.MethodDeclaration\",\"body\":{\"!\":\"com.github.javaparser.ast.stmt.BlockStmt\",\"statements\":[{\"!\":\"com.github.javaparser.ast.stmt.ReturnStmt\",\"expression\":{\"!\":\"com.github.javaparser.ast.expr.NameExpr\",\"name\":{\"!\":\"com.github.javaparser.ast.expr.SimpleName\",\"identifier\":\"hfill\"}}}]},\"type\":{\"!\":\"com.github.javaparser.ast.type.PrimitiveType\",\"type\":\"BOOLEAN\",\"annotations\":[]},\"modifiers\":[{\"!\":\"com.github.javaparser.ast.Modifier\",\"keyword\":\"PUBLIC\"}],\"name\":{\"!\":\"com.github.javaparser.ast.expr.SimpleName\",\"identifier\":\"isHfill\"},\"parameters\":[],\"thrownExceptions\":[],\"typeParameters\":[],\"annotations\":[]}";

        JavaParserJsonDeserializer deserializer = new JavaParserJsonDeserializer();

        System.out.println(json_string);
        StringReader json = new StringReader(json_string);


        Node node = deserializer.deserializeObject(Json.createReader(json));

        System.out.println(node.toString());
    }
}
