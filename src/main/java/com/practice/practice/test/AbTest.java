package com.practice.practice.test;

import com.practice.practice.model.Student;

import java.util.ArrayList;
import java.util.List;

public class AbTest {
    public static void main(String[] args) {
        Student student1 = new Student("张三",21);
        Student student2 = new Student("李四",22);
        Student student3 = new Student("王五",23);
        Student student4 = new Student("刘二",24);
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        for (Student stu:studentList) {
            System.out.println(stu.toString());
        }
    }
}


class Abclass{

}