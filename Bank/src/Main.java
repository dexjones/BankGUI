import javax.swing.*;
public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Bank Balance Application"); // Empty JFrame created with a title
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Needed to exit program when GUI is closed
        frame.setSize(1200,800); // size of GUI set

        JPanel panel = new JPanel(); // JPanel created
        JLabel label = new JLabel("I am a label");
        panel.add(label); // label added to JPanel

        frame.getContentPane().add(panel); // add the JPanel to JFrame

        frame.setVisible(true); // Displays frame

    }
}