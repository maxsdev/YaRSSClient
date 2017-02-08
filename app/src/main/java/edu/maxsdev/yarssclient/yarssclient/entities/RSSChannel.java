package edu.maxsdev.yarssclient.yarssclient.entities;

/**
 * Created by Max on 08.02.2017.
 *
 */

public class RSSChannel {
    private String title;
    private String link;
    private String description;

    public RSSChannel(String title, String link, String description) {
        this.title = title;
        this.link = link;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
