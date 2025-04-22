grammar MLang;

// --- PARSER RULES ---

program     : stmt* EOF ;

stmt
    : letDecl
    | assignStmt
    | exprStmt
    | ifStmt
    | whileStmt
    | showStmt
    ;

letDecl     : 'let' ID '>' type '=' expr ';' ;
exprStmt    : expr ';' ;

ifStmt      : 'if' '(' expr ')' block ('else' block)? ;

whileStmt : 'while' '(' expr ')' block ;

showStmt : 'show' '(' expr ')' ';' ;

assignStmt : ID '=' expr ';' ;

block       : '[' stmt* ']' ;

expr
    : expr op=('==' | '!=' | '<' | '<=' | '>' | '>=') expr # CompExpr
    | expr op=('*'|'/') expr                               # MulDivExpr
    | expr op=('+'|'-') expr                               # AddSubExpr
    | INT                                                  # IntLiteral
    | ID                                                   # IdExpr
    ;

type        : 'int' | 'float' | 'bool' ;

// --- LEXER RULES ---

ID          : [a-zA-Z_][a-zA-Z_0-9]* ;
INT         : [0-9]+ ;

WS          : [ \t\r\n]+ -> skip ;