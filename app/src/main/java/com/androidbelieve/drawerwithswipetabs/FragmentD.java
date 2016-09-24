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
public class FragmentD extends android.support.v4.app.Fragment {

    Button button;
    public FragmentD() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_d, container, false);

        button = (Button)view.findViewById(R.id.btn_india);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), TeamIndia.class);
                startActivity(myIntent);
            }
        });
// Team UAE
        button = (Button)view.findViewById(R.id.btn_uae);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start UpcomingSeries.class
                Intent myIntent = new Intent(getActivity(), TeamUAE.class);
                startActivity(myIntent);
            }
        });
//Team Scotland
        button = (Button)view.findViewById(R.id.btn_scotland);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                // Start UpcomingSeries.class
                Intent myIntent = new Intent(getActivity(), TeamScotland.class);
                startActivity(myIntent);
            }
        });
        //Team Afghanistanh
        button = (Button)view.findViewById(R.id.btn_afghanistan);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), TeamAfghanistan.class);
                startActivity(myIntent);
            }
        });

        //Team Ireland
        button = (Button)view.findViewById(R.id.btn_ireland);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), TeamIreland.class);
                startActivity(myIntent);
            }
        });

        //Team Pakistan
        button = (Button)view.findViewById(R.id.btn_pakistan);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), TeamPakistan.class);
                startActivity(myIntent);
            }
        });

        //Team Australia
        button = (Button)view.findViewById(R.id.btn_australia);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), TeamAustralia.class);
                startActivity(myIntent);
            }
        });

        //Team England
        button = (Button)view.findViewById(R.id.btn_england);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), TeamEngland.class);
                startActivity(myIntent);
            }
        });

        //Team NewZealand
        button = (Button)view.findViewById(R.id.btn_newzealand);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                Intent myIntent = new Intent(getActivity(), TeamNewzealand.class);
                startActivity(myIntent);
            }
        });

        //Team SriLanka
        button = (Button)view.findViewById(R.id.btn_srilanka);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), TeamSrilanka.class);
                startActivity(myIntent);
            }
        });

        //Team South Africa
        button = (Button)view.findViewById(R.id.btn_africa);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), TeamSouthafrica.class);
                startActivity(myIntent);
            }
        });

        //Team West Indies
        button = (Button)view.findViewById(R.id.btn_westindies);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), TeamWestindies.class);
                startActivity(myIntent);
            }
        });

        //Team Bangladesh
        button = (Button)view.findViewById(R.id.btn_bangladesh);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), TeamBangladesh.class);
                startActivity(myIntent);
            }
        });

        //Team Zimbabwe
        button = (Button)view.findViewById(R.id.btn_zimbabwe);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                Intent myIntent = new Intent(getActivity(), TeamZimbabwe.class);
                startActivity(myIntent);
            }
        });

        return view;
    }

}
