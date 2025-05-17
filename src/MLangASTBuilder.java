import ast.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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
    public ASTNode visitLetDecl(MLangParser.LetDeclContext ctx) {
        String id = ctx.ID().getText();
        String type = ctx.type().getText();
        ExprNode expr = (ExprNode) visit(ctx.expr());
        return new LetDeclNode(id, type, expr); 
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

    @Override
    public ASTNode visitCompExpr(MLangParser.CompExprContext ctx) {
        String op = ctx.op.getText();
        ExprNode left = (ExprNode) visit(ctx.expr(0));
        ExprNode right = (ExprNode) visit(ctx.expr(1));
        return new BinaryOpNode(op, left, right);
    }

    @Override
    public ASTNode visitShowStmt(MLangParser.ShowStmtContext ctx) {
        ExprNode expr = (ExprNode) visit(ctx.expr());
        return new ShowStmtNode(expr);
    }

    @Override
    public ASTNode visitWhileStmt(MLangParser.WhileStmtContext ctx) {
        ExprNode condition = (ExprNode) visit(ctx.expr());
        StmtNode body = new BlockNode(ctx.block().stmt().stream()
            .map(stmt -> (StmtNode) visit(stmt))
            .toList());
        return new WhileStmtNode(condition, body);
    }

    @Override
    public ASTNode visitAssignStmt(MLangParser.AssignStmtContext ctx) {
        String id = ctx.ID().getText();
        ExprNode expr = (ExprNode) visit(ctx.expr());
        return new AssignStmtNode(id, expr);
    }

    @Override
    public ASTNode visitFuncDecl(MLangParser.FuncDeclContext ctx) {
        String name = ctx.ID().getText();
        String returnType = ctx.type().getText();

        List<FuncDeclNode.Param> params = new ArrayList<>();
        if (ctx.params() != null) {
            for (MLangParser.ParamContext paramCtx : ctx.params().param()) {
                String paramName = paramCtx.ID().getText();
                String paramType = paramCtx.type().getText();
                params.add(new FuncDeclNode.Param(paramName, paramType));
            }
        }

        BlockNode body = new BlockNode(ctx.block().stmt().stream()
            .map(stmt -> (StmtNode) visit(stmt))
            .toList());

        return new FuncDeclNode(name, params, returnType, body);
    }

    @Override
    public ASTNode visitFuncCallExpr(MLangParser.FuncCallExprContext ctx) {
        String name = ctx.ID().getText();
        List<ExprNode> args = new ArrayList<>();

        if (ctx.arguments() != null) {
            for (MLangParser.ExprContext argExpr : ctx.arguments().expr()) {
                args.add((ExprNode) visit(argExpr));
            }
        }

        return new FuncCallNode(name, args);
    }

    @Override
    public ASTNode visitReturnStmt(MLangParser.ReturnStmtContext ctx) {
        ExprNode expr = (ExprNode) visit(ctx.expr());
        return new ReturnStmtNode(expr);
    }

    @Override
    public ASTNode visitInputExpr(MLangParser.InputExprContext ctx) {
        return new InputExprNode();
    }
}