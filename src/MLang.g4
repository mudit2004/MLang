grammar MLang;

// --- PARSER RULES ---

program     : stmt* EOF ;

stmt
    : varDecl
    | exprStmt
    ;

varDecl     : ID '>' type '=' expr ';' ;
exprStmt    : expr ';' ;

expr
    : expr op=('*'|'/') expr     # MulDivExpr
    | expr op=('+'|'-') expr     # AddSubExpr
    | INT                        # IntLiteral
    | ID                         # IdExpr
    ;

type        : 'int' | 'float' | 'bool' ;

// --- LEXER RULES ---

ID          : [a-zA-Z_][a-zA-Z_0-9]* ;
INT         : [0-9]+ ;

WS          : [ \t\r\n]+ -> skip ;