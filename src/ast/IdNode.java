package ast;

public class IdNode extends ExprNode {
    public final String name;

    public IdNode(String name) {
        this.name = name;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitId(this);
    }
}