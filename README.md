
# MLang 🧠

**MLang** is a custom programming language with a unique syntax and structure, built using **ANTLR4** and Java.  
It supports variables, arithmetic expressions, control flow (`if`, `while`), output (`show`), and block scoping.

---

## 🚀 Features Implemented

### ✅ Language Constructs
- **Variable declarations** (with `let`)
  ```mlang
  let x > int = 5;
  ```
- **Assignments**
  ```mlang
  x = x + 1;
  ```
- **Arithmetic expressions**
  ```mlang
  x + 3 * 4;
  ```
- **Comparison expressions**
  ```mlang
  if (x == 0) [ ... ]
  ```
- **`show(...)` for printing values**
  ```mlang
  show(x);
  ```
- **`if-else` control flow**
  ```mlang
  if (x > 0) [ show(1); ] else [ show(0); ]
  ```
- **`while` loops**
  ```mlang
  while (x < 5) [ ... ]
  ```
- **Block scoping** using square brackets
  ```mlang
  [ stmt1; stmt2; ]
  ```

---

### ✅ Parsing + AST
- **ANTLR4 Grammar** (`MLang.g4`) custom defined
- **AST Node Hierarchy**:
  - `ProgramNode`, `LetDeclNode`, `AssignStmtNode`, `ExprStmtNode`
  - `BinaryOpNode`, `IntLiteralNode`, `IdNode`
  - `IfStmtNode`, `WhileStmtNode`, `ShowStmtNode`, `BlockNode`
- **AST built** via `MLangASTBuilder.java` using ANTLR `MLangBaseVisitor`
- **AST pretty-printer** (`printAST`) for visualization

---

### ✅ Interpreter
- **Interpreter implemented** (`runtime/Interpreter.java`)
- Executes programs by visiting AST nodes:
  - Variable Environment Management
  - Expression Evaluation
  - Control Flow Execution (`if`, `while`)
  - Output to Console using `show`
- Handles both **integer** and **boolean** conditions

---

## 🛠️ Build & Execution Instructions

### 📂 Adding Test Files
- Place `.ml` test programs inside the `tests/` folder.
- Example: `tests/assign_while_show.ml`

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
make clean
make
make run
```

✅ `make` handles ANTLR code generation, Java compilation, and execution.

**To run a specific test file**:  
Edit `TestMLang.java`:

```java
String inputCode = Files.readString(Paths.get("tests/assign_while_show.ml"));
```

Then rerun `make run`.

---

## 📦 Project Structure

```
MLANG/
├── src/
│   ├── MLang.g4               # ANTLR grammar
│   ├── MLangASTBuilder.java   # AST builder
│   ├── TestMLang.java         # Main driver (AST print + Interpreter run)
│   ├── ast/                   # AST Node classes
│   └── runtime/               # Interpreter and Environment
├── gen/                       # ANTLR-generated parser and lexer
├── bin/                       # Compiled .class files
├── lib/                       # antlr-4.13.1-complete.jar
├── tests/                     # Test programs (.ml)
├── Makefile                   # Build automation
└── README.md
```

---

## 🧪 Sample Input Program

```mlang
let i > int = 0;
while (i < 3) [
    show(i);
    i = i + 1;
]
```

### 📖 Sample AST Output

```
Program
  VarDecl: i > int
    IntLiteral: 0
  WhileStmt
    Condition:
      BinaryOp: <
        Id: i
        IntLiteral: 3
    Body:
      Block
        Show
          Id: i
        Assign: i
          BinaryOp: +
            Id: i
            IntLiteral: 1
```

### 📤 Sample Execution Output

```
0
1
2
```

---

## ⚠️ Challenges Encountered

- **ANTLR Output Directory Problems**:  
  Fixed by running ANTLR from `src/` with output to `gen/`.

- **Classpath and Compilation Issues**:  
  Used `$(wildcard gen/*.java)` and explicitly included `src/runtime/*.java`.

- **Parser Condition Handling**:  
  Updated interpreter to allow both `boolean` and `integer` conditions for `if` and `while`.

- **Broken AST builds on invalid syntax**:  
  Improved testing and syntax error checks in `.ml` files.

---

## 📜 Future Extensions
- Add `float` and `bool` types fully (currently only `int` supported)
- Add `function` definitions and calls
- Add `arrays`, `for` loops, and standard library support
- Improve parser error messages (currently minimal error recovery)

---

🧠 **Author**  
Mudit Golchha  
CS571 – Programming Languages  
Binghamton University
