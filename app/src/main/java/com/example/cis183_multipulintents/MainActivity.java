package com.example.cis183_multipulintents;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //global vars
    static private ArrayList<Pet> listOfPets = new ArrayList<>();

    //this will be used for testing only ------
    //just to show how listviews work with arrays
    String[] test = {"Hello", "hi", "Hola"};

    ListView lv_j_ListOfPets;
    PetListAdapter plAdapter;

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

        lv_j_ListOfPets = findViewById(R.id.lv_v_listOfPets);

        //we need an adapter to use with the list view
        //if the cells require more then one string being displayed
        //a different color or a different color test you must create your own
        //ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, test);

        //lv_j_ListOfPets.setAdapter(adapter);

        // i need a list to store all pets for the vet clinic

        Pet pet = new Pet();
        pet.setName("Tito");
        pet.setAge(12);
        pet.setSpecies("Dog");

        listOfPets.add(pet);
        Pet anotherpet = new Pet("Willow",5,"Dog");
        listOfPets.add(anotherpet);

        addDummyDataToArrayList();
        displayAllPetData();
        fillListView();

        //Log.d("Pet Data:", pet.getName() + " is a " + pet.getSpecies() + " and is " + pet.getAge() + " Years old.");


    }
    //------------------------------------ listeners and functions ------------------------------------

    private void addDummyDataToArrayList()
    {
        //create a new pet obj, fill in all pet info, add pet to array list
        Pet newPet = new Pet("Athena",6,Pet.PetType.petAt(0));
        listOfPets.add(newPet);
        newPet = new Pet("Meow",3,Pet.PetType.petAt(0));
        listOfPets.add(newPet);
        newPet = new Pet("Whiskers", 9, Pet.PetType.petAt(1));
        listOfPets.add(newPet);
    }

    private void displayAllPetData()
    {
        for(int i = 0; i < listOfPets.size(); i++)
        {
            Log.d("pet info :", listOfPets.get(i).getName());
        }
    }

    private void fillListView()
    {
        plAdapter = new PetListAdapter(this, listOfPets);
        lv_j_ListOfPets.setAdapter(plAdapter);
    }



}