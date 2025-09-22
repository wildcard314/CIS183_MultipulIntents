package com.example.cis183_multipulintents;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //global vars
    static private ArrayList<Pet> listOfPets = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        // i need a list to store all pets for the vet clinic

        Pet pet = new Pet();
        pet.setName("Tito");
        pet.setAge(12);
        pet.setSpecies("Dog");

        Log.d("Pet Data:", pet.getName() + " is a " + pet.getSpecies() + " and is " + pet.getAge() + " Years old.");


    }
    //------------------------------------ listeners and functions ------------------------------------

    private void addDummyDataToArrayList()
    {
        //create a new pet obj, fill in all pet info, add pet to array list
        Pet newPet = new Pet("Athena",6,Pet.PetType.petAt(0));
        listOfPets.add(newPet);
        newPet = new Pet("Willow",3,Pet.PetType.petAt(0));
        listOfPets.add(newPet);
        newPet = new Pet("Whiskers", 9, Pet.PetType.petAt(1));
        listOfPets.add(newPet);
    }



}