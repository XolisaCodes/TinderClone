package com.company;

public class Profile {
//      A PROFILE HAS TO CONTAIN A PERSON AND AN IMAGE
    private Person person;
    private Image image;

    public Profile(Person person, Image image) {
        this.person = person;
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public Person getPerson() {
        return person;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
