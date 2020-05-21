/**
 * @file wordFrequencyTree
 * @description This program calcualates the frequancy and location of the words that is searched in the files which.
 * are user choose before start the program..
 * @assignment Odev 2
 * @date 18/05/2020
 * @author Nazif Enes Kızılcin nazifenes.kizilcin@stu.fsm.edu.
 */
package wordFrequencyTree;

public class Node<T extends Comparable<T>> {

    T data;
    Node<T> rightChild;
    Node<T> leftChild;
    LinkedList frequencyList; // node has a LinkedList which is consist of FrequencyNode

    public Node(T data, String filename) {
        this.data = data;
        rightChild = null;
        leftChild = null;
        FrequencyNode freqNode = new FrequencyNode(filename);
        frequencyList = new LinkedList(freqNode);
    }
    
    
    @Override
    public String toString() {
        return "Data=" + data;
    }

}
