# MLang 🧠

MLang is a simple, custom programming language with its own grammar, parser, and AST — built using ANTLR4 and Java.

## 🚀 Features

- Custom grammar (`MLang.g4`) using ANTLR
- Custom AST classes in Java
- Parser + AST builder (`MLangASTBuilder`)
- Expression evaluation and future control flow support (if, while, for)

## 🛠️ Project Structure
```bash
MLANG/
├── src/               # Source files and grammar
│   ├── MLang.g4
│   ├── TestMLang.java
│   └── ast/           # AST classes
├── gen/               # Generated ANTLR files (ignored in Git)
├── bin/               # Compiled .class files (ignored in Git)
├── lib/               # ANTLR JAR file
├── README.md
├── .gitignore
``` 

## 🔧 How to Build and Run

### 1. Generate ANTLR Lexer and Parser

```bash
java -jar lib/antlr-4.13.1-complete.jar -Dlanguage=Java -o gen src/MLang.g4
```

### 2. Compile All Java Files

```bash
javac -cp "lib/antlr-4.13.1-complete.jar" -d bin gen/*.java src/**/*.java
```

### 3. Run the Test

```bash
java -cp "bin:lib/antlr-4.13.1-complete.jar" TestMLang
```

### ✅ Sample Input

x > int = 5;

### 📚 Dependencies
	•	Java 11+ (JDK)
	•	ANTLR 4.13.1 JAR (in lib/ directory)

### 🧠 Author

Mudit Golchha
Binghamton University — CS571