package by.bsu.lab1.runner;

import by.bsu.lab1.entity.Group;
import by.bsu.lab1.entity.Student;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Student student1 = new Student("Pap");
        student1.addMarks(new int[] {4,4});
        Student student2 = new Student("Tree");
        student2.addMarks(new int[] {2});
        Student student3 = new Student("Furtado");
        student2.addMarks(new int[] {2,10});

        Group group1 = new Group(Arrays.asList(student1, student2));
        System.out.println(group1.getAverageStudnetsMark());
    }
}
