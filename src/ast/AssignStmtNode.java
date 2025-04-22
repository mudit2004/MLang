package ast;

public class AssignStmtNode extends StmtNode {
    public final String identifier;
    public final ExprNode expression;

    public AssignStmtNode(String identifier, ExprNode expression) {
        this.identifier = identifier;
        this.expression = expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitAssignStmt(this);
    }
}