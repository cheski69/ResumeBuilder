import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class ResumeUI extends JFrame {

    private JPanel contentPane;
    private JTextField textFieldFirstName;
    private JTextField textFieldSurname;
    private JTextField textFieldAddress;
    private JTextField textFieldAddress2;
    private JTextField textFieldContact;
    private JTextField textFieldEmail;
    private JTextField textFieldObjective;
    private JTextField textFieldExperience;
    private JTextField textFieldEducation;
    private JTextField textFieldAwards;
    private JTextField textFieldAchievements;
    private JTextField textFieldLanguages;
    private JTextField textFieldHobbies;
    private JTextField textFieldCertifications;
    private JTextField textFieldStrengths;
    private JTextField textFieldSkills;
    private JButton btnSave;
    private boolean saved = false; // Track if resume has been saved
    private String selectedTemplate;

    public ResumeUI(String selectedTemplate) {
        this.selectedTemplate = selectedTemplate;

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 800); // Adjusted initial size for demonstration
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        // Initialize text fields with adjusted size
        textFieldFirstName = new JTextField(20);
        textFieldSurname = new JTextField(20);
        textFieldAddress = new JTextField(20);
        textFieldAddress2 = new JTextField(20);
        textFieldContact = new JTextField(20);
        textFieldEmail = new JTextField(20);
        textFieldObjective = new JTextField(20);
        textFieldExperience = new JTextField(20);
        textFieldEducation = new JTextField(20);
        textFieldAwards = new JTextField(20);
        textFieldAchievements = new JTextField(20);
        textFieldLanguages = new JTextField(20);
        textFieldHobbies = new JTextField(20);
        textFieldCertifications = new JTextField(20);
        textFieldStrengths = new JTextField(20);
        textFieldSkills = new JTextField(20);

        // Create save button
        btnSave = new JButton("Save");
        btnSave.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                saveResume();
            }
        });

        // Layout using GridBagLayout for flexibility
        contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding between components

        // Example: add labels and text fields, adjust grid positions as needed
        gbc.gridx = 0;
        gbc.gridy = 0;
        contentPane.add(new JLabel("First Name:"), gbc);
        gbc.gridx = 1;
        contentPane.add(textFieldFirstName, gbc);

        // Add more labels and text fields as per your template fields

        // Add save button at the bottom
        gbc.gridx = 0;
        gbc.gridy = 14;
        gbc.gridwidth = 2; // Span across two columns
        gbc.anchor = GridBagConstraints.CENTER; // Center align button
        contentPane.add(btnSave, gbc);
    }

    private void saveResume() {
        // Example: save resume data to a file using selectedTemplate name
        // Adjust as per your application needs
        String filename = "E:\\placement2months\\demo\\Template\\" + selectedTemplate + ".docx";
        // Write your logic to save resume data to the file
        // Example: use Apache POI or any suitable library to write to a Word file
        saved = true;
        JOptionPane.showMessageDialog(this, "Resume saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean isSaved() {
        return saved;
    }
}
