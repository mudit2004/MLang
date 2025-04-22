package ast;

public class WhileStmtNode extends StmtNode {
    public final ExprNode condition;
    public final StmtNode body;

    public WhileStmtNode(ExprNode condition, StmtNode body) {
        this.condition = condition;
        this.body = body;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitWhileStmt(this);
    }
}