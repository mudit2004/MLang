ANTLR_JAR = lib/antlr-4.13.1-complete.jar
SRC_DIR = src
GEN_DIR = gen
BIN_DIR = bin

CLASSPATH = "$(BIN_DIR):$(ANTLR_JAR)"

GRAMMAR = $(SRC_DIR)/MLang.g4

# Default target
all: run

# Generate parser and lexer using ANTLR
$(GEN_DIR)/MLangParser.java: $(GRAMMAR)
	cd src && java -jar ../lib/antlr-4.13.1-complete.jar -visitor -Dlanguage=Java -o ../gen MLang.g4

# Compile everything (after gen is complete)
build: $(GEN_DIR)/MLangParser.java
	javac -cp $(ANTLR_JAR) -d $(BIN_DIR) $(wildcard $(GEN_DIR)/*.java) $(SRC_DIR)/ast/*.java $(SRC_DIR)/runtime/*.java $(SRC_DIR)/MLangASTBuilder.java $(SRC_DIR)/TestMLang.java

# Run the program
run: build
	java -cp $(CLASSPATH) TestMLang

# Clean everything
clean:
	rm -rf $(GEN_DIR)/* $(BIN_DIR)/*