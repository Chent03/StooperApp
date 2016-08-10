package com.cs6392016.gbergy.stooperapp;


import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.URL;


/**
 * A simple {@link Fragment} subclass.
 */
public class ContactUs extends Fragment {
    Intent intent;


    public ContactUs() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v = inflater.inflate(R.layout.fragment_contact_us, container, false);

        final Button greg = (Button)v.findViewById(R.id.gregbtn);
        greg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:411"));
                startActivity(intent);
            }
        });
        final Button tony = (Button)v.findViewById(R.id.tonybtn);
        tony.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:6465731388"));
                startActivity(intent);
            }
        });
        final Button jones = (Button)v.findViewById(R.id.jonesbtn);
        jones.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:6468316127"));
                startActivity(intent);
            }
        });

        Button gregpic = (Button)v.findViewById(R.id.gregpic);
        gregpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://avatars1.githubusercontent.com/u/793562?v=3&s=400";
                new MyAsyncTask().execute(url);
            }
        });

        Button tonypic = (Button)v.findViewById(R.id.tonypic);
        tonypic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://avatars2.githubusercontent.com/u/19677158?v=3&s=400";
                new MyAsyncTask().execute(url);
            }
        });

        Button jonespic = (Button)v.findViewById(R.id.jonespic);
        jonespic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://avatars1.githubusercontent.com/u/19679737?v=3&s=400";
                new MyAsyncTask().execute(url);
            }
        });


        return v;

    }
    public class MyAsyncTask extends AsyncTask<String, Void, Bitmap> {
        @Override
        protected Bitmap doInBackground(String... params) {
            Bitmap bmap = null;
            try {
                bmap = BitmapFactory.decodeStream((InputStream) new URL(params[0]).getContent());
            } catch (Exception e) {
                Log.e("error", e.getMessage());
            }
            return bmap;
        }

        @Override
        protected void onPostExecute(Bitmap bitmap) {
            ImageView image = (ImageView) getActivity().findViewById(R.id.gregview);

            if (image != null) {
                image.setImageBitmap(bitmap);
            }
        }
    }


}
