/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private File path;
    private List<Item> list;

    FileHandler(File path) {
        this.path = path;
    }

    FileHandler(File path, List<Item> list) {
        this.path = path;
        this.list = list;
    }

    FileHandler() {
    }

    public List<Item> fileImport() {
        List<Item> importList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line = reader.readLine();
            while(line != null) {
                String[] info = line.split("§§");

                Item item = new Item(info[0]);
                if(!info[1].equals("null"))
                    item.setDueDate(info[1]);
                item.setCompleted(Boolean.parseBoolean(info[2]));

                importList.add(item);
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return importList;
    }

    public String fileExport() {
        StringBuilder output = new StringBuilder();
        try (FileWriter writer = new FileWriter(path)) {
            for (Item item : list) {

                if (item != list.get(0)) {
                    output.append(String.format("%n"));
                }

                output.append(item.getDescription()).append("§§");
                output.append(item.getDueDate()).append("§§");
                output.append(item.getCompletedValue());
            }
            writer.write(String.valueOf(output));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return String.valueOf(output);
    }

    public void setList(List<Item> items) {
        list = items;
    }

    public void setPath(File path) {
        this.path = path;
    }
}