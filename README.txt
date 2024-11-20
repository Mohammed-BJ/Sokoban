### README

# Sokoban Game Project

## Overview
This is a Java-based implementation of the Sokoban game. The project uses an Object-Oriented Programming (OOP) approach, with the game logic, user interface, and core functionalities separated into dedicated packages.  

## Current Issues
The project is currently under development, and some known issues need to be addressed:  
1. **File Not Found Error**  
   - The program cannot locate the `Level1.txt` file in the `resources/levels/` directory.  
   - Cause: Incorrect file path configuration or missing level file.  
2. **NullPointerException**  
   - The `getGrid()` method in the `Board` class returns `null`, likely due to improper initialization of the game grid.  

## Next Steps
- Correct the file path handling for loading levels.
- Ensure proper initialization of the game board and grid in the `Board` class.
- Refactor the code where necessary to improve stability and performance.

## Instructions
1. Ensure the following project structure:  
   ```
Sokoban/
├── src/
├── resources/
│   ├── levels/
│   │   ├── level1.txt
│   └── images/
└── bin/
   ```
2. Use the provided `Makefile` to compile and run the project:  
   ```bash
	make all
	make run
	make clear // to clear bin 
   ```

Stay tuned for updates as the issues are resolved!