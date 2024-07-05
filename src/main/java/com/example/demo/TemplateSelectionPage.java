import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;

public class TemplateSelectionPage extends JFrame {

    private JPanel contentPane;
    private JComboBox<String> templateComboBox;
    private JTextArea templatePreviewArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                TemplateSelectionPage frame = new TemplateSelectionPage();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public TemplateSelectionPage() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 600, 400); // Adjust dimensions as needed
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.NORTH);

        JLabel lblTemplate = new JLabel("Select Template:");
        panel.add(lblTemplate);

        templateComboBox = new JComboBox<>();
        panel.add(templateComboBox);

        JButton btnPreview = new JButton("Preview");
        btnPreview.addActionListener(e -> previewSelectedTemplate());
        panel.add(btnPreview);

        templatePreviewArea = new JTextArea();
        templatePreviewArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(templatePreviewArea);
        contentPane.add(scrollPane, BorderLayout.CENTER);

        // Load templates from Template folder
        loadTemplates();

        pack();
        setVisible(true);
    }

    private void loadTemplates() {
        File templateFolder = new File("Template"); // Adjust path if necessary
        if (templateFolder.exists() && templateFolder.isDirectory()) {
            File[] templateFiles = templateFolder.listFiles((dir, name) -> name.toLowerCase().endsWith(".docx"));
            if (templateFiles != null) {
                for (File templateFile : templateFiles) {
                    templateComboBox.addItem(templateFile.getName());
                }
            }
        }
    }

    private void previewSelectedTemplate() {
        String selectedTemplate = (String) templateComboBox.getSelectedItem();
        if (selectedTemplate != null) {
            File templateFile = new File("Template/" + selectedTemplate); // Adjust path if necessary
            if (templateFile.exists() && templateFile.isFile()) {
                try (FileInputStream fis = new FileInputStream(templateFile);
                     XWPFDocument document = new XWPFDocument(fis)) {

                    XWPFWordExtractor extractor = new XWPFWordExtractor(document);
                    String text = extractor.getText();
                    templatePreviewArea.setText(text);

                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(this, "Failed to load template: " + ex.getMessage(),
                            "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Selected template not found.", "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
