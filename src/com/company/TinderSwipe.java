package com.company;

public class TinderSwipe {


    public void SwipeLeft(int index, Profile[] profiles) {
        ShowNext(index, profiles);
    }

    public void SwipeRight(int index, Profile[] profiles) {
        Profile profile = ShowNext(index, profiles);

        Database db = new Database();
        db.AddToRightSwipes(profile);
    }

    public Profile ShowNext(int index, Profile[] profiles) {
        if(index == profiles.length) {
            index = 0;
        }


        String name = profiles[index].getPerson().getName();
        String bio = profiles[index].getPerson().getBio();
        String gender = profiles[index].getPerson().getGender();
        String location = profiles[index].getPerson().getLocation();

        int age = profiles[index].getPerson().getAge();

        System.out.println("my name is: " + name + ". My hobies are " + bio + ". I'm a " + age + " year old " + gender + ". I live around " + location);

        return profiles[index];
    }
}
