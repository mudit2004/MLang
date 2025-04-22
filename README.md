# MLang 🧠

**MLang** is a custom programming language with a unique syntax and structure, built using **ANTLR4** and Java. It supports arithmetic expressions, variable declarations, `if`/`else` conditionals, `while` loops, assignments, and block scoping using square brackets.

---

## 🚀 Features Implemented

### ✅ Language Constructs
- Variable declarations: `let x > int = 5;`
- Arithmetic expressions: `x + 3 * 4;`
- Expression statements: `x + y;`
- Assignments: `x = x + 1;`
- `show(...)` for printing values
- `if-else` conditionals: `if (x) [ ... ] else [ ... ]`
- `while` loops: `while (x < 5) [ ... ]`
- Block scoping using square brackets: `[ stmt1; stmt2; ]`

---

### ✅ Parsing + AST
- Custom grammar using `ANTLR4` (`MLang.g4`)
- AST node hierarchy:
  - `ProgramNode`, `LetDeclNode`, `AssignStmtNode`, `ExprStmtNode`
  - `BinaryOpNode`, `IntLiteralNode`, `IdNode`
  - `IfStmtNode`, `WhileStmtNode`, `ShowStmtNode`, `BlockNode`
- AST built via `MLangASTBuilder.java` using ANTLR’s `MLangBaseVisitor`
- Pretty-printer (`TestMLang.java`) to visually debug the AST

---

## 🛠️ Build & Execution Instructions

### 📂 Adding Test Files
- Place your test files (with `.ml` extension) in the `tests/` folder.
- Example: `tests/loop_test.ml`

```mlang
let i > int = 0;
while (i < 3) [
    show(i);
    i = i + 1;
]
```

### ▶️ Running the Project

From the `MLANG/` root directory:

```bash
make                             # Builds everything (ANTLR, Java)
java -cp bin TestMLang           # Runs TestMLang on default file
```

To run a specific test file:
Edit `TestMLang.java`:
```java
String inputCode = Files.readString(Paths.get("tests/loop_test.ml"));
```

Then re-run:
```bash
make
java -cp bin TestMLang
```

---

## 📦 Project Structure
```bash
MLANG/
├── src/
│   ├── MLang.g4                # ANTLR grammar
│   ├── MLangASTBuilder.java    # AST builder from parse tree
│   ├── TestMLang.java          # Main driver with AST printer
│   └── ast/                    # Custom AST node classes
├── gen/                        # ANTLR-generated parser/lexer
├── bin/                        # Compiled .class files
├── lib/                        # antlr-4.13.1-complete.jar
├── tests/                      # .ml test files go here ✅
├── Makefile                    # Build automation
└── README.md
```

---

## ⚠️ Challenges Encountered

- **ANTLR output folder issue** (`gen/src/`):  
  Fixed by running ANTLR from within `src/` with output to `../gen/`.

- **Wildcard compilation failure after clean**:  
  Solved using `$(wildcard gen/*.java)` in the Makefile.

- **Broken Java import statements**:  
  Removed invalid `import .antlr...` and relied on proper classpath.

- **Makefile dependency resolution**:  
  Used `gen/MLangParser.java` as target to ensure correct order.

---

## 🧪 Sample Input

```mlang
let x > int = 1;
if (x == 1) [ show(x); ] else [ show(0); ]
```

## 🧾 Sample Output (AST)

```mlang
Program
  VarDecl: x > int
    IntLiteral: 1
  IfStmt
    Condition:
      BinaryOp: ==
        Id: x
        IntLiteral: 1
    Then:
      Block
        Show
          Id: x
    Else:
      Block
        Show
          IntLiteral: 0
```

---

🧠 **Author**  
Mudit Golchha  
CS571 – Programming Languages  
Binghamton University