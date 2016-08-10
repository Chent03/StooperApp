package com.cs6392016.gbergy.stooperapp;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class Boroughs extends Fragment implements View.OnClickListener {
    Spinner spinner4;
    Button next;
    ArrayAdapter<CharSequence> adapter4;


    public Boroughs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v =  inflater.inflate(R.layout.fragment_boroughs, container, false);
        spinner4 = (Spinner)v.findViewById(R.id.spinner4);
        adapter4 = ArrayAdapter.createFromResource(getActivity(), R.array.borough, android.R.layout.simple_spinner_item);
        adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter4);

        next = (Button)v.findViewById(R.id.next);
        next.setOnClickListener(this);





        return v;
    }

    @Override
    public void onClick(View v) { selectBorough();}


    public void selectBorough(){
        String selected = spinner4.getSelectedItem().toString();
        Createlisting createlisting = new Createlisting();
        FragmentManager fragmentManager =  getFragmentManager();
        android.support.v4.app.FragmentTransaction ft = fragmentManager.beginTransaction();
        Bundle args = new Bundle();
        args.putString("Borough", selected);
        createlisting.setArguments(args);
        ft.replace(R.id.defaultinnerfrag, createlisting);
        ft.commit();

    }
}
