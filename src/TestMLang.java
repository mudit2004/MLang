import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.nio.file.Files;
import java.nio.file.Paths;

//import .antlr.MLangLexer;
//import .antlr.MLangParser;
import runtime.Interpreter;
import ast.*;

public class TestMLang {
    public static void main(String[] args) throws Exception {
        // Sample input
        //String inputCode = "x > int = 5;";
        //String inputCode = "x > int = 1 + 2;";
        //String inputCode = "if (1) [ x > int = 2; ] else [ x > int = 3; ]";
        //String inputCode = Files.readString(Paths.get("tests/test.ml"));
        String inputCode = Files.readString(Paths.get("tests/assign_while_show.ml"));

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

        // ✅ Step 5: Interpret the AST (NEW)
        Interpreter interpreter = new Interpreter();
        ast.accept(interpreter);
    }

    // A simple recursive AST pretty-printer
    private static void printAST(ASTNode node, int indent) {
        String indentStr = "  ".repeat(indent);
        if (node instanceof ProgramNode prog) {
            System.out.println(indentStr + "Program");
            for (StmtNode stmt : prog.statements) {
                printAST(stmt, indent + 1);
            }
        } else if (node instanceof LetDeclNode decl) {
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
        } else if (node instanceof IfStmtNode ifNode) {
            System.out.println(indentStr + "IfStmt");
            System.out.println(indentStr + "  Condition:");
            printAST(ifNode.condition, indent + 2);
            System.out.println(indentStr + "  Then:");
            printAST(ifNode.thenBranch, indent + 2);
            if (ifNode.elseBranch != null) {
                System.out.println(indentStr + "  Else:");
                printAST(ifNode.elseBranch, indent + 2);
            }
        } else if (node instanceof BlockNode block) {
            System.out.println(indentStr + "Block");
            for (StmtNode stmt : block.statements) {
                printAST(stmt, indent + 1);
            }
        }else if (node instanceof ShowStmtNode show) {
            System.out.println(indentStr + "Show");
            printAST(show.expression, indent + 1);
        }else if (node instanceof WhileStmtNode loop) {
            System.out.println(indentStr + "WhileStmt");
            System.out.println(indentStr + "  Condition:");
            printAST(loop.condition, indent + 2);
            System.out.println(indentStr + "  Body:");
            printAST(loop.body, indent + 2);
        }else if (node instanceof AssignStmtNode assign) {
            System.out.println(indentStr + "Assign: " + assign.identifier);
            printAST(assign.expression, indent + 1);
        }else {
            System.out.println(indentStr + "Unknown node: " + node.getClass().getSimpleName());
        }
    }
}