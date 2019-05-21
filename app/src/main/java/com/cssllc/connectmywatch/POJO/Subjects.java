package com.cssllc.connectmywatch.POJO;

public class Subjects {

    private String subjectName;
    private String subjectProgress;

    public Subjects(String subjectName, String subjectProgress) {
        this.subjectName = subjectName;
        this.subjectProgress = subjectProgress;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public String getSubjectProgress() {
        return subjectProgress;
    }
}
