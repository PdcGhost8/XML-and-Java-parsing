/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebooksax;

/**
 *
 * @author pdc49_000
 */
public class GradebookSAX {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        GradebookParserSax parser = new GradebookParserSax();
        
     
        Course comp = parser.parseXML("gradebookXML.xml");
        comp.printCourse();
        
        
        
    
    }
    
}
