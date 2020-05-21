/**
 * @file wordFrequencyTree
 * @description This program calcualates the frequancy and location of the words that is searched in the files which.
 * are user choose before start the program..
 * @assignment Odev 2
 * @date 18/05/2020
 * @author Nazif Enes Kızılcin nazifenes.kizilcin@stu.fsm.edu.
 */
package wordFrequencyTree;

public class WordFrequencyTree<T extends Comparable<T>> {

    public Node<T> root;
    int size = 0;

    void insert(T newData, String filename) {
        Node<T> newNode = new Node<>(newData, filename);
        if (isEmpty()) {
            root = newNode;
            size++;
        } else {
            Node<T> temp = root;
            while (temp != null) {
                if (newData.compareTo(temp.data) > 0) {
                    if (temp.rightChild == null) {
                        temp.rightChild = newNode;
                        size++;
                        return;
                    }
                    temp = temp.rightChild;
                } else if (newData.compareTo(temp.data) < 0) {
                    if (temp.leftChild == null) {
                        temp.leftChild = newNode;
                        size++;
                        return;
                    }
                    temp = temp.leftChild;
                } else if (newData.compareTo(temp.data) == 0) {
                    temp.frequencyList.addLast(new FrequencyNode(filename));
                    size++;
                    return;
                }
            }
        }
    }
    public Node<T> search(String searchData){
        searchData = searchData.replaceAll("\\p{Punct}", "").toLowerCase();//Strings becomes
        if(isEmpty()){
            System.out.println("There is nothing to search");
        }
        else{
            Node<T> temp = root;
            while(temp!= null){
                if(searchData.compareTo((String)temp.data)>0){
                    temp = temp.rightChild;
                }
                else if(searchData.compareTo((String)temp.data)<0){
                    temp = temp.leftChild;
                }
                else{
                    return temp;
                }
            }   
        }
        return null;
    }
    public void searchConnection(String wordsToSearch){
        String[] words = wordsToSearch.split(" "); // to get words fixed before control
        for (String word : words) {
            word = word.replaceAll("\\p{Punct}", "").toLowerCase();
        }
        ConnectionLevel[] connectionLevels = new ConnectionLevel[words.length];//an array to take all heaps
        
        for (int i =0;i< words.length;i++) {
            if(search(words[i])!= null){
                connectionLevels[i] = search(words[i]).frequencyList.convert();// ı converted linkedList to heap;
            }           
        }
        for (int i = 1; i < connectionLevels.length; i++) {
            connectionLevels[0].mergeHeaps(connectionLevels[i], connectionLevels[i].getSize());//ı merged all con.levels in[0]
        }
        if(connectionLevels[0] == null){
            System.out.println("The word could not found");
        }
        else{
           connectionLevels[0].printSorted(); //printing from greater to lower number... All heap is in [0] now..
        }
        
    }
    private boolean isEmpty() {
        return root == null;
    }
}
