# 🧰 Visual Keyboard Event Demo (Java Swing)
## rise internship project 

This Java Swing application visually demonstrates keyboard events. When a key is pressed or released on the physical keyboard, the corresponding key on a virtual on-screen keyboard is highlighted, and the event is logged in a text area.

## ✨ Features

- Real-time key press, release, and typed character logging.
- Visual keyboard panel that highlights keys as you press them.
- Covers standard, function, navigation, and numpad keys.
- Organized layout using `JFrame`, `JTextArea`, and a custom `KeyboardPanel`.

## 📷 Screenshot

> <img width="1918" height="1017" alt="image" src="https://github.com/user-attachments/assets/def9e702-4590-4c23-b5e6-bee6a6cb213b" />


## 🛠️ Requirements

- Java Development Kit (JDK) 8 or later
- Any IDE (e.g., IntelliJ IDEA, Eclipse, NetBeans) or just a terminal/command prompt

## 🧾 How It Works

- `VisualKeyboardEventDemo` is a JFrame-based window that listens for key events.
- `KeyboardPanel` is a custom JPanel that draws keys using `Graphics2D`, based on `KeyEvent` constants.
- Pressing a key updates the UI and logs the event in a `JTextArea`.

## 🚀 How to Run

### 1. Compile

```bash
javac VisualKeyboardEventDemo.java
