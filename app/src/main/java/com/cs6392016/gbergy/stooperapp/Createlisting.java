package com.cs6392016.gbergy.stooperapp;


import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.client.Firebase;
import com.google.android.gms.vision.barcode.Barcode;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;


/**
 * A simple {@link Fragment} subclass.
 */
public class Createlisting extends Fragment implements View.OnClickListener{
    private static final String FIREBASE_URL = "https://stooperapp.firebaseio.com/";
    private Firebase firebaseRef;
    Spinner spinner, spinner2;
    String Borough;
    ArrayAdapter<CharSequence> adapter, adapter2;

    public Createlisting() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v =  inflater.inflate(R.layout.fragment_create_listing, container, false);
        Borough = getArguments().getString("Borough");
        Firebase.setAndroidContext(getActivity());
        firebaseRef = new Firebase(FIREBASE_URL);

        spinner = (Spinner)v.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(getActivity(),R.array.Categories, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner2 =(Spinner)v.findViewById(R.id.spinner2);
        adapter2 =ArrayAdapter.createFromResource(getActivity(),R.array.Conditions, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter2);

        Button Submit = (Button)v.findViewById(R.id.subbtn);

        Submit.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        try {
            sendItem();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendItem() throws IOException{

        EditText edTitle = (EditText)getActivity().findViewById(R.id.edtitle);
        Spinner edCategory =(Spinner) getActivity().findViewById(R.id.spinner);
        Spinner edCondition = (Spinner) getActivity().findViewById(R.id.spinner2);
        EditText edStreet = (EditText)getActivity().findViewById(R.id.edstreet);
        EditText edCity = (EditText)getActivity().findViewById(R.id.edcity);

        String sTitle = edTitle.getText().toString();
        String sCategory = edCategory.getSelectedItem().toString();
        String sCondition = edCondition.getSelectedItem().toString();
        String sStreet = edStreet.getText().toString();
        String sCity = edCity.getText().toString();


        if(!sTitle.equals("") && !sCategory.equals("") && !sCondition.equals("") && !sStreet.equals("") && !sCity.equals("")){
            Geocoder geocoder = new Geocoder(getContext());
            List<Address> list = geocoder.getFromLocationName(sStreet+", " + sCity,1);
            Address add = list.get(0);

            double lat = add.getLatitude();
            double lng = add.getLongitude();

            location loc = new location(sTitle, sStreet, lat, lng);
            Item listing = new Item(sTitle, sCategory, sCondition, sStreet, sCity);
            firebaseRef.child("Items").child(Borough).child(sCategory).push().setValue(listing);
            firebaseRef.child("Location").push().setValue(loc);
            edTitle.setText("");
            edStreet.setText("");
            edCity.setText("");
        }
    }

}
