package by.bsu.lab1.entity;

import java.util.List;

public class Group {
    private List<Student> students;

    public Group() {}

    public Group(List<Student> students) {
        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public double getAverageStudnetsMark() {
        double marksSum = 0;

        if (!students.isEmpty()) {
            for (Student studentVar : students) {
                marksSum += studentVar.getAverageMark();
            }
            return marksSum/students.size();
        }

        return marksSum;
    }
}
