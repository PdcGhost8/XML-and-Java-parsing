/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebookdom;

/**
 *
 * @author pdc49_000
 */
public class GradebookDOM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       // GradebookParser parser = new GradebookParser();
       GradebookParser parser = new GradebookParser();
        parser.parseXML("gradebookXML.xml");
        parser.removeWhitespace();
        
        Course comp = parser.getCourse();
        comp.printCourse();
        
    }
    
}
