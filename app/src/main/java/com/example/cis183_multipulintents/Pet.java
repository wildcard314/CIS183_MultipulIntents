package com.example.cis183_multipulintents;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Pet
{
    // a pet is comprised of the following
    // name, age and species
    private String name;
    private int age;
    private String species;

    public Pet()
    {
        //default constructor
        //is called when we make a new obj
    }

    public Pet(String n, int a, String s)
    {
        name = n;
        age = a;
        species = s;
    }



    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getSpecies()
    {
        return species;
    }

    public void setSpecies(String species)
    {
        this.species = species;
    }
    static class PetType
    {
        static ArrayList<String> petSpecies = new ArrayList<>(Arrays.asList("Dog","Cat","Snake","Chicken","Hampster"));

        public static String petAt(int i)
        {
            return petSpecies.get(i);
        }

        public static ArrayList<String> getAllPetTypes()
        {
            return petSpecies;
        }

        public static void addPet(String t)
        {
            petSpecies.add(t);
        }


    }

}
