package com.cs6392016.gbergy.stooperapp;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class Findlisting extends Fragment implements View.OnClickListener{
    Spinner spinner3, spinner5;
    Button search;

    ArrayAdapter<CharSequence> adapter3, adapter4;


    public Findlisting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_request_listing, container, false);

        spinner3 = (Spinner)v.findViewById(R.id.spinner3);
        adapter3 = ArrayAdapter.createFromResource(getActivity(), R.array.Categories, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter3);

        spinner5 = (Spinner)v.findViewById(R.id.spinner5);
        adapter4 = ArrayAdapter.createFromResource(getActivity(), R.array.borough, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter4);

        search = (Button)v.findViewById(R.id.searchbtn);

        search.setOnClickListener(this);


        return v;

    }

    @Override
    public void onClick(View v) {
        searchItem();
    }

    public void searchItem(){
        String selected = spinner3.getSelectedItem().toString();
        String city = spinner5.getSelectedItem().toString();
        listings search = new listings();
        FragmentManager fragmentManager = getFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
        Bundle args = new Bundle();
        args.putString("Category", selected);
        args.putString("City", city);
        search.setArguments(args);
        ft.replace(R.id.defaultinnerfrag, search);
        ft.commit();
    }
}
