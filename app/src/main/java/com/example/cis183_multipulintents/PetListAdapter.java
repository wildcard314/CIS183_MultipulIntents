package com.example.cis183_multipulintents;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PetListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<Pet> listOfPets;
    public PetListAdapter(Context c, ArrayList<Pet> ls)
    {
        context = c;
        listOfPets = ls;
    }

    @Override
    public int getCount()
    {
        return listOfPets.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listOfPets.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent)
    {
        if(view == null)
        {
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(MainActivity.LAYOUT_INFLATER_SERVICE);
            view = mInflator.inflate(R.layout.pet_cell, null);
        }

        //find gui in the cell

        TextView petName = view.findViewById(R.id.tv_v_cell_Name);
        TextView petAge = view.findViewById(R.id.tv_v_cell_age);
        TextView petType = view.findViewById(R.id.tv_v_cell_type);

        //get data for this pet ffrom listofpets
        //we can accsess different elements based off of the pos value
        Pet pet = listOfPets.get(position);

        //set the gui
        petName.setText(pet.getName());
        petAge.setText(Integer.toString(pet.getAge()));
        petType.setText(pet.getSpecies());

        return view;
    }
}
