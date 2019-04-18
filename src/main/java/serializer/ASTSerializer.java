package serializer;

import com.github.javaparser.ast.Node;
import com.github.javaparser.serialization.JavaParserJsonSerializer;

import javax.json.stream.JsonGenerator;

public class ASTSerializer extends JavaParserJsonSerializer {
    /***
     *
     * Override Javaparser serializer.Serializer to exclude token range.
     * @param node
     * @param generator
     */
    @Override
    protected void writeNonMetaProperties(Node node, JsonGenerator generator) {
        // do nothing
    }
}
