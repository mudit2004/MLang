package ast;

public class IntLiteralNode extends ExprNode {
    public final int value;

    public IntLiteralNode(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitIntLiteral(this);
    }
}