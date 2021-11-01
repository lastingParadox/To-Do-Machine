/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.io.File;
import java.util.List;

public class FileHandler {

    //private File path
    //private List of items list

    FileHandler(File path) {
        //this path = path
    }

    FileHandler(File path, List<Item> list) {
        //this path = path
        //this list = list
    }

    FileHandler() {
    }

    public List<Item> fileImport() {
        //List of items importList = new ArrayList
        //Try to create a BufferedReader "reader" to read through the file provided
            //String line = ""

            //While line is not null:
                //line = reader.readLine()
                //Array of strings "info" = line.split(line) with delimiter "§§".
                //New Item "item" = Item with constructors info[0], info[1], Boolean.parseBoolean(info[2])
                //Add item to importList
                //line = reader.readLine()

        //return importList
        return null;
    }

    public String fileExport() {
        //StringBuilder output = new StringBuilder
        //Try to create a FileWriter "writer" to write to the file provided
            //For each Item in list:
                //Append "'item.getDescription()'§§" to output
                //Append "'item.getDueDate()'§§" to output
                //Append "'item.getCompletedValue'" to output
                //Append new line to output
            //Write output to the file
        //return String.valueOf(Output)
        return null;
    }

    public void setList(List<Item> items) {
        //this list = list
    }

    public void setPath(File path) {
        //this path = path
    }
}