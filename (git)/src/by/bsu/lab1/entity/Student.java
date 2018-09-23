package by.bsu.lab1.entity;

import com.sun.javaws.exceptions.InvalidArgumentException;

import java.util.ArrayList;
import java.util.List;

public class Student {

    private String name;
    private List<Integer> marks;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
        this.marks = new ArrayList<Integer>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public void setMarks(List<Integer> marks) {
        this.marks = marks;
    }

    public void addMark(int mark) {
        if (mark >= 0 && mark <= 10) {
            this.marks.add(mark);
        } else {
            throw new IllegalArgumentException("The mark should be in range: [0,10]");
        }
    }

    public void addMarks(int marks[]) {
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] >= 0 && marks[i] <= 10) {
                this.marks.add(marks[i]);
            } else {
                throw new IllegalArgumentException("The mark should be in range: [0,10]");
            }
        }

    }


    public double getAverageMark() {
        double marksSum = 0;

        if (!marks.isEmpty()) {
            for (int markVar : marks) {
                marksSum += markVar;
            }
            return marksSum / marks.size();
        }

        return marksSum;
    }

}
