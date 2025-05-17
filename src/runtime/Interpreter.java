package runtime;
import java.util.Map;
import java.util.HashMap;

import ast.*;

public class Interpreter implements ASTVisitor<Object> {

    private Environment environment = new Environment();  // current environment (mutable during function calls)

    private final Map<String, FuncDeclNode> functions = new HashMap<>();  // stores global function declarations

    @Override
    public Object visitProgram(ProgramNode node) {
        for (StmtNode stmt : node.statements()) {
            stmt.accept(this);
        }
        return null;
    }

    @Override
    public Object visitBlock(BlockNode node) {
        for (StmtNode stmt : node.statements()) {
            stmt.accept(this);
        }
        return null;
    }

    @Override
    public Object visitLetDecl(LetDeclNode node) {
        // Step 1: Declare the variable name with a placeholder
        environment.define(node.name(), null);
        // Step 2: Evaluate the expression (now 'a' and 'b' are in the environment)
        Object value = node.initializer().accept(this);
        // Step 3: Assign the evaluated result
        environment.assign(node.name(), value);
        return null;
    }

    @Override
    public Object visitAssignStmt(AssignStmtNode node) {
        Object value = node.expression().accept(this);
        environment.assign(node.name(), value);
        return null;
    }

    @Override
    public Object visitIfStmt(IfStmtNode node) {
        Object conditionValue = node.condition().accept(this);

        if (conditionValue instanceof Integer) {
            int cond = (Integer) conditionValue;
            if (cond != 0) {
                node.thenBlock().accept(this);
            } else if (node.elseBlock() != null) {
                node.elseBlock().accept(this);
            }
        } else if (conditionValue instanceof Boolean) {
            boolean cond = (Boolean) conditionValue;
            if (cond) {
                node.thenBlock().accept(this);
            } else if (node.elseBlock() != null) {
                node.elseBlock().accept(this);
            }
        } else {
            throw new RuntimeException("Condition must evaluate to an integer or boolean");
        }
        return null;
    }

    @Override
    public Object visitWhileStmt(WhileStmtNode node) {
        while (true) {
            Object conditionValue = node.condition().accept(this);

            if (conditionValue instanceof Integer) {
                int cond = (Integer) conditionValue;
                if (cond == 0) break;
            } else if (conditionValue instanceof Boolean) {
                boolean cond = (Boolean) conditionValue;
                if (!cond) break;
            } else {
                throw new RuntimeException("Condition must evaluate to an integer or boolean");
            }

            node.body().accept(this);
        }
        return null;
    }

    @Override
    public Object visitShowStmt(ShowStmtNode node) {
        Object value = node.expression().accept(this);
        System.out.println(value);
        return null;
    }

    @Override
    public Object visitBinaryOp(BinaryOpNode node) {
        Object left = node.left().accept(this);
        Object right = node.right().accept(this);

        String op = node.operator();

        if (!(left instanceof Integer) || !(right instanceof Integer)) {
            throw new RuntimeException("Operands must be integers");
        }

        int l = (Integer) left;
        int r = (Integer) right;

        switch (op) {
            case "+":
                return l + r;
            case "-":
                return l - r;
            case "*":
                return l * r;
            case "/":
                if (r == 0) throw new RuntimeException("Division by zero");
                return l / r;
            case ">":
                return l > r;
            case "<":
                return l < r;
            case "==":
                return l == r;
            default:
                throw new RuntimeException("Unknown operator: " + op);
        }
    }

    @Override
    public Object visitId(IdNode node) {
        return environment.get(node.name());
    }

    @Override
    public Object visitIntLiteral(IntLiteralNode node) {
        return node.value(); 
    }

    @Override
    public Object visitExprStmt(ExprStmtNode node) {
        node.expression().accept(this);
        return null;
    }

    @Override
    public Object visitFuncDecl(FuncDeclNode node) {
        functions.put(node.name, node);
        return null;
    }

    @Override
    public Object visitReturnStmt(ReturnStmtNode node) {
        Object value = node.expression.accept(this);
        throw new ReturnException(value);
    }

    @Override
    public Object visitFuncCall(FuncCallNode node) {
        FuncDeclNode fn = functions.get(node.name);
        if (fn == null) {
            throw new RuntimeException("Undefined function: " + node.name);
        }
    
        if (fn.parameters.size() != node.arguments.size()) {
            throw new RuntimeException("Function " + node.name + " expects " +
                fn.parameters.size() + " arguments, got " + node.arguments.size());
        }
    
        Environment oldEnv = this.environment;
        Environment localEnv = new Environment();
        //this.environment = localEnv;
    
        // Bind arguments
        for (int i = 0; i < fn.parameters.size(); i++) {
            String paramName = fn.parameters.get(i).name;
            Object argValue = node.arguments.get(i).accept(this);
            localEnv.define(paramName, argValue);
        }
        this.environment = localEnv;
        try {
            fn.body.accept(this);
        } catch (ReturnException e) {
            this.environment = oldEnv;
            return e.value;
        }
        
        this.environment = oldEnv;
        return null;
    }

    @Override
    public Object visitInputExpr(InputExprNode node) {
        try {
            System.out.print("take> ");
            java.util.Scanner scanner = new java.util.Scanner(System.in);
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            throw new RuntimeException("Invalid input. Expected integer.");
        }
    }

}