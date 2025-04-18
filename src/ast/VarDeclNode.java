package ast;

public class VarDeclNode extends StmtNode {
    public final String identifier;
    public final String type;
    public final ExprNode expression;

    public VarDeclNode(String identifier, String type, ExprNode expression) {
        this.identifier = identifier;
        this.type = type;
        this.expression = expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitVarDecl(this);
    }
}