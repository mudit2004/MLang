import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TestMLang {
    public static void main(String[] args) throws Exception {
        String inputCode = "x > int = 5;";
        CharStream input = CharStreams.fromString(inputCode);

        MLangLexer lexer = new MLangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MLangParser parser = new MLangParser(tokens);

        ParseTree tree = parser.program(); // Start rule
        System.out.println(tree.toStringTree(parser));
    }
}