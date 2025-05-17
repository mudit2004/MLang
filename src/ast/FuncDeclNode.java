package ast;

import java.util.List;

public class FuncDeclNode extends StmtNode {
    public final String name;
    public final List<Param> parameters;
    public final String returnType;
    public final BlockNode body;

    public static class Param {
        public final String name;
        public final String type;

        public Param(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }

    public FuncDeclNode(String name, List<Param> parameters, String returnType, BlockNode body) {
        this.name = name;
        this.parameters = parameters;
        this.returnType = returnType;
        this.body = body;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitFuncDecl(this);
    }
}