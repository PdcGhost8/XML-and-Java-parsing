/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebookdom;

import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;

public class GradebookParser 
{
    private Document doc;
    
    public String getNodeValue(Node n)
    {
                //get textnode      //get value of text node
       return n.getFirstChild().getNodeValue();
    }
    
    public Course getCourse(){
       Course comp = new Course();
       
       //couse name
       Element root = doc.getDocumentElement();
       //use getAttribute
       String courseName = root.getAttribute("courseName");
       comp.setCourseName(courseName);
        //assignments
        Node assignments =root.getFirstChild();
        NodeList n=assignments.getChildNodes();
        for(int i=0; i<n.getLength();i++)
        {
        
           Node assignment =n.item(i);
           
           //assignmentID
           Element assignmentElement = (Element)assignment;
           String AssignmentID =assignmentElement.getAttribute("assignmentID");
           int AssignmentIdIint = Integer.parseInt(AssignmentID);
           
           //description
           String description = getNodeValue(assignment.getChildNodes().item(0));
           //maxscore
           String MaxScoreString = getNodeValue(assignment.getChildNodes().item(1));    
            int maxScoreInt =Integer.parseInt(MaxScoreString);
         
         
           comp.addAssignment(AssignmentIdIint, description, maxScoreInt);
        }
        
        //students
        Node students =root.getLastChild();
        NodeList m=students.getChildNodes();
         for(int i=0; i<m.getLength();i++)
        {
         Node student =m.item(i);
     //STU ID and student
         
           Element stuIdElement= (Element)student;// casting
           String studID=stuIdElement.getAttribute("stuID");
           int stuIDInt= Integer.parseInt(studID);  
           
      //fname
      //lname
           String fname = getNodeValue(student.getChildNodes().item(1));
           String lname = getNodeValue(student.getChildNodes().item(2)); 
         //  String grades =getNodeValue(student.getChildNodes().item(2));
                   
        
       //grade //assi
        //slecting students children
       Node grades =student.getLastChild(); // get grades from students
       Node grade =grades.getFirstChild(); //get grade from grade
       NodeList b=grade.getChildNodes(); //
      
           //assignment Id
           Element GradeAssignment= (Element)grade;// casting
           String AssignmentIDSTU=GradeAssignment.getAttribute("assignmentID");
           int assignID= Integer.parseInt(AssignmentIDSTU);  
           
           //Score
           String scoreString = getNodeValue(grade.getChildNodes().item(0));    
           int scoreInt= Integer.parseInt(scoreString);
           
       
            comp.addStudent (stuIDInt, fname, lname, assignID, scoreInt);
      // }
            
           //  int average=scoreInt + 5;
        
        }
       
      return comp;
    }
    
    public void parseXML(String filename){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            
            Document dom = db.parse(filename);
            doc = dom;
            
            System.out.println("XML PARSED");
            
        } catch (Exception e) {
            System.out.println(e.toString());
        }    
    }
    
    public void removeWhitespace(){
        DocumentTraversal traversal = (DocumentTraversal) doc;
        TreeWalker tw = traversal.createTreeWalker(doc.getDocumentElement(), NodeFilter.SHOW_TEXT, null, true);
        
        Node n = tw.nextNode();
        
        while (n != null){
            String value = n.getNodeValue();
            
            Node next = tw.nextNode();
            
            if (value.trim().length() ==0){
                n.getParentNode().removeChild(n);    
            }
            
            n = next;   
        }   
    }
    
}
