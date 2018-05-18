/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gradebookdom;

import java.util.*;
import java.util.ArrayList;


public class Student {

    private int studentID;
    private String fname;
    private String lname;
    private ArrayList<Grade> grades;

    public Student() {
        studentID=-1;
        fname="";
        lname="";
        grades=new ArrayList<Grade>();
    }

    public Student(int studentID, String fname, String lname) {
        this.studentID = studentID;
        this.fname = fname;
        this.lname = lname;
        this.grades=new ArrayList<Grade>();
    }

    /**
     * @return the studentID
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * @param studentID the studentID to set
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * @return the fname
     */
    public String getFname() {
        return fname;
    }

    /**
     * @param fname the fname to set
     */
    public void setFname(String fname) {
        this.fname = fname;
    }

    /**
     * @return the lname
     */
    public String getLname() {
        return lname;
    }

    /**
     * @param lname the lname to set
     */
    public void setLname(String lname) {
        this.lname = lname;
    }


    public void addGrade(Grade grade){
        grades.add(grade);
    }

    public void addGrade(int assignmentID,int score){
        this.addGrade(new Grade(assignmentID, score));
    }

    public Grade getGrade(int assignmentID){
        for (Grade g:grades){
            if (g.getAssignmentID()==assignmentID)
                return g;
        }
        return null;

    }
   @Override
    public String toString() 
    {
          //for (int i; i>Grades.length())
        //  {
         //      grade scores = student.getGrade(i);
               
        //  }
        return "Student id={" +  studentID +  ", fname=" + fname + ", lname=" + lname + ", grades=" + grades.toString() +'}';
    
    
       // return "Employee{" + "empID=" + empID + ", deptID=" + deptID + ", fname=" + fname + ", lname=" + lname + ", ssn=" + ssn + ", dobYear=" + dobYear + ", dobMonth=" + dobMonth + ", dobDay=" + dobDay + '}';
    
    }

}
