# Variables
SRC_DIR = src
BIN_DIR = bin
RESOURCES_DIR = resources
MAIN_CLASS = SokobanMain

# Liste des fichiers source
SOURCES := $(shell find $(SRC_DIR) -name "*.java")

# Commandes
.PHONY: all run clean

# Compilation
all:
	mkdir -p $(BIN_DIR)
	javac -d $(BIN_DIR) -sourcepath $(SRC_DIR) $(SOURCES)

# Exécution
run: all
	java -cp $(BIN_DIR) $(MAIN_CLASS)

# Nettoyage
clean:
	rm -rf $(BIN_DIR)
