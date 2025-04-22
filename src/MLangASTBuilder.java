import ast.*;
import java.util.ArrayList;
import java.util.List;
//import .antlr.MLangParser;
//import org.antlr.v4.runtime.tree.*;
//import MLangParser; // if no package

public class MLangASTBuilder extends MLangBaseVisitor<ASTNode> {

    @Override
    public ASTNode visitProgram(MLangParser.ProgramContext ctx) {
        List<StmtNode> stmts = new ArrayList<>();
        for (MLangParser.StmtContext stmtCtx : ctx.stmt()) {
            StmtNode stmt = (StmtNode) visit(stmtCtx);
            stmts.add(stmt);
        }
        return new ProgramNode(stmts);
    }

    @Override
    public ASTNode visitVarDecl(MLangParser.VarDeclContext ctx) {
        String id = ctx.ID().getText();
        String type = ctx.type().getText();
        ExprNode expr = (ExprNode) visit(ctx.expr());
        return new VarDeclNode(id, type, expr);
    }

    @Override
    public ASTNode visitExprStmt(MLangParser.ExprStmtContext ctx) {
        ExprNode expr = (ExprNode) visit(ctx.expr());
        return new ExprStmtNode(expr);
    }

    @Override
    public ASTNode visitIntLiteral(MLangParser.IntLiteralContext ctx) {
        int val = Integer.parseInt(ctx.INT().getText());
        return new IntLiteralNode(val);
    }

    @Override
    public ASTNode visitIdExpr(MLangParser.IdExprContext ctx) {
        return new IdNode(ctx.ID().getText());
    }

    @Override
    public ASTNode visitAddSubExpr(MLangParser.AddSubExprContext ctx) {
        String op = ctx.op.getText();
        ExprNode left = (ExprNode) visit(ctx.expr(0));
        ExprNode right = (ExprNode) visit(ctx.expr(1));
        return new BinaryOpNode(op, left, right);
    }

    @Override
    public ASTNode visitMulDivExpr(MLangParser.MulDivExprContext ctx) {
        String op = ctx.op.getText();
        ExprNode left = (ExprNode) visit(ctx.expr(0));
        ExprNode right = (ExprNode) visit(ctx.expr(1));
        return new BinaryOpNode(op, left, right);
    }

    // Add more visit methods later (e.g., comparisons, booleans, if, while, etc.)
    @Override
    public ASTNode visitIfStmt(MLangParser.IfStmtContext ctx) {
        ExprNode condition = (ExprNode) visit(ctx.expr());
        StmtNode thenBranch = new BlockNode(ctx.block(0).stmt().stream()
            .map(stmt -> (StmtNode) visit(stmt))
            .toList());
        StmtNode elseBranch = null;
        if (ctx.block().size() > 1) {
            elseBranch = new BlockNode(ctx.block(1).stmt().stream()
                .map(stmt -> (StmtNode) visit(stmt))
                .toList());
        }
        return new IfStmtNode(condition, thenBranch, elseBranch);
    }
}
