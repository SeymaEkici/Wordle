import javax.swing.*;


public class Wordle {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Frame().setVisible(true);
        });
    }
}
