package by.bsu.lab1.runner;

import by.bsu.lab1.entity.Group;
import by.bsu.lab1.entity.Student;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Polo");
        student1.addMarks(new int[] {4,4});
        Student student2 = new Student("Ralph");
        student2.addMarks(new int[] {2});

        Group group1 = new Group(Arrays.asList(student1, student2));
        System.out.println(group1.getAverageStudnetsMark());
    }
}
