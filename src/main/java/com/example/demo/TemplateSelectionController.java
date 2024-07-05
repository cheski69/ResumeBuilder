package com.example.demo;
import java.util.List;

public class TemplateSelectionController {
    private ResumeTemplateDb templateDb;

    public TemplateSelectionController(ResumeTemplateDb templateDb) {
        this.templateDb = templateDb;
    }

    public List<ResumeTemplate1> getAllTemplates() {
        return templateDb.getAllTemplates();
    }

    public ResumeTemplate1 getTemplateByName(String templateName) {
        return templateDb.getTemplateByName(templateName);
    }
}
