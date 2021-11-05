/*
 *  UCF COP3330 Fall 2021 Application Assignment 1 Solution
 *  Copyright 2021 Zander Preston
 */

package baseline;

public class Guide {
    private String title;
    private String localHtml;

    Guide(String title, String localHtml) {
        this.title = title;
        this.localHtml = localHtml;
    }

    public String getLocalHtml() {
        return localHtml;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setLocalHtml(String localHtml) {
        this.localHtml = localHtml;
    }

    @Override
    public String toString() {
        return title;
    }
}
