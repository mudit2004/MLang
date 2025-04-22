package ast;

public interface ASTVisitor<T> {
    T visitProgram(ProgramNode node);
    //T visitVarDecl(LetDeclNode node);
    T visitLetDecl(LetDeclNode node);
    T visitExprStmt(ExprStmtNode node);
    T visitIntLiteral(IntLiteralNode node);
    T visitId(IdNode node);
    T visitBinaryOp(BinaryOpNode node);
    T visitIfStmt(IfStmtNode node);
    T visitBlock(BlockNode node);
    T visitShowStmt(ShowStmtNode node);
    T visitWhileStmt(WhileStmtNode node);
    T visitAssignStmt(AssignStmtNode node);
}