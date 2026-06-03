# Java Swing Desktop Calculator Application

A lightweight, cross-platform **desktop calculator application** built natively in Java utilizing the robust `javax.swing` and `java.awt` graphical user interface frameworks. The application features an interactive dual-mode engine enabling effortless switching between standard daily calculation grids and an advanced scientific math layout.

## ✨ Core Features & Calculation Capabilities
* **Dual Layout Modes:** Smooth runtime switching between basic layout screens and scientific parameter views (`SIM` vs `SCI`).
* **Standard Arithmetic:** Complete logic handling for floating-point addition (`+`), subtraction (`-`), multiplication (`*`), and division (`/`).
* **Advanced Scientific Engine:** Real-time computational processing for trigonometric algorithms (`sin`, `cos`, `tan`, `cosec`, `sec`, `cot`), exponential powers (`x^x`, `e^x`, `X^2`), and natural logarithms (`Ln`).
* **Dynamic GUI Feedback:** Implements modern Event Dispatching via the `ActionListener` design pattern to capture user UI interactions securely.

## 🛠️ Architecture & Tech Stack
* **Language:** Java (JDK 8 or higher)
* **GUI Toolkit:** Java Swing (`JFrame`, `JPanel`, `JButton`, `JTextField`)
* **Layout Design:** Absolute structural coordinate mappings for crisp component presentation.

## 🚀 How to Download, Build, and Run

### Prerequisites
Ensure you have the Java Development Kit (JDK) installed on your operating system.

### 1. Clone the Directory
```bash
git clone https://github.com
cd calculator
```

### 2. Compile the Source Code
Compile the primary entry point file using the standard Java compiler command:
```bash
javac CalculatorSimple.java
```

### 3. Execute the Application
Launch the compiled bytecode to initialize the GUI application window:
```bash
java CalculatorSimple
```

## 📄 License
This project is open-source and available under the [MIT License](LICENSE).
