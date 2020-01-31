package com.example.coen390_assignment1;

public class Profile {

    protected String name;
    protected String age;
    protected String id;

    public Profile(String name,String age, String id)
    {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static boolean checkValidInput(Profile profile)
    {
        if (profile.getName().equals(""))                   //Profile name should not be empty
            return false;
        else if (profile.getName() == null)
            return false;
        else if (Integer.parseInt(profile.getAge()) < 18)   //Profile age should be greater than or equal to 18
            return false;
        else if (Integer.parseInt(profile.getAge()) > 99)   //Profile age should be less than or equal to 99
            return false;
        else
            return true;
    }
}
