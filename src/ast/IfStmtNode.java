package ast;

public class IfStmtNode extends StmtNode {
    public final ExprNode condition;
    public final StmtNode thenBranch;
    public final StmtNode elseBranch; // may be null

    public IfStmtNode(ExprNode condition, StmtNode thenBranch, StmtNode elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public ExprNode condition() {
        return condition;
    }

    public StmtNode thenBlock() {
        return thenBranch;
    }

    public StmtNode elseBlock() {
        return elseBranch;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitIfStmt(this);
    }
}