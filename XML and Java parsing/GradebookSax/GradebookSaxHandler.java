/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gradebooksax;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author pdc49_000
 */

public class GradebookSaxHandler extends DefaultHandler {
    private Course comp;
    private Assignment dept;
    private Student emp;
    private String data;
    private Grade grade;
    private int intData;
  
    public Course getCourse() {
        return comp;
    }
    
    
  
  
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        //super.characters(ch, start, length); //To change body of generated methods, choose Tools | Templates.
    String s = new String(ch, start, length);
        
        if(s.trim().length() == 0){
            return; //Trim and check, return if there is no data
        }
        data = s;
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //super.endElement(uri, localName, qName); //To change body of generated methods, choose Tools | Templates.
       switch (qName) {
            case "description":
                dept.setDescription(data);
                break;
            case "maxScore":
                int maxScoreInt = Integer.parseInt(data);
                dept.setMaxScore(maxScoreInt);
                break;
            case "Assignment":
                comp.addAssignment(dept);
                break;
            default:
                break;
        }
              
             
        switch (qName) {    
            case "fname":
                emp.setFname(data);
                break;
            case "lname":
                emp.setLname(data);
                break;
            case "<grades>":
                switch (qName){
                    case "score":
                     int ScoreInt = Integer.parseInt(data);    
                    grade.setScore(ScoreInt);
                    emp.addGrade(1, ScoreInt);
                }
            case "student":
                comp.addStudent(emp);
                break;
            default:
                break;
        }
    }

        /*  if (qName.equals("courseName")){ //when hit ending tag for name
            comp.setCourseName(data);
        }
        
        if (qName.equals("description")){ //when hit ending tag for name
            dept.setDescription(data);
        }
         if (qName.equals("Assignment")){ //when hit ending tag for assignment
           comp.addAssignment(dept);
         }
          if (qName.equals("assignmentID")){ //when hit ending tag for assignment
          int AssignId= Integer.parseInt(data);
          dept.setId(AssignId);
         }
          if (qName.equals("maxScore")){ //when hit ending tag for assignment
              dept.setMaxScore(intData);
            //  int scoreMax= Integer.parseInt(data);
           //   dept.setMaxScore(scoreMax);
              System.out.println("****max*****"+intData);
           
         } //throws null pointer not going to anything
         
         if (qName.equals("fname")){
             emp.setFname(data);
         }
        if (qName.equals("lname")){
            emp.setLname(data);
        }
        if (qName.equals("stuID")){
             int studentID= Integer.parseInt(data);
            emp.setStudentID(studentID); //stuid
        }
        if (qName.equals("Grades")){
          
             emp.addGrade(grade);
        }
          if (qName.equals("assignmentID")){ //when hit ending tag for assignment
            int AssignId= Integer.parseInt(data);
              grade.setAssignmentID(AssignId);
         }
         if (qName.equals("score")){
      
             grade.setScore(intData);
        }
       
        if (qName.equals("student"))
        {
            comp.addStudent(emp);
        }
        */
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        //super.startElement(uri, localName, qName, attributes); //To change body of generated methods, choose Tools | Templates.
        //assingment start
          
        if(qName.equals("Assignment")){
            dept = new Assignment();
            String id = attributes.getValue("assignmentID");
            int idInt = Integer.parseInt(id);
            dept.setId(idInt);
        }
            
        //Employee start
        if(qName.equals("student")){
            emp = new Student();
            int empId = Integer.parseInt(attributes.getValue("stuID"));
            emp.setStudentID(empId);
            
        }
  //      if(qName.equals("grade")){
 //        int deptId = Integer.parseInt(attributes.getValue("assignmentID"));
//            grade.setAssignmentID(deptId);
    
//}
}
        /*
        if (qName.equals("course")){
        comp = new Course();
            String name= attributes.getValue("courseName");
        }
        if (qName.equals("Assignment")){
           dept = new Assignment();
           String id= attributes.getValue("assignmentID");
           int intID= Integer.parseInt(id);
           dept.setId(intID);
           System.out.println("*********");
               
//          String description.getElementsByTagName("description");
        }
        //employees
        if (qName.equals("student")){
            emp = new Student();
            int empID=  Integer.parseInt(attributes.getValue("stuID"));
            emp.setStudentID(empID); 
        }
        //grades
         if (qName.equals("grade")){
            grade = new Grade();
            int assignID=  Integer.parseInt(attributes.getValue("assignmentID"));
            grade.setScore(assignID); 
         }
*/


    
    @Override
    public void endDocument() throws SAXException {
        //super.endDocument(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("------------- PARSER FINISHED -------------");
        comp.printCourse();
   
}

    @Override
    public void startDocument() throws SAXException {
        //super.startDocument(); //To change body of generated methods, choose Tools | Templates.
        System.out.println("------------- PARSER STARTED  -------------");
        comp = new Course();

    }
    @Override
    public void fatalError(SAXParseException e) throws SAXException {
      //  super.fatalError(e); //To change body of generated methods, choose Tools | Templates.
      System.out.println("FATAL ERROR");
    }
}
    
    
    
    
    

