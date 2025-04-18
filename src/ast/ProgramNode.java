package ast;

import java.util.List;

public class ProgramNode implements ASTNode {
    public final List<StmtNode> statements;

    public ProgramNode(List<StmtNode> statements) {
        this.statements = statements;
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitProgram(this);
    }
}