/**
 * @file wordFrequencyTree
 * @description This program calcualates the frequancy and location of the words that is searched in the files which.
 * are user choose before start the program..
 * @assignment Odev 2
 * @date 18/05/2020
 * @author Nazif Enes Kızılcin nazifenes.kizilcin@stu.fsm.edu.
 */
package wordFrequencyTree;

public class FrequencyNode { // the nodes are keeping the file names and frequencies of Node(the words readed)

    int frequency;
    String filename;
    FrequencyNode nextNode;

    public FrequencyNode(String filename) {
        this.filename = filename;
        frequency = 1;
    }
    
    @Override
    public String toString() {
        return "Filename = "+filename+ "\nFrequency= "+frequency+"\n";
    }
    
}
