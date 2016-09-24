package com.androidbelieve.drawerwithswipetabs;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class PastMatches extends Fragment {


    public PastMatches() {
        // Required empty public constructor
    }
Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_past_matches, container, false);

        button = (Button)view.findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), hongscot_istodi.class);
                startActivity(myIntent);
            }
        });

        button = (Button)view.findViewById(R.id.btn2ndodi);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), hongscot_2ndodi.class);
                startActivity(myIntent);
            }
        });

        button = (Button)view.findViewById(R.id.sriaus);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), ausSri_istt20.class);
                startActivity(myIntent);
            }
        });

        button = (Button)view.findViewById(R.id.sriaus2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), ausSri_2ndt20.class);
                startActivity(myIntent);
            }
        });

        button = (Button)view.findViewById(R.id.ept20);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), pakeng_t20.class);
                startActivity(myIntent);
            }
        });
        return view;



    }

}
