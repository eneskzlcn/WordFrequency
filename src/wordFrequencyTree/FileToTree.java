/**
 * @file wordFrequencyTree
 * @description This program calcualates the frequancy and location of the words that is searched in the files which.
 * are user choose before start the program..
 * @assignment Odev 2
 * @date 18/05/2020
 * @author Nazif Enes Kızılcin nazifenes.kizilcin@stu.fsm.edu.
 */
package wordFrequencyTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFileChooser;

public class FileToTree {

    String path = "None";
    File[] fileName = new File[0];
    boolean exit = false;

    public boolean fillTreeFromFile(WordFrequencyTree<String> bst) {
        chooseFile();
        if (fileName.length != 0) {
            String cleaned_word;
            try {
                for (File file : fileName) {
                    File f = new File(file.getAbsolutePath());
                    if (f.isFile() && f.canRead() && (f.getFreeSpace() != f.getTotalSpace())) {//The file we choose,neet to be readable,not empty and neet to be a file.
                        Scanner scan = new Scanner(f);
                        while (scan.hasNext()) {
                            cleaned_word = scan.next().replaceAll("\\p{Punct}", "").toLowerCase();
                            bst.insert(cleaned_word, f.getName());//inserting withou punctuations and without uppercase latters
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("There is a fail when opening file.");
            }

        } else {
            if (!exit) {
                fillTreeFromFile(bst); //never ends if user do not exit or choose because the program needs to take
            } else {                        //the informations from words before start other thing.
                return false;
            }
        }
        return true;
    }

    public void chooseFile() { //When you choose a file from jFileChooser
        boolean notChosen = true;
        while (notChosen) { //this loops provides user to choose file again and again
            JFileChooser jf = new JFileChooser();
            jf.setVisible(true);
            jf.showOpenDialog(null);
            try {
                File f = new File(jf.getSelectedFile().getParent()); //in File choose you can not choose directory
                fileName = f.listFiles();                         //so I take the directory path here and then take the
                notChosen = false;                                //paths of alll files in this directory
            } catch (Exception e) {
                notChosen = false;
                exit = true;
            }
        }

    }
}
