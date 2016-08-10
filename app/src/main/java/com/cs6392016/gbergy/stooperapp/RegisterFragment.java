package com.cs6392016.gbergy.stooperapp;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * A placeholder fragment containing a simple view.
 */
public class RegisterFragment extends Fragment {

    public RegisterFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_register, container, false);

        final EditText etfirst = (EditText) v.findViewById(R.id.first);
        final EditText etlast = (EditText) v.findViewById(R.id.last);
        final EditText etusername = (EditText) v.findViewById(R.id.usersign);
        final EditText etpass = (EditText) v.findViewById(R.id.passsignup);
        final EditText etemail = (EditText) v.findViewById(R.id.email);
        final Button regbtn = (Button) v.findViewById(R.id.fnlregister);

        regbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String first = etfirst.getText().toString();
                final String last = etlast.getText().toString();
                final String username = etusername.getText().toString();
                final String password = etpass.getText().toString();
                final String email = etemail.getText().toString();

                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                startActivity(new Intent(getActivity(), DrawerActivity.class));
                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                                builder.setMessage("Account with that username already exist. Please try again.")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(first, last, username, password, email, responseListener);
                RequestQueue queue = Volley.newRequestQueue(getActivity());
                queue.add(registerRequest);
            }
        });
        return v;
    }

}
