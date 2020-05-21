/**
 * @file wordFrequencyTree
 * @description This program calcualates the frequancy and location of the words that is searched in the files which.
 * are user choose before start the program..
 * @assignment Odev 2
 * @date 18/05/2020
 * @author Nazif Enes Kızılcin nazifenes.kizilcin@stu.fsm.edu.
 */
package wordFrequencyTree;

public class LinkedList {

    FrequencyNode head;
    int size;

    public LinkedList(FrequencyNode node) {
        head = node;
        size = 1;
    }

    public LinkedList() {
        head = null;
        size = 0;
    }

    public void addLast(FrequencyNode node) {
        if (isEmpty()) {
            head = node;
            size++;
        } else {
            if (isInList(node)) {
                    //the function isInlist() provides temp.frequency++; So nothing need to do
            } else {
                FrequencyNode temp = head;
                while (temp.nextNode != null) {
                    temp = temp.nextNode;
                }
                temp.nextNode = node; //Adding new node to the last
                size++;
            }
        }
    }

    public boolean isInList(FrequencyNode node) {//Controls if the node has same filename is in this list.
        boolean isInList = false;               //If it is -->> frequency++
        if (isEmpty()) {
            return false;
        } else {
            FrequencyNode temp = head;
            while (temp != null) {
                if (temp.filename.equals(node.filename)) {
                    isInList = true;
                    temp.frequency++;
                }
                temp = temp.nextNode;
            }
        }

        return isInList;
    }

    public ConnectionLevel convert() { // this function creates heap from this List.
        ConnectionLevel con = new ConnectionLevel(size);
        if (isEmpty()) {
            return null;
        }
        FrequencyNode temp = head;
        while (temp != null) {
            con.insert(temp); // inserting all the things is list to heap
            temp = temp.nextNode;
        }
        con.heapify();
        return con;
    }

    public boolean isEmpty() {
        return head == null;
    }
}
