import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;

public class VisualKeyboardEventDemo extends JFrame implements KeyListener {

    private JTextArea textArea;
    private KeyboardPanel keyboardPanel;

    public VisualKeyboardEventDemo() {
        setTitle("Visual Keyboard Event");
        setSize(1200, 400);  // Adjusted size for better keyboard visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create and set up the text area
        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Create the keyboard panel
        keyboardPanel = new KeyboardPanel();

        // Set layout and add components
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);  // Text area in the center
        add(keyboardPanel, BorderLayout.SOUTH);  // Keyboard panel at the bottom

        // Add key listener to the frame
        addKeyListener(this);
        setFocusable(true);
        setVisible(true);
        setFocusTraversalKeysEnabled(false);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        String keyText = KeyEvent.getKeyText(keyCode);
        textArea.append("Key Pressed: " + keyText + "\n");

        // Highlight the pressed key on the keyboard
        keyboardPanel.highlightKey(keyCode, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        String keyText = KeyEvent.getKeyText(keyCode);
        textArea.append("Key Released: " + keyText + "\n");

        // Unhighlight the released key
        keyboardPanel.highlightKey(keyCode, false);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();

        // Append the typed character to the JTextArea
        if (keyChar != KeyEvent.VK_BACK_SPACE && keyChar != KeyEvent.VK_ENTER) {
            textArea.append("Key Typed: " + keyChar + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new VisualKeyboardEventDemo());
    }

    // Inner class to represent a keyboard layout with an image
    class KeyboardPanel extends JPanel {

        private HashMap<Integer, Rectangle> keyMap;
        private HashMap<Integer, Boolean> keyPressedMap;
        private HashMap<Integer, String> keyLabels;  // Stores labels for keys

        public KeyboardPanel() {
            keyMap = new HashMap<>();
            keyPressedMap = new HashMap<>();
            keyLabels = new HashMap<>();
            setPreferredSize(new Dimension(1000, 350));  // Adjusted to fit better

            // 2D array of key details: { {keyCode, label, x, y, width, height}, ... }
            Object[][] keyDetails = {
                {KeyEvent.VK_ESCAPE, "Esc", 240, 20, 50, 40},  // Added Escape key here
                {KeyEvent.VK_F1, "F1", 300, 20, 50, 40},
                {KeyEvent.VK_F2, "F2", 360, 20, 50, 40},
                {KeyEvent.VK_F3, "F3", 420, 20, 50, 40},
                {KeyEvent.VK_F4, "F4", 480, 20, 50, 40},
                {KeyEvent.VK_F5, "F5", 540, 20, 50, 40},
                {KeyEvent.VK_F6, "F6", 600, 20, 50, 40},
                {KeyEvent.VK_F7, "F7", 660, 20, 50, 40},
                {KeyEvent.VK_F8, "F8", 720, 20, 50, 40},
                {KeyEvent.VK_F9, "F9", 780, 20, 50, 40},
                {KeyEvent.VK_F10, "F10", 840, 20, 50, 40},
                {KeyEvent.VK_F11, "F11", 900, 20, 50, 40},
                {KeyEvent.VK_F12, "F12", 960, 20, 50, 40},
                {KeyEvent.VK_INSERT, "insert", 1020, 20, 50, 40},
            {KeyEvent.VK_DELETE, "Del", 1080, 20, 50, 40},  // Delete key added after F12
            // Add Home, End, Page Up, and Page Down keys after the Delete key
            {KeyEvent.VK_HOME, "Home", 1140, 20, 50, 40},  // Home key
            {KeyEvent.VK_END, "End", 1200, 20, 50, 40},  // End key
            {KeyEvent.VK_PAGE_UP, "PgUp", 1260, 20, 50, 40},  // Page Up key
            {KeyEvent.VK_PAGE_DOWN, "PgDn", 1320, 20, 50, 40},  // Page Down key
                {KeyEvent.VK_BACK_QUOTE, "`~", 250, 70, 50, 50},
                {KeyEvent.VK_1, "1!", 310, 70, 50, 50},
                {KeyEvent.VK_2, "2@", 370, 70, 50, 50},
                {KeyEvent.VK_3, "3#", 430, 70, 50, 50},
                {KeyEvent.VK_4, "4$", 490, 70, 50, 50},
                {KeyEvent.VK_5, "5%", 550, 70, 50, 50},
                {KeyEvent.VK_6, "6^", 610, 70, 50, 50},
                {KeyEvent.VK_7, "7&", 670, 70, 50, 50},
                {KeyEvent.VK_8, "8*", 730, 70, 50, 50},
                {KeyEvent.VK_9, "9(", 790, 70, 50, 50},
                {KeyEvent.VK_0, "0)", 850, 70, 50, 50},
                {KeyEvent.VK_MINUS, "-_", 910, 70, 50, 50},
                {KeyEvent.VK_EQUALS, "=+", 970, 70, 50, 50},
                {KeyEvent.VK_BACK_SPACE, "Back", 1030, 70, 80, 50},
                {KeyEvent.VK_TAB, "Tab", 230, 130, 80, 50},
                {KeyEvent.VK_Q, "Q", 320, 130, 50, 50},
                {KeyEvent.VK_W, "W", 380, 130, 50, 50},
                {KeyEvent.VK_E, "E", 440, 130, 50, 50},
                {KeyEvent.VK_R, "R", 500, 130, 50, 50},
                {KeyEvent.VK_T, "T", 560, 130, 50, 50},
                {KeyEvent.VK_Y, "Y", 620, 130, 50, 50},
                {KeyEvent.VK_U, "U", 680, 130, 50, 50},
                {KeyEvent.VK_I, "I", 740, 130, 50, 50},
                {KeyEvent.VK_O, "O", 800, 130, 50, 50},
                {KeyEvent.VK_P, "P", 860, 130, 50, 50},
                {KeyEvent.VK_OPEN_BRACKET, "[{", 920, 130, 50, 50},
                {KeyEvent.VK_CLOSE_BRACKET, "]} ", 980, 130, 50, 50},
                {KeyEvent.VK_BACK_SLASH, "\\|", 1040, 130, 80, 50},
                {KeyEvent.VK_CAPS_LOCK, "Caps Lock", 230, 190, 110, 50},
                {KeyEvent.VK_A, "A", 350, 190, 50, 50},
                {KeyEvent.VK_S, "S", 410, 190, 50, 50},
                {KeyEvent.VK_D, "D", 470, 190, 50, 50},
                {KeyEvent.VK_F, "F", 530, 190, 50, 50},
                {KeyEvent.VK_G, "G", 590, 190, 50, 50},
                {KeyEvent.VK_H, "H", 650, 190, 50, 50},
                {KeyEvent.VK_J, "J", 710, 190, 50, 50},
                {KeyEvent.VK_K, "K", 770, 190, 50, 50},
                {KeyEvent.VK_L, "L", 830, 190, 50, 50},
                {KeyEvent.VK_SEMICOLON, ";:", 890, 190, 50, 50},
                {KeyEvent.VK_QUOTE, "'\"", 950, 190, 50, 50},
                {KeyEvent.VK_ENTER, "Enter", 1010, 190, 100, 50},
                {KeyEvent.VK_SHIFT, "Shift", 230, 250, 130, 50},
                {KeyEvent.VK_Z, "Z", 360, 250, 50, 50},
                {KeyEvent.VK_X, "X", 420, 250, 50, 50},
                {KeyEvent.VK_C, "C", 480, 250, 50, 50},
                {KeyEvent.VK_V, "V", 540, 250, 50, 50},
                {KeyEvent.VK_B, "B", 600, 250, 50, 50},
                {KeyEvent.VK_N, "N", 660, 250, 50, 50},
                {KeyEvent.VK_M, "M", 720, 250, 50, 50},
                {KeyEvent.VK_COMMA, ",<", 780, 250, 50, 50},
                {KeyEvent.VK_PERIOD, ".>", 840, 250, 50, 50},
                {KeyEvent.VK_SLASH, "/?", 900, 250, 50, 50},
                {KeyEvent.VK_SHIFT, "Shift", 960, 250, 130, 50},
                {KeyEvent.VK_CONTROL, "Ctrl", 230, 310, 90, 50},
                {KeyEvent.VK_ALT, "Alt", 320, 310, 90, 50},
                {KeyEvent.VK_SPACE, "Space", 420, 310, 400, 50},  // Spacebar at bottom
                {KeyEvent.VK_ALT_GRAPH, "AltGr", 840, 310, 90, 50},
                {KeyEvent.VK_CONTROL, "Ctrl", 940, 310, 90, 50},
                {KeyEvent.VK_LEFT, "←", 1040, 310, 50, 50},   // Left Arrow
                {KeyEvent.VK_UP, "↑", 1100, 250, 50, 50},     // Up Arrow
                {KeyEvent.VK_RIGHT, "→", 1160, 310, 50, 50},  // Right Arrow
                {KeyEvent.VK_DOWN, "↓", 1100, 310, 50, 50},
                {KeyEvent.VK_CLEAR, "clear", 1120, 70, 50, 50},    // Down Arrow
                {KeyEvent.VK_NUM_LOCK, "Num", 1180, 70, 50, 50},
                {KeyEvent.VK_DIVIDE, "/", 1240, 70, 50, 50},
                {KeyEvent.VK_MULTIPLY, "*", 1300, 70, 50, 50},
                {KeyEvent.VK_SUBTRACT, "-", 1360, 70, 50, 50},
                {KeyEvent.VK_NUMPAD7, "7", 1180, 130, 50, 50},
                {KeyEvent.VK_NUMPAD8, "8", 1240, 130, 50, 50},
                {KeyEvent.VK_NUMPAD9, "9", 1300, 130, 50, 50},
                {KeyEvent.VK_ADD, "+", 1360, 130, 50, 110},
                {KeyEvent.VK_NUMPAD4, "4", 1180, 190, 50, 50},
                {KeyEvent.VK_NUMPAD5, "5", 1240, 190, 50, 50},
                {KeyEvent.VK_NUMPAD6, "6", 1300, 190, 50, 50},
                {KeyEvent.VK_NUMPAD1, "1", 1180, 250, 50, 50},
                {KeyEvent.VK_NUMPAD2, "2", 1240, 250, 50, 50},
                {KeyEvent.VK_NUMPAD3, "3", 1300, 250, 50, 50},
                {KeyEvent.VK_NUMPAD0, "0", 1220, 310, 70, 50},
                {KeyEvent.VK_DECIMAL, ".", 1300, 310, 50, 50}
            };

            // Add keys using the 2D array
            for (Object[] keyDetail : keyDetails) {
                int keyCode = (int) keyDetail[0];
                String keyLabel = (String) keyDetail[1];
                int x = (int) keyDetail[2];
                int y = (int) keyDetail[3];
                int width = (int) keyDetail[4];
                int height = (int) keyDetail[5];
                addKey(keyCode, keyLabel, new Rectangle(x, y, width, height));
            }
        }

        private void addKey(int keyCode, String keyLabel, Rectangle bounds) {
            keyMap.put(keyCode, bounds);
            keyPressedMap.put(keyCode, false);
            keyLabels.put(keyCode, keyLabel);  // Store the label for the key
        }

        public void highlightKey(int keyCode, boolean pressed) {
            if (keyPressedMap.containsKey(keyCode)) {
                keyPressedMap.put(keyCode, pressed);
                repaint();
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;

            // Enable anti-aliasing for smoother rendering
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // Draw highlighted keys
            for (int keyCode : keyMap.keySet()) {
                Rectangle rect = keyMap.get(keyCode);
                boolean isPressed = keyPressedMap.get(keyCode);

                // Set color based on pressed state
                g2d.setColor(isPressed ? new Color(255, 255, 0, 128) : new Color(200, 200, 200, 128));
                g2d.fill(rect);
                g2d.setColor(Color.BLACK);
                g2d.draw(rect);

                // Draw key label in the center of the key
                String label = keyLabels.getOrDefault(keyCode, "");  // Get label from the map
                FontMetrics metrics = g2d.getFontMetrics();
                int x = rect.x + (rect.width - metrics.stringWidth(label)) / 2;
                int y = rect.y + (rect.height + metrics.getHeight()) / 2 - metrics.getDescent();
                g2d.drawString(label, x, y);
            }
        }
    }
}
