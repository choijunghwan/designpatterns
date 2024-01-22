package org.example.strategy.grade;

import java.util.ArrayList;

public class Student {
    int studentID;
    String studentName;
    ArrayList<Subject> subjectList;

    public static final int BASIC = 0;
    public static final int MAJOR = 1;

    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        subjectList = new ArrayList<Subject>();
    }

    public void addSubject(String name, int score, boolean majorCode) {
        Subject subject = new Subject();
        subject.setName(name);
        subject.setScorePoint(score);
        subject.setMajorCode(majorCode);
        subjectList.add(subject);
    }

    public void showGradeInfo() {
        GradeEvaluation[] gradeEvaluations = {new BasicEvaluation(), new MajorEvaluation()};

        for (Subject subject : subjectList) {
            String grade;
            int score = subject.getScorePoint();

            if (subject.isMajorCode() == true) {
                grade = gradeEvaluations[MAJOR].getGrade(score);
            } else {
                grade = gradeEvaluations[BASIC].getGrade(score);
            }
            System.out.println("학생 " + studentName + "의 " + subject.getName() + " 과목 성적은 " + subject.getScorePoint() + "점 이고, 학점은 " + grade + " 입니다.");
        }
    }
}
