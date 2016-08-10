package com.cs6392016.gbergy.stooperapp;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class listings extends Fragment implements GoogleApiClient.OnConnectionFailedListener{

    public static class RoomViewHolder extends RecyclerView.ViewHolder{
        public TextView itemTitle;
        public TextView itemCondition;
        public TextView itemStreet;

        public RoomViewHolder(View v){
            super(v);
            itemTitle = (TextView)itemView.findViewById(R.id.titles);
            itemCondition = (TextView)itemView.findViewById(R.id.conditions);
            itemStreet = (TextView)itemView.findViewById(R.id.streets);
        }
    }

    public static final String ITEMS = "Items";
    private static final String TAG = "MainActivity";
    private RecyclerView mRoomRecyclerView;
    private LinearLayoutManager mLinearLayoutManager;
    private DatabaseReference mFirebaseDatabaseReference;
    private FirebaseRecyclerAdapter<Item, RoomViewHolder> mFirebaseAdapter;



    public listings() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View v =  inflater.inflate(R.layout.fragment_listings, container, false);
        String data = getArguments().getString("Category");
        String city = getArguments().getString("City");

        mRoomRecyclerView = (RecyclerView)v.findViewById(R.id.roomRecyclerView);
        mLinearLayoutManager = new LinearLayoutManager(getContext());
        mLinearLayoutManager.setStackFromEnd(true);

        mFirebaseDatabaseReference = FirebaseDatabase.getInstance().getReference();
        mFirebaseAdapter = new FirebaseRecyclerAdapter<Item, RoomViewHolder>(
                Item.class,
                R.layout.listviewitems,
                RoomViewHolder.class,
                mFirebaseDatabaseReference.child(ITEMS).child(city).child(data)) {
            @Override
            protected void populateViewHolder(RoomViewHolder viewHolder, Item model, int position) {
                viewHolder.itemTitle.setText(model.getTitle());
                viewHolder.itemCondition.setText(model.getCondition());
                viewHolder.itemStreet.setText(model.getStreet());
            }
        };


        mRoomRecyclerView.setLayoutManager(mLinearLayoutManager);
        mRoomRecyclerView.setAdapter(mFirebaseAdapter);


        return v;
    }


    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(TAG, "onConnectionFailed:" +connectionResult);
        Toast.makeText(getActivity(), "Google Play Service error.", Toast.LENGTH_SHORT).show();

    }
}
