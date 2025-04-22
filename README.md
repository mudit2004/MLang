# MLang 🧠

**MLang** is a custom programming language with a unique syntax and structure, built using **ANTLR4** and Java. It supports arithmetic expressions, variable declarations, `if`/`else` conditionals, and block scoping using square brackets.

---

## 🚀 Features Implemented

### ✅ Language Constructs
- Variable declarations: `x > int = 5;`
- Arithmetic expressions: `x + 3 * 4;`
- Expression statements
- **If-Else conditionals**: `if (x) [ ... ] else [ ... ]`
- **Block support** using square brackets: `[ stmt1; stmt2; ]`

### ✅ Parsing + AST
- Custom grammar using `ANTLR4` (`MLang.g4`)
- Clean AST design with nodes like:
  - `ProgramNode`, `VarDeclNode`, `ExprStmtNode`
  - `BinaryOpNode`, `IntLiteralNode`, `IdNode`
  - `IfStmtNode`, `BlockNode`
- Custom AST Builder: `MLangASTBuilder.java` using `MLangBaseVisitor`
- AST Pretty Printer: shows structure of parsed code clearly

### ✅ Build System
- Fully functional `Makefile`:
  - Handles ANTLR generation
  - Compiles all source and generated files
  - Runs the test driver
  - Cleans build artifacts

---

## 📦 Project Structure
```bash
MLANG/
├── src/
│   ├── MLang.g4                # ANTLR grammar
│   ├── TestMLang.java          # Main driver with pretty-printer
│   ├── MLangASTBuilder.java    # AST builder from parse tree
│   └── ast/                    # Custom AST nodes
├── gen/                        # ANTLR-generated parser/lexer
├── bin/                        # Compiled .class files
├── lib/                        # antlr-4.13.1-complete.jar
├── Makefile                    # Build & run automation
└── README.md
```
---

## ⚠️ Challenges Encountered

- **ANTLR output folder issue** (`gen/src/`):  
  Fixed by running ANTLR from within `src/` with output to `../gen/`.

- **Wildcard compilation failure after clean**:  
  Solved using `$(wildcard gen/*.java)` in the Makefile.

- **Broken Java import statements**:  
  Removed invalid `import .antlr...` and relied on classpath.

- **Makefile dependency resolution**:  
  Used `gen/MLangParser.java` as target to ensure proper ordering.

---

## 🧪 Sample Input

```mlang
if (1) [ x > int = 2; ] else [ x > int = 3; ]
```

## Sample Output (AST)

```mlang
Program
  IfStmt
    Condition:
      IntLiteral: 1
    Then:
      Block
        VarDecl: x > int
          IntLiteral: 2
    Else:
      Block
        VarDecl: x > int
          IntLiteral: 3
```


⸻

🧠 Author

Mudit Golchha
CS571 – Programming Languages
Binghamton University