/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gradebookdom;

public class Assignment {

    private int id;
    private String description;
    private int maxScore;

    public Assignment() {
        id=-1;
        description="";
        maxScore=-1;
    }

    public Assignment(int id, String description, int maxScore) {
        this.id = id;
        this.description = description;
        this.maxScore = maxScore;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the maxScore
     */
    public int getMaxScore() {
        return maxScore;
    }

    /**
     * @param maxScore the maxScore to set
     */
    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

  
         @Override
    public String toString() {
        return "Assignment{" + "Assignment=" + id + ", description=" + description + ", Maxscore=" + maxScore + '}';
      
    }
      // return id; 
     
      //return maxScore;
    



}
