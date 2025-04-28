package ast;

public class ExprStmtNode extends StmtNode {
    public final ExprNode expr;

    public ExprStmtNode(ExprNode expr) {
        this.expr = expr;
    }

    public ExprNode expression() {
        return expr;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitExprStmt(this);
    }
}