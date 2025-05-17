package ast;

import java.util.List;

public class FuncCallNode extends ExprNode {
    public final String name;
    public final List<ExprNode> arguments;

    public FuncCallNode(String name, List<ExprNode> arguments) {
        this.name = name;
        this.arguments = arguments;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFuncCall(this);
    }
}