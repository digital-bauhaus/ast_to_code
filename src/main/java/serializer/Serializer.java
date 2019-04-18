package serializer;

import com.github.javaparser.JavaParser;
import com.github.javaparser.ParseResult;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.MethodDeclaration;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class Serializer {
    public void serialize(String java_path) {
        File f = new File(java_path);

        JavaParser javaParser = new JavaParser();
        try {
            ParseResult<CompilationUnit> parseResult = javaParser.parse(f);
            if (!parseResult.isSuccessful() && !parseResult.getResult().isPresent()) return;
            CompilationUnit unit = parseResult.getResult().get();

            List<MethodDeclaration> methods = unit.findAll(MethodDeclaration.class);

            for(MethodDeclaration method : methods) {
                System.out.println(TreeHelper.nodeToJson(method));
            }

        } catch (FileNotFoundException e) {
            System.out.println("File was not found");
        }
    }
}
