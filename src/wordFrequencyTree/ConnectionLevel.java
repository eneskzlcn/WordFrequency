/**
 * @file wordFrequencyTree
 * @description This program calcualates the frequancy and location of the words that is searched in the files which.
 * are user choose before start the program..
 * @assignment Odev 2
 * @date 18/05/2020
 * @author Nazif Enes Kızılcin nazifenes.kizilcin@stu.fsm.edu.
 */
package wordFrequencyTree;

public class ConnectionLevel {  // this class is heap.
    FrequencyNode[] heap;
    private int size;
    
    public ConnectionLevel(int capacity) {
        this.heap = new FrequencyNode[capacity*5];//I used merge function and it is merging heaps more than one so need to capacity better
    }
    private int parent(int childIndex) {
        return (childIndex - 1) / 2; //because of parentIndex = 2k+2 for right and 2k+1 for left child
    }
    void insert(FrequencyNode newData) { //classical inserting function of heap
        if (size < heap.length) {
            heap[size] = newData; // if size
            int current = size++;

            while (heap[current].frequency - heap[parent(current)].frequency < 0) {//control as like compareTo for to swap
                swap(current, parent(current));
                current = parent(current);
            }
        } else {
            System.out.println("heap is full !");
        }
    }

    void swap(int childIndex, int parentIndex) { //swap child with parent
        FrequencyNode tempData = heap[childIndex];
        heap[childIndex] = heap[parentIndex];
        heap[parentIndex] = tempData;
    }
    void heapify() { // this is the function that sorts the heap
        int lastIndex = size - 1;

        for (int i = parent(lastIndex); i >= 0; i--) {
            minHeap(i); // this is the recursive sort function.
        }

    }
    private void minHeap(int i) { // this is the recursive sort function that sortes parent and its childs repeatedly
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        int min = i;

        if (left < size && heap[min].frequency >(heap[left].frequency)) {
            min = left;
        }
        if (right < size && heap[min].frequency <(heap[right].frequency)) {
            min = right;
        }
        if (min != i) {
            swap(min, i);
            minHeap(min);
        }
    }
    public void printSorted(){ // I used bubble sort algorithm to start print from great number to low number
        for (int k = 1; k < size; k++) {
            for (int i = 0; i<(size-k);i++) {
                if(heap[i].frequency<heap[i+1].frequency){
                    swap(i,i+1);
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(heap[i].toString());
        }
        heapify(); // turn our heap to old model again. Not sorted
    }

    public int getSize() {
        return size;
    }
    
    public void mergeHeaps(ConnectionLevel connection,int size){//it is for many heaps to merge.
        for (int i = 0; i < size; i++) {
            boolean isInList = false;
            for (int j = 0; j < this.size; j++) {
                if(connection.heap[i].filename.equals(this.heap[j].filename)){
                    this.heap[j].frequency += connection.heap[i].frequency;//If filenames are same just addit frequencies.
                    isInList = true;
                }
            }
            if(!isInList){
                insert(connection.heap[i]);//if file names are not same then it is a new element needed to insert.
            }
        }
    }
}
