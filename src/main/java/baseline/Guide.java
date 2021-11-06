/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

public class Guide {
    private final String title;
    private final String localHtml;

    Guide(String title, String localHtml) {
        this.title = title;
        this.localHtml = localHtml;
    }

    public String getLocalHtml() {
        return localHtml;
    }

    @Override
    public String toString() {
        return title;
    }
}
