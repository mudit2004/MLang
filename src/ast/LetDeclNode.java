package ast;

public class LetDeclNode extends StmtNode {
    public final String identifier;
    public final String type;
    public final ExprNode expression;

    public LetDeclNode(String identifier, String type, ExprNode expression) {
        this.identifier = identifier;
        this.type = type;
        this.expression = expression;
    }

    public String name() {
        return identifier;
    }

    public ExprNode initializer() {
        return expression;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitLetDecl(this);
    }
}