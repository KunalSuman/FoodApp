#!/bin/bash

# Set variables
SRC_DIR="src"
BIN_DIR="bin"
MAIN_CLASS="Main"

# Start Xvfb if not running
if ! pgrep -x "Xvfb" > /dev/null; then
    echo "Starting Xvfb..."
    Xvfb :99 -screen 0 1920x1080x24 &
    export DISPLAY=:99
fi

# Export DISPLAY variable
export DISPLAY=:99

# Create the bin directory if it doesn't exist
if [ ! -d "$BIN_DIR" ]; then
    mkdir "$BIN_DIR"
fi

# Compile Java files
echo "Compiling Java files..."
javac -d "$BIN_DIR" $(find "$SRC_DIR" -name "*.java")

if [ $? -eq 0 ]; then
    echo "Compilation successful. Classes saved to $BIN_DIR."
    # Run the program
    echo "Running the program..."
    java -cp "$BIN_DIR" "$MAIN_CLASS"
else
    echo "Compilation failed. Please check the errors above."
fi
