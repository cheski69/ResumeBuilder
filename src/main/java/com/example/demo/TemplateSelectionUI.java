package com.example.demo;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;


public class TemplateSelectionUI extends JFrame {
    private JComboBox<String> templateComboBox;
    private JButton selectButton;
    private JTextPane templatePreviewPane;
    private TemplateSelectionController controller;

    public TemplateSelectionUI(TemplateSelectionController controller) {
        if (controller == null) {
            throw new NullPointerException("Controller cannot be null");
        }
        this.controller = controller;

        initUI();
    }

    private void initUI() {
        setTitle(Constants.TITLE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(Constants.WIDTH, Constants.HEIGHT);

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel topPanel = new JPanel(new BorderLayout());
        JLabel lblChooseTemplate = new JLabel("Choose a Template:");
        topPanel.add(lblChooseTemplate, BorderLayout.WEST);

        templateComboBox = new JComboBox<String>();
        topPanel.add(templateComboBox, BorderLayout.CENTER);
        populateTemplateNames(); // Populate templates initially

        selectButton = new JButton("Select Template");
        selectButton.addActionListener(e -> {
            String selectedTemplateName = (String) templateComboBox.getSelectedItem();
            if (selectedTemplateName!= null) {
                ResumeTemplate1 selectedTemplate = controller.getTemplateByName(selectedTemplateName);
                if (selectedTemplate!= null) {
                    displayTemplatePreview(selectedTemplate);
                } else {
                    JOptionPane.showMessageDialog(TemplateSelectionUI.this,
                            "Template not found.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(TemplateSelectionUI.this,
                        "Please select a template.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        topPanel.add(selectButton, BorderLayout.EAST);

        contentPane.add(topPanel, BorderLayout.NORTH);

        templatePreviewPane = new JTextPane();
        templatePreviewPane.setContentType("text/html");
        templatePreviewPane.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(templatePreviewPane);
        contentPane.add(scrollPane, BorderLayout.CENTER);
    }

    private void populateTemplateNames() {
        List<ResumeTemplate1> allTemplates = controller.getAllTemplates();
        for (ResumeTemplate1 template : allTemplates) {
            templateComboBox.addItem(template.getTemplateName());
        }
    }

    private void displayTemplatePreview(ResumeTemplate1 template) {
        if (template == null) {
            return;
        }
        String htmlContent = "<html><body>";
        htmlContent += "<h2>" + template.getTemplateName() + "</h2>";
        htmlContent += "<p>" + template.getTemplateDescription() + "</p>";
        htmlContent += "<p>Template File Path: " + template.getTemplateFilePath() + "</p>";
        // You can further customize the preview based on your template structure
        htmlContent += "</body></html>";

        templatePreviewPane.setText(htmlContent);
    }

    public static void main(String[] args) {
        try {
            ResumeTemplateDb templateDb = new ResumeTemplateDb();
            TemplateSelectionController controller = new TemplateSelectionController(templateDb);
            TemplateSelectionUI frame = new TemplateSelectionUI(controller);
            frame.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "An error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
