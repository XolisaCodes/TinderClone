package com.company;

public class Image {
    private String tags;
    private String description;
    private String title;
    private String url;

    public Image(String tags, String description, String title, String url) {
        this.tags = tags;
        this.description = description;
        this.title = title;
        this.url = url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public String getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "Image{" +
                "tags='" + tags + '\'' +
                ", description='" + description + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
