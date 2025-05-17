package ast;

public class InputExprNode extends ExprNode {
    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitInputExpr(this);
    }
}