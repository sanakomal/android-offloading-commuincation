package com.androidbelieve.drawerwithswipetabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class PhotosFragment extends Fragment {


    private ViewFlipper viewFlipper;
    private float lastX;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false);
    }




}
