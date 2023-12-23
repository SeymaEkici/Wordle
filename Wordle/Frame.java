import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class Frame extends JFrame {
   Frame(){

       //Basic setups for frame
       this.setTitle("Wordle Game");
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //this.setResizable(false);
       this.setSize(420,420);
       this.setLayout(new GridBagLayout());
       this.getContentPane().setBackground(new Color(246, 214, 214)); // background coloring

       //Changing Icon of the frame
       ImageIcon image = new ImageIcon("logo.png"); //create an image icon
       this.setIconImage(image.getImage()); // change icon of frame

       //WORDLE Label
       JLabel label = new JLabel();
       label.setText("WORDLE");
       label.setVerticalAlignment(JLabel.CENTER);
       label.setHorizontalAlignment(JLabel.CENTER);
       label.setFont(new Font("Verdana", Font.BOLD, 30)); // Set font and size
       label.setPreferredSize(new Dimension(200, 50));
       label.setBackground(new Color(246, 247, 196));
       label.setOpaque(true);
       label.setForeground(new Color(123, 211, 234));

       GridBagConstraints labelConstraints = new GridBagConstraints();
       labelConstraints.gridx = 0;
       labelConstraints.gridy = 0;
       labelConstraints.gridwidth = 5; // Span across 5 columns
       this.add(label, labelConstraints);


       // creating 6 words (rows) with 5 letters (column)
       addTextFieldWithFilter(6, 5);

   }

    private void addTextFieldWithFilter(int rows, int columns) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                JTextField textField = new JTextField();
                setDocumentFilterForTextField(textField);
                textField.setPreferredSize(new Dimension(40, 40));
                this.add(textField, constraints);
                constraints.gridx++;
            }
            constraints.gridx = 0;
            constraints.gridy++;
        }
    }

    private void setDocumentFilterForTextField(JTextField textField) {
        ((AbstractDocument) textField.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.length() == 1 && text.matches("[a-zA-Z]")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }

}
