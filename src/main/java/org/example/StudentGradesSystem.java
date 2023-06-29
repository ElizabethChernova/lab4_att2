package org.example;

import java.util.ArrayList;

public class StudentGradesSystem {
    int gradeMath;
    int gradeJava;
    int gradeEnglish;
    int gradeGerman;
    int gradeHistory;

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    ArrayList<Integer> grades;
    public StudentGradesSystem(int gradeMath, int gradeJava, int gradeEnglish, int gradeGerman, int gradeHistory) {
        this.gradeMath = gradeMath;
        this.gradeJava = gradeJava;
        this.gradeEnglish = gradeEnglish;
        this.gradeGerman = gradeGerman;
        this.gradeHistory = gradeHistory;
        grades= new ArrayList<Integer>();
        grades.add(gradeEnglish);
        grades.add(gradeGerman);
        grades.add(gradeHistory);
        grades.add(gradeJava);
        grades.add(gradeMath);
    }

    public StudentGradesSystem() {
        grades= new ArrayList<Integer>();
    }

public void addGrade(int grade){
        grades.add(grade);
}
    public double countAverage(){
        return grades.stream()
                .mapToDouble(a -> a)
                .sum()/grades.size();
    }
    public int findMax(){
        int maximum = grades.get(0);
        for (int i = 1; i < grades.size(); i++) {
            if (maximum < grades.get(i))
                maximum = grades.get(i);
        }
    return maximum;
    }
    public int checkAmountofGrades(){
        return grades.size();
    }
    public String ifTheGradeIsPossitive(int gr){
   if( gr>=61)return "yes";
   return "no";
    }
    public int findMin(){
        int min = grades.get(0);
        for (int i = 1; i < grades.size(); i++) {
            if (min > grades.get(i))
                min = grades.get(i);
        }
        return min;
    }
    public String doesStudentPass() {
        int min = grades.get(0);
        for (int i = 1; i < grades.size(); i++) {
            if (min > grades.get(i))
                min = grades.get(i);
        }
if(min>=61){return "yes";}
   else{ return "no";}}


}
