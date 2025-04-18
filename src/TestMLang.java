import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import ast.*;

public class TestMLang {
    public static void main(String[] args) throws Exception {
        // Sample input
        String inputCode = "x > int = 5;";

        // Step 1: Run ANTLR lexer and parser
        CharStream input = CharStreams.fromString(inputCode);
        MLangLexer lexer = new MLangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MLangParser parser = new MLangParser(tokens);

        // Step 2: Parse starting from the top rule
        ParseTree tree = parser.program();

        // Step 3: Build AST using your custom visitor
        MLangASTBuilder builder = new MLangASTBuilder();
        ProgramNode ast = (ProgramNode) builder.visit(tree);

        // Step 4: Print AST using a simple printer
        printAST(ast, 0);
    }

    // A simple recursive AST pretty-printer
    private static void printAST(ASTNode node, int indent) {
        String indentStr = "  ".repeat(indent);
        if (node instanceof ProgramNode prog) {
            System.out.println(indentStr + "Program");
            for (StmtNode stmt : prog.statements) {
                printAST(stmt, indent + 1);
            }
        } else if (node instanceof VarDeclNode decl) {
            System.out.println(indentStr + "VarDecl: " + decl.identifier + " > " + decl.type);
            printAST(decl.expression, indent + 1);
        } else if (node instanceof ExprStmtNode stmt) {
            System.out.println(indentStr + "ExprStmt");
            printAST(stmt.expr, indent + 1);
        } else if (node instanceof IntLiteralNode lit) {
            System.out.println(indentStr + "IntLiteral: " + lit.value);
        } else if (node instanceof IdNode id) {
            System.out.println(indentStr + "Id: " + id.name);
        } else if (node instanceof BinaryOpNode bin) {
            System.out.println(indentStr + "BinaryOp: " + bin.op);
            printAST(bin.left, indent + 1);
            printAST(bin.right, indent + 1);
        } else {
            System.out.println(indentStr + "Unknown node: " + node.getClass().getSimpleName());
        }
    }
}