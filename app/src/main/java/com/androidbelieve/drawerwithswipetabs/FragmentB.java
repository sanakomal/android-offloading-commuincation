package com.androidbelieve.drawerwithswipetabs;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentB extends android.support.v4.app.Fragment {

    static final String URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20cricket.news%20%20where%20region%3D%22in%22&diagnostics=true&env=store%3A%2F%2F0TxIGQMQbObzvU4Apia0V0";

    ArrayList<HashMap<String, String>> menuItems = new ArrayList<HashMap<String, String>>();

    ListView listView;

    // XML node keys
    static final String KEY_ITEM = "item"; // parent node
    //static final String KEY_ID = "id";
    static final String KEY_NAME = "author";
    static final String KEY_TITLE = "title";
    static final String KEY_DESC = "description";
    static final String KEY_LINK = "link";
    private ViewFlipper viewFlipper;
    private float lastX;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);

        listView = (ListView) view.findViewById(R.id.listB);
        // ImageView linkimg = (ImageView) itemView.findViewById(R.id.imglink);

        BackGroundClass check = new BackGroundClass(getActivity());
        check.execute();
        try {

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                @Override
                public void onItemClick(AdapterView<?> parent, View view,
                                        int position, long id) {
                    // getting values from selected ListItem

                    //Toast.makeText(getContext(),"Working",Toast.LENGTH_LONG).show();
                    String author = ((TextView) view.findViewById(R.id.name_label)).getText().toString();
                    String title = ((TextView) view.findViewById(R.id.tittle_label)).getText().toString();
                    String description = ((TextView) view.findViewById(R.id.description_label)).getText().toString();
                    String link= ((TextView) view.findViewById(R.id.link_label)).getText().toString();
                    //  String linkimg = (ImageView) itemView.findViewById(R.id.imglink);

                    // Starting new intent
                    Intent in = new Intent(getActivity(), SingleNewsItemActivity.class);
                    in.putExtra(KEY_NAME, author);
                    in.putExtra(KEY_TITLE, title);
                    in.putExtra(KEY_DESC, description);
                    in.putExtra(KEY_LINK, link);
                    startActivity(in);

                }
            });




        }
        catch (Exception e)
        {
            Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
        }
        return view;
    }

    public class BackGroundClass extends AsyncTask<String,Void,String>
    {
        ProgressDialog progressDialog;
        Context ctx;



        BackGroundClass(Context context) {
            this.ctx = context;
        }
        @Override
        protected void onPreExecute()
        {

        }
        @Override
        protected String doInBackground(String... params)
        {


            try {

                XMLPARSER parser = new XMLPARSER();
                String xml = parser.getXmlFromUrl(URL); // getting XML
                Document doc = parser.getDomElement(xml); // getting DOM element

                NodeList nl = doc.getElementsByTagName(KEY_ITEM);
                // looping through all item nodes <item>
                for (int i = 0; i < nl.getLength(); i++) {
                    // creating new HashMap
                    HashMap<String, String> map = new HashMap<String, String>();
                    Element e = (Element) nl.item(i);
                    // adding each child node to HashMap key => value
                    //map.put(KEY_ID, parser.getValue(e, KEY_ID));
                    map.put(KEY_DESC, parser.getValue(e, KEY_DESC));
                    map.put(KEY_NAME,"Author : " + parser.getValue(e, KEY_NAME));
                    map.put(KEY_TITLE,  parser.getValue(e, KEY_TITLE));
                    map.put(KEY_LINK, parser.getValue(e, KEY_LINK));
                    // adding HashList to ArrayList
                    menuItems.add(map);

                }


            }
            catch (Exception e)
            {
                Toast.makeText(getContext(),e.toString(),Toast.LENGTH_LONG).show();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values)
        {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result)
        {
            //if (progressDialog.isShowing())
              // progressDialog.dismiss();


            ListAdapter adapter = new SimpleAdapter(ctx,menuItems,R.layout.list_item_news,new String[]{KEY_NAME, KEY_DESC, KEY_TITLE, KEY_LINK}, new int[]
                    {
                            R.id.name_label, R.id.description_label, R.id.tittle_label, R.id.link_label
                    });

            listView.setAdapter(adapter);

        }
    }

    public boolean onTouchEvent(MotionEvent touchevent)
    {
        switch (touchevent.getAction())
        {
            // when user first touches the screen to swap
            case MotionEvent.ACTION_DOWN:
            {
                lastX = touchevent.getX();
                break;
            }
            case MotionEvent.ACTION_UP:
            {
                float currentX = touchevent.getX();

                // if left to right swipe on screen
                if (lastX < currentX)
                {
                    // If no more View/Child to flip
                    if (viewFlipper.getDisplayedChild() == 0)
                        break;

                    // set the required Animation type to ViewFlipper
                    // The Next screen will come in form Left and current Screen will go OUT from Right
                    viewFlipper.setInAnimation(getActivity(), R.anim.in_from_left);
                    viewFlipper.setOutAnimation(getActivity(), R.anim.out_to_right);
                    // Show the next Screen
                    viewFlipper.showNext();
                }

                // if right to left swipe on screen
                if (lastX > currentX)
                {
                    if (viewFlipper.getDisplayedChild() == 1)
                        break;
                    // set the required Animation type to ViewFlipper
                    // The Next screen will come in form Right and current Screen will go OUT from Left
                    viewFlipper.setInAnimation(getActivity(), R.anim.in_from_right);
                    viewFlipper.setOutAnimation(getActivity(), R.anim.out_to_left);
                    // Show The Previous Screen
                    viewFlipper.showPrevious();
                }
                break;
            }
        }
        return false;
    }

}

