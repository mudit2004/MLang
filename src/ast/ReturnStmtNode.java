package ast;

public class ReturnStmtNode extends StmtNode {
    public final ExprNode expression;

    public ReturnStmtNode(ExprNode expression) {
        this.expression = expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitReturnStmt(this);
    }
}