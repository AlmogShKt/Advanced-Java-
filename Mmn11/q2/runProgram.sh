#!/bin/bash

# Define the path to the JavaFX SDK
JAVAFX_SDK_PATH="/Users/almogshtaigmann/javafx-sdk-23.0.1/lib"  # Replace this with your actual path to JavaFX SDK's lib folder

# Navigate to the directory containing your compiled .class files or .jar file

# Run the Main class (GraphApplication) with JavaFX modules included in the classpath
java --module-path $JAVAFX_SDK_PATH --add-modules javafx.controls,javafx.fxml mmn11.mmn11q2.GraphApplication

# Simulate the 'pause' behavior
read -p "Press any key to continue..."