#!/bin/bash

# Create the bin directory if it doesn't exist
mkdir -p bin

# Compile all Java files in the src directory and its subdirectories, placing .class files in the bin directory
javac -d bin $(find src -name "*.java")

# Check if compilation was successful
if [ $? -eq 0 ]; then
    echo "Compilation successful."

    # Run the main class (replace MainClassName with the name of your main class)
    java -cp bin Main
else
    echo "Compilation failed."
fi

