import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmailGUI {

    private Email email;

    public EmailGUI() {
        // Create a frame
        JFrame frame = new JFrame("Email System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Create components
        JLabel firstNameLabel = new JLabel("First Name:");
        JTextField firstNameField = new JTextField(15);

        JLabel lastNameLabel = new JLabel("Last Name:");
        JTextField lastNameField = new JTextField(15);

        JButton createButton = new JButton("Create Email");
        JTextArea outputArea = new JTextArea(10, 30);
        outputArea.setEditable(false);

        // Add components to the frame
        JPanel panel = new JPanel();
        panel.add(firstNameLabel);
        panel.add(firstNameField);
        panel.add(lastNameLabel);
        panel.add(lastNameField);
        panel.add(createButton);
        panel.add(new JScrollPane(outputArea));

        frame.add(panel);

        // Button click listener
        createButton.addActionListener(e -> {
            String firstName = firstNameField.getText();
            String lastName = lastNameField.getText();
            if (!firstName.isEmpty() && !lastName.isEmpty()) {
                email = new Email(firstName, lastName); // Use your Email class
                outputArea.setText("Email Created:\n" +
                        "Name: " + firstName + " " + lastName + "\n" +
                        "Email: " + email.getEmail() + "\n" +
                        "Password: " + email.getPassword());
            } else {
                outputArea.setText("Please enter valid names!");
            }
        });

        // Display the frame
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EmailGUI();
    }
}
