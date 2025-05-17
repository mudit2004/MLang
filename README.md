
# MLang 🧠

**MLang** is a custom programming language with a unique syntax and structure, built using **ANTLR4** and Java.  
It supports variables, arithmetic expressions, functions, control flow (`if`, `while`), output (`show`), input (`take()`), and block scoping.

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

- **`take()` for user input**
  ```mlang
  let x > int = take();
  ```

- **`if-else` control flow**
  ```mlang
  if (x > 0) [ show(1); ] else [ show(0); ]
  ```

- **`while` loops**
  ```mlang
  while (x < 5) [ ... ]
  ```

- **Function declarations and calls**
  ```mlang
  func add(x > int, y > int) > int [
      return x + y;
  ]
  let result > int = add(2, 3);
  ```

- **Block scoping** using square brackets
  ```mlang
  [ stmt1; stmt2; ]
  ```

---

## ✅ Parsing + AST
- **ANTLR4 Grammar** (`MLang.g4`) custom defined
- **AST Node Hierarchy**:
  - `ProgramNode`, `LetDeclNode`, `AssignStmtNode`, `ExprStmtNode`
  - `BinaryOpNode`, `IntLiteralNode`, `IdNode`, `InputExprNode`
  - `IfStmtNode`, `WhileStmtNode`, `ShowStmtNode`, `BlockNode`
  - `FuncDeclNode`, `FuncCallNode`, `ReturnStmtNode`
- **AST built** via `MLangASTBuilder.java` using ANTLR `MLangBaseVisitor`
- **AST pretty-printer** (`printAST`) for visualization

---

## ✅ Interpreter
- **Interpreter implemented** (`runtime/Interpreter.java`)
- Executes programs by visiting AST nodes:
  - Variable environment management
  - Expression evaluation
  - Function call/return stack with local scope
  - Control flow execution (`if`, `while`)
  - Output to console using `show`
  - Input from user using `take()`
- Handles both **integer** and **boolean** conditions

---

## 🛠️ Build & Execution Instructions

### 📂 Adding Test Files
- Place `.ml` test programs inside the `tests/` folder.
- Example: `tests/input_test.ml`

```mlang
let x > int = take();
show(x + 1);
```

### ▶️ Running the Project

From the `MLANG/` root directory:

```bash
make clean
make
```

✅ `make` handles ANTLR code generation, Java compilation, and execution.

**To run a specific test file**:  
Edit `TestMLang.java`:

```java
String inputCode = Files.readString(Paths.get("tests/input_test.ml"));
```

Then rerun `make`.

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
let num > int = take();
show(num + 1);
```

### 📖 Sample AST Output

```
Program
  VarDecl: num > int
    InputExpr (take)
  Show
    BinaryOp: +
      Id: num
      IntLiteral: 1
```

### 📤 Sample Execution Output

```
take> 42
43
```

---

## ⚠️ Challenges Encountered

- **ANTLR Output Directory Problems**:  
  Fixed by running ANTLR from `src/` with output to `gen/`.

- **Classpath and Compilation Issues**:  
  Used `$(wildcard gen/*.java)` and explicitly included `src/runtime/*.java`.

- **Variable Initialization Order**:  
  Interpreter defines variable names *before* evaluating their initializers.

- **Return flow handling in functions**:  
  Used `ReturnException` to simulate non-local returns.

- **Local scope for functions**:  
  Functions execute in isolated environments (not modifying global state).

- **Input support**:  
  Added `take()` expression for reading integers via `Scanner`.

---

## 📜 Future Extensions
- Add `float` and `bool` types fully (currently only `int` supported)
- Add support for recursion and higher-order functions
- Add `arrays`, `for` loops, and standard library support
- Improve parser error messages (currently minimal error recovery)

---

🧠 **Author**  
Mudit Golchha  
CS571 – Programming Languages  
Binghamton University
