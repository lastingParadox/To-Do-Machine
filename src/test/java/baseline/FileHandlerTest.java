/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    FileHandler test = new FileHandler();

    @Test
    void fileImportTest() {
        test.setPath(new File("./testFile/test_fileInput.txt"));

        List<Item> expectedList = new ArrayList<>();
        expectedList.add(new Item("Start Test", "2020-10-31"));
        expectedList.add(new Item("Complete Test", "2021-10-31"));

        List<Item> actualList = test.fileImport();

        String expected = expectedList.get(0).getDescription() + expectedList.get(1).getDescription();
        String actual = actualList.get(0).getDescription() + actualList.get(1).getDescription();

        assertEquals(expected, actual);
    }

    @Test
    void fileExportTest() {
        test.setPath(new File("./testFile/test_fileOutput.txt"));

        List<Item> exportItems = new ArrayList<>();
        exportItems.add(new Item("Start Test", "2020-10-31"));
        exportItems.add(new Item("Complete Test", "2021-10-31"));
        test.setList(exportItems);

        String expected = String.format("%s§§%s§§%b%n%s§§%s§§%b", "Start Test", "2020-10-31", false,
                "Complete Test", "2021-10-31", false);
        String actual = test.fileExport();

        assertEquals(expected, actual);
    }

}