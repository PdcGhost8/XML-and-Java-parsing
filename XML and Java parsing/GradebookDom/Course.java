/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gradebookdom;

import java.util.*;
import java.util.ArrayList;

public class Course {
    private String courseName;
    private ArrayList<Assignment> assignments;
    private ArrayList<Student> students;

    public Course() {
        courseName="";
        assignments=new ArrayList<Assignment>();
        students=new ArrayList<Student>();
    }

    public Course(String courseName) {
        this.courseName = courseName;
        assignments=new ArrayList<Assignment>();
        students=new ArrayList<Student>();
    }



    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void addStudent(Student st){
        students.add(st);
    }

    public void addStudent(int studentID,String fname,String lname,int assiId ,int score){
        this.addStudent(new Student(studentID, fname, lname));
    }

    public void addAssignment(Assignment a){
        assignments.add(a);
    }

    public void addAssignment(int assignmentID,String description,int maxScore){
        this.addAssignment(new Assignment(assignmentID, description, maxScore));
    }

    public Assignment getAssignment(int assignmentID){
        for (Assignment a:assignments){
            if (a.getId()==assignmentID)
                return a;
        }
        return null;

    }

    public Student getStudent(int studentID){
        for (Student s:students){
            if (s.getStudentID()==studentID)
                return s;
        }
        return null;
    }

	 public void printCourse(){
        System.out.println(courseName);
        System.out.println("-----------------------------------");
        System.out.println("Assigments");
        
        for (Assignment a : assignments){
            System.out.println(a.toString());   
        }
        System.out.println("-----------------------------------");
        System.out.println("Students");
        for (Student st : students){
            System.out.println(st.toString());
            System.out.println(" grade 1: " + st.getGrade(1));
        }
        
         }
}
