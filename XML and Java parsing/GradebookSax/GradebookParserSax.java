/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gradebooksax;

import javax.xml.parsers.*;
import java.io.File;
import org.w3c.dom.Node;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.TreeWalker;

import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
/**
 *
 * @author pdc49_000
 */
public class GradebookParserSax {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
     
    public Course  parseXML(String filename){ // course retrun type or void
        
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            
            GradebookSaxHandler handler = new  GradebookSaxHandler();
            
            sp.parse(new File(filename), handler);
            // System.out.println("XML PARSED");
            
            return handler.getCourse();
        } catch (Exception e) {
          
             e.printStackTrace();
        }
        return null;
    }
    
}
