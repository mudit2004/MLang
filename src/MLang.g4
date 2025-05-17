grammar MLang;

// ==============================
//          Parser Rules
// ==============================

program
    : stmt* EOF
    ;

// --- Statements ---

stmt
    : letDecl
    | assignStmt
    | exprStmt
    | ifStmt
    | whileStmt
    | showStmt
    | funcDecl
    | returnStmt
    ;

// Variable declaration
letDecl
    : 'let' ID '>' type '=' expr ';'
    ;

// Variable assignment
assignStmt
    : ID '=' expr ';'
    ;

// Expression as a statement
exprStmt
    : expr ';'
    ;

// If-Else
ifStmt
    : 'if' '(' expr ')' block ('else' block)?
    ;

// While loop
whileStmt
    : 'while' '(' expr ')' block
    ;

// Output
showStmt
    : 'show' '(' expr ')' ';'
    ;

// Function declaration
funcDecl
    : 'func' ID '(' params? ')' '>' type block
    ;

// Return statement
returnStmt
    : 'return' expr ';'
    ;

// Block of statements
block
    : '[' stmt* ']'
    ;

// Function parameters
params
    : param (',' param)*
    ;

param
    : ID '>' type
    ;

// Function call arguments
arguments
    : expr (',' expr)*
    ;

// --- Expressions ---

expr
    : expr op=('==' | '!=' | '<' | '<=' | '>' | '>=') expr   # CompExpr
    | expr op=('*' | '/') expr                               # MulDivExpr
    | expr op=('+' | '-') expr                               # AddSubExpr
    | ID '(' arguments? ')'                                  # FuncCallExpr
    | INT                                                    # IntLiteral
    | ID                                                     # IdExpr
    ;

// --- Types ---

type
    : 'int'
    | 'float'
    | 'bool'
    ;

// ==============================
//          Lexer Rules
// ==============================

ID
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

INT
    : [0-9]+
    ;

WS
    : [ \t\r\n]+ -> skip
    ;