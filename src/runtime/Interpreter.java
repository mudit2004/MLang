package runtime;

import ast.*;

public class Interpreter implements ASTVisitor<Object> {

    private final Environment environment = new Environment();

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
        Object value = node.initializer().accept(this);
        environment.define(node.name(), value);
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
}