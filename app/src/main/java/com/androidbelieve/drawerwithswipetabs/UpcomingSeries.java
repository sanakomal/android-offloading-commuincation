package com.androidbelieve.drawerwithswipetabs;

/**
 * Created by sundas on 17/09/2016.
 */
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class UpcomingSeries extends android.support.v4.app.Fragment {

    static final String URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20cricket.series.upcoming&diagnostics=true&env=store%3A%2F%2F0TxIGQMQbObzvU4Apia0V0";
    ArrayList<HashMap<String, String>> ongoingseries = new ArrayList<HashMap<String, String>>();

    // XML node keys
    static final String KEY_SERIES = "Series"; //parent
    static final String KEY_SERIESNAME = "SeriesName";
    static final String KEY_STARTDATE = "StartDate";
    static final String KEY_SCHEDULE= "Schedule";
    static final String KEY_MATCH = "Match";
    static final String KEY_MATCHNO = "MatchNo";
    static final String KEY_RESULT = "result";
    static final String KEY_VENUE="Venue";
    static final String KEY_TEAM="Team";

    ListView listView;
    ProgressDialog progressDialog;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.upcomingseries, container, false);

        listView = (ListView) view.findViewById(R.id.listView2);
        {
            BackGroundClass check = new BackGroundClass(getActivity());
            check.execute();

        }
        return view;
    }

    public class BackGroundClass extends AsyncTask<String,Void,String>
    {

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
            progressDialog.setCancelable(false);
            progressDialog.show();
        }
        @Override
        protected String doInBackground(String... params)
        {


            XMLPARSER parser = new XMLPARSER();
            String xml = parser.getXmlFromUrl(URL); // getting XML
            Document doc = parser.getDomElement(xml); // getting DOM element


            NodeList nl = doc.getElementsByTagName(KEY_SERIES);
            // looping through all item nodes <item>
            for (int i = 0; i < nl.getLength(); i++) {
                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();
                Element e = (Element) nl.item(i);
                // adding each child node to HashMap key => value
                map.put(KEY_SERIESNAME, parser.getValue(e, KEY_SERIESNAME));


                ongoingseries.add(map);

                NodeList nn = e.getElementsByTagName(KEY_SCHEDULE);
                for (int p = 0; p < nn.getLength(); p++) {

                    NodeList nnn = e.getElementsByTagName(KEY_MATCH);
                    for (int p1 = 0; p1 < nnn.getLength(); p1++) {
                        HashMap<String, String> map1 = new HashMap<String, String>();
                        Element enn = (Element) nnn.item(p1);
                        map1.put(KEY_STARTDATE, parser.getValue(enn, KEY_STARTDATE));
                        map1.put(KEY_MATCHNO, parser.getValue(enn, KEY_MATCHNO));
                        map1.put(KEY_VENUE, parser.getValue(enn, KEY_VENUE));
                        map1.put(KEY_TEAM,parser.getValue(enn,KEY_TEAM));

                        ongoingseries.add(map1);

                    }


                }}
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

            ListAdapter adapter = new SimpleAdapter(ctx,ongoingseries,R.layout.activity_upcoming_series,new String[]{KEY_SERIESNAME,KEY_MATCHNO,KEY_VENUE,KEY_STARTDATE, KEY_TEAM}, new int[]
                    {

                            R.id.seriesname, R.id.matchno, R.id.venue, R.id.date, R.id.teams,

                    });
            listView.setAdapter(adapter);

        }
    }}

