package com.company;

import java.io.*;

public class Database {
    private Profile[] men;
    private Profile[] women;
    private Person[] people;

    private Profile[] profiles;

    private Image[] images;


    public Profile[] GetAllProfiles() throws FileNotFoundException {
        String profileFilepath = "C:\\Users\\UWC Samsung 18\\Desktop\\Zaio\\Java\\Webinar Sessions\\TinderClone\\bin\\Profiles.csv";
        String imagesFilepath = "C:\\Users\\UWC Samsung 18\\Desktop\\Zaio\\Java\\Webinar Sessions\\TinderClone\\bin\\ImagesDb.csv";

//        CREATE A BufferedReader THAT WE WILL USE TO READ THE cvc FILE
//        WE WRAP THIS IN A try...catch BLOCK TO HANDLE ERRORS
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(profileFilepath));
            String fileLine = null;
            int counter = 0;

//            THE GetAmountOfLines RETURNS AN integer WHICH WE WILL USER
            people = new Person[GetAmountOfLines() - 1];

//            ON EACH ITERATION, THIS CHECKS TO SEE IF NEXT LINE EXISTS
            while ((fileLine = bufferedReader.readLine()) != null) {

//                SINCE THE FIRST LINE IS THE HEADING..WE HAVE TO SKIP IT
                if(counter > 0) {
//                    SPLIT THE data AT THE "," SO THAT WE HAVE ACCESS TO EACH "CELL"
                    String[] data = fileLine.split(",");

//                    CREATE A NEW INSTANCE OF THE Person CLASS WITH THE INFORMATION FROM THE data ON EACH ITERATION
//                    WE USE trim() TO GET RID OF THE WHITE SPACES AROUND THE TEXT

                    Person person = new Person(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), Integer.parseInt(data[4].trim()));
//                HERE, WE WILL ADD EACH fileLine TO THE profiles list
                    people[counter - 1] = person;
                }

                counter++;
            }

//            ONCE THE people HAVE BEEN CREATED AND ADDED TO THE ARRAY...WE HAVE TO CREATE THE Images
            bufferedReader = new BufferedReader(new FileReader(imagesFilepath));
            fileLine = null;
            counter = 0;

//            THE GetAmountOfLines RETURNS AN integer WHICH WE WILL USER
            images = new Image[GetAmountOfLines() - 1];

//            ON EACH ITERATION, THIS CHECKS TO SEE IF NEXT LINE EXISTS
            while ((fileLine = bufferedReader.readLine()) != null) {

//                SINCE THE FIRST LINE IS THE HEADING..WE HAVE TO SKIP IT
                if(counter > 0) {
//                    SPLIT THE data AT THE "," SO THAT WE HAVE ACCESS TO EACH "CELL"
                    String[] data = fileLine.split(",");

//                    CREATE A NEW INSTANCE OF THE Person CLASS WITH THE INFORMATION FROM THE data ON EACH ITERATION
//                    WE USE trim() TO GET RID OF THE WHITE SPACES AROUND THE TEXT

                    Image image = new Image(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim());
//                HERE, WE WILL ADD EACH fileLine TO THE profiles list
                    images[counter - 1] = image;
                }

                counter++;
            }
//            NOW WE LOOP THROUGH BOTH ARRAYS AND ADD THE person AND image TO THE profile
            profiles = new Profile[GetAmountOfLines() - 1];

            for (int i = 0; i < people.length; i++) {
                Profile profile = new Profile(people[i], images[i]);
                profiles[i] = profile;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return profiles;
    }

    public Profile[] GetProfilesByGender(String gender) throws FileNotFoundException {
        int numberOfMen = 0;
        int numberOfWomen = 0;

        Profile[] toReturn = new Profile[0];

        profiles = GetAllProfiles();

//        SO NOW WE LOOP THROUGH THE profiles ARRAY TO SORT THE DIFFERENT GENDERS
        for(int i = 0; i < profiles.length; i++) {

//          HERE, WE WANNA FIND OUT HOW MANY ITEMS ARE GONNA BE IN EACH ARRAY
            if(profiles[i].getPerson().getGender().substring(0, 1).toUpperCase().equals("M")) {
                numberOfMen++;
            } else if((profiles[i].getPerson().getGender().substring(0, 1).toUpperCase().equals("F"))) {
                numberOfWomen++;
            }
        }

        men = new Profile[numberOfMen];
        women = new Profile[numberOfWomen];
        int menIndex = 0;
        int womenIndex = 0;

        for (int j = 0; j < profiles.length; j++) {
            if(profiles[j].getPerson().getGender().substring(0, 1).toUpperCase().equals("M")) {
                men[menIndex] = profiles[j];
                menIndex++;
            } else if((profiles[j].getPerson().getGender().substring(0, 1).toUpperCase().equals("F"))) {
                women[womenIndex] = profiles[j];
                womenIndex++;
            }
        }

        if(gender.substring(0, 1).toUpperCase().equals("M")) {
            toReturn = men;
        } else if(gender.substring(0, 1).toUpperCase().equals("F")){
            toReturn = women;
        }

        return toReturn;
    }

    public void AddToRightSwipes(Profile profile) {
        String filepath = "C:\\Users\\UWC Samsung 18\\Desktop\\Zaio\\Java\\Webinar Sessions\\TinderClone\\bin\\rightSwipes.csv";

        try {
//            MAKE A NEW INSTANCE OF THE FileWriter SO WE CAN WRITE TO FILES
//            true MEANS THAT WE WILL APPEND DATA TO THE FILE INSTEAD OF DELETING WHATS ON THEN REWRITING
            FileWriter fileWriter = new FileWriter(filepath, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

//            THIS LETS US USE FUNCTIONS LIKE println....
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println(profile.getPerson().getName() + ", " + profile.getPerson().getGender() + ", " + profile.getPerson().getBio() + ", " + profile.getPerson().getLocation() + ", " + profile.getPerson().getAge() + "," + profile.getImage());

//            MAKES SURE THAT ALL THE DATA IS ADDED TO THE FILE
            printWriter.flush();

//            CLOSES THE FILE STREAM
            printWriter.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public int GetAmountOfLines() {
        String filepath = "C:\\Users\\UWC Samsung 18\\Desktop\\Zaio\\Java\\Webinar Sessions\\TinderClone\\bin\\Database.csv";

        int amountOfLines = 0;

//        CREATE A BufferedReader THAT WE WILL USE TO READ THE cvc FILE
//        WE WRAP THIS IN A try...catch BLOCK TO HANDLE ERRORS
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath));
            String fileLine = null;

//            ON EACH ITERATION, THIS CHECKS TO SEE IF NEXT LINE EXISTS
            while ((fileLine = bufferedReader.readLine()) != null) {
                amountOfLines++;
            }

            bufferedReader.close();
        }
//        CATCH THE ERROR IF THE FILE DOESN'T EXIST
        catch(FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        AT THE END, i WILL CONTAIN THE AMOUNT OF LINES IN THE FILE
        return amountOfLines;
    }
}
