package baseline;

public class Guide {
    private String title;
    private String localHtml;

    Guide(String title, String localHtml) {
        this.title = title;
        this.localHtml = localHtml;
    }

    public String getTitle() {
        return title;
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
