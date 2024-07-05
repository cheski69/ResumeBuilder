import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChooseTemplate extends JFrame {
    private JComboBox<String> templateComboBox;
    private JButton btnSelect;
    private String selectedTemplate;

    public ChooseTemplate() {
        setTitle("Choose Template");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 400, 200);
        setLayout(new GridBagLayout());

        // Template options
        String[] templates = {"template1.docx", "template2.docx"}; // Add more template names as needed

        templateComboBox = new JComboBox<>(templates);
        templateComboBox.setPreferredSize(new Dimension(200, 40));

        btnSelect = new JButton("Select");
        btnSelect.setPreferredSize(new Dimension(100, 40));
        btnSelect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedTemplate = (String) templateComboBox.getSelectedItem();
                setVisible(false); // Hide the selection window
                new ResumeUI(selectedTemplate).setVisible(true); // Open ResumeUI with selected template
            }
        });

        // Layout management
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Choose a Template:"), gbc);

        gbc.gridx = 1;
        add(templateComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(btnSelect, gbc);

        pack();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                ChooseTemplate frame = new ChooseTemplate();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
