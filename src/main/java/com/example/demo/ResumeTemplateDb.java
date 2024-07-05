package com.example.demo;
import java.util.ArrayList;
import java.util.List;

public class ResumeTemplateDb {
    private List<ResumeTemplate1> templateList;

    public ResumeTemplateDb() {
        this.templateList = new ArrayList<>();
        // Initialize with some dummy data for demonstration
        templateList.add(new ResumeTemplate1("Template 1", "Description of Template 1", "E:/placement2months/demo/src/main/java/com/example/demo/Template/template1.docx"));
        //templateList.add(new ResumeTemplate1("Template 2", "Description of Template 2", "E:/placement2months/demo/src/main/java/com/example/demo/Template/template2.doc"));
    }

    public List<ResumeTemplate1> getAllTemplates() {
        return templateList;
    }

    public ResumeTemplate1 getTemplateByName(String templateName) {
        for (ResumeTemplate1 template : templateList) {
            if (template.getTemplateName().equals(templateName)) {
                return template;
            }
        }
        return null;
    }
}
