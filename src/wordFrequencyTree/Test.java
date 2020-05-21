/**
 * @file wordFrequencyTree
 * @description This program calcualates the frequancy and location of the words that is searched in the files which.
 * are user choose before start the program..
 * @assignment Odev 2
 * @date 18/05/2020
 * @author Nazif Enes Kızılcin nazifenes.kizilcin@stu.fsm.edu.
 */
package wordFrequencyTree;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        WordFrequencyTree<String> bst = new WordFrequencyTree();
        FileToTree ftt = new FileToTree(); //The class that helps to file operations. Read Words To Tree from file
        if (!ftt.fillTreeFromFile(bst)) {//if the tree will be null after read from file the function returns false..   
            return;
   
            }
            //USİNG OF QUERY
              String searchData = "data";
              System.out.println("'data' Results \n");
              bst.searchConnection(searchData);
            
              //QUERY WİTH INPUTS
//             Scanner scan = new Scanner(System.in);
//             String searchData = scan.next();
//             bst.searchConnection(searchData);
//             
            
        }
     

    }


