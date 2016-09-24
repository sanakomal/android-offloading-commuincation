package com.androidbelieve.drawerwithswipetabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;

/**
 * Created by sundas on 18/09/2016.
 */
public class SingleNewsItemActivity extends Activity {


    // XML node keys
    static final String KEY_NAME = "author";
    static final String KEY_TITLE = "title";
    static final String KEY_DESC = "description";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_list_item);

        // getting intent data
        Intent in = getIntent();

        // Get XML values from previous intent
        String name = in.getStringExtra(KEY_NAME);
        String cost = in.getStringExtra(KEY_TITLE);
        String description = in.getStringExtra(KEY_DESC);

        // Displaying all values on the screen
        TextView lbltitle = (TextView) findViewById(R.id.tittle);
        TextView lblName = (TextView) findViewById(R.id.author_label);
        TextView lblDesc = (TextView) findViewById(R.id.description_label);

        lblName.setText(name);
        lbltitle.setText(cost);
        lblDesc.setText(description);


    }
}





