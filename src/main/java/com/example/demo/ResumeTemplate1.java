package com.example.demo;

/**
 * Represents a resume template with its name, description, and file path.
 */
public class ResumeTemplate1 {
    private String templateName;
    private String templateDescription;
    private String templateFilePath;

    /**
     * Constructs a new ResumeTemplate1 object.
     *
     * @param templateName        The name of the template.
     * @param templateDescription A brief description of the template.
     * @param templateFilePath    The file path where the template is stored.
     */
    public ResumeTemplate1(String templateName, String templateDescription, String templateFilePath) {
        this.templateName = templateName;
        this.templateDescription = templateDescription;
        this.templateFilePath = templateFilePath;
    }

    /**
     * Retrieves the name of the template.
     *
     * @return The template name.
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * Sets the name of the template.
     *
     * @param templateName The new template name to set.
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * Retrieves the description of the template.
     *
     * @return The template description.
     */
    public String getTemplateDescription() {
        return templateDescription;
    }

    /**
     * Sets the description of the template.
     *
     * @param templateDescription The new template description to set.
     */
    public void setTemplateDescription(String templateDescription) {
        this.templateDescription = templateDescription;
    }

    /**
     * Retrieves the file path where the template is stored.
     *
     * @return The template file path.
     */
    public String getTemplateFilePath() {
        return templateFilePath;
    }

    /**
     * Sets the file path where the template is stored.
     *
     * @param templateFilePath The new template file path to set.
     */
    public void setTemplateFilePath(String templateFilePath) {
        this.templateFilePath = templateFilePath;
    }
}
