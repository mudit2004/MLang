package ast;

public class ShowStmtNode extends StmtNode {
    public final ExprNode expression;

    public ShowStmtNode(ExprNode expression) {
        this.expression = expression;
    }

    public ExprNode expression() {
        return expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitShowStmt(this);
    }
}