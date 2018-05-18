/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package gradebooksax;


public class Grade {

    private int assignmentID;
    private int score;

    public Grade() {
        assignmentID=-1;
        score=-1;
    }

    public Grade(int assignmentID, int score) {
        this.assignmentID = assignmentID;
        this.score = score;
    }

    /**
     * @return the assignmentID
     */
    public int getAssignmentID() {
        return assignmentID;
    }

    /**
     * @param assignmentID the assignmentID to set
     */
    public void setAssignmentID(int assignmentID) {
        this.assignmentID = assignmentID;
    }

    /**
     * @return the score
     */
    public int getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(int score) {
        this.score = score;
    }

     @Override
    public String toString() {
     
        return " Assignment=" + assignmentID + ", score " + score;
    }



}
