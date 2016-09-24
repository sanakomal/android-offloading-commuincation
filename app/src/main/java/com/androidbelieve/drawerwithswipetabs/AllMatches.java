package com.androidbelieve.drawerwithswipetabs;


import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class AllMatches extends Fragment {


    static final String URL = "http://static.cricinfo.com/rss/livescores.xml";

    ArrayList<HashMap<String, String>> livematches = new ArrayList<HashMap<String, String>>();

    static final String KEY_ITEM = "item"; // parent node

    static final String KEY_TITLE = "title";
    static final String KEY_DESCRIPTION = "description"; //name

    ListView listView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_matches, container, false);

        listView = (ListView)view.findViewById(R.id.id_list);
        {
            BackGroundClass check = new BackGroundClass(getActivity());
            check.execute();
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
            progressDialog = new ProgressDialog(ctx);
            progressDialog.setMessage("Please Wait...");
            progressDialog.setTitle("Wait");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(true);
            progressDialog.show();


        }
        @Override
        protected String doInBackground(String... params)
        {


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
                map.put(KEY_TITLE, parser.getValue(e, KEY_TITLE));
                map.put(KEY_DESCRIPTION,  parser.getValue(e, KEY_DESCRIPTION));
                // adding HashList to ArrayList
                livematches.add(map);
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
            if (progressDialog.isShowing())
                progressDialog.dismiss();

            ListAdapter adapter = new SimpleAdapter(ctx,livematches,R.layout.allmatcheslive,new String[]{KEY_TITLE,KEY_DESCRIPTION }, new int[]
                    {
                            R.id.textView
                    });

            listView.setAdapter(adapter);
        }
    }

}
