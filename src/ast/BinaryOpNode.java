package ast;

public class BinaryOpNode extends ExprNode {
    public final String op;
    public final ExprNode left;
    public final ExprNode right;

    public BinaryOpNode(String op, ExprNode left, ExprNode right) {
        this.op = op;
        this.left = left;
        this.right = right;
    }

    public String operator() {
        return op;
    }

    public ExprNode left() {
        return left;
    }

    public ExprNode right() {
        return right;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitBinaryOp(this);
    }
}