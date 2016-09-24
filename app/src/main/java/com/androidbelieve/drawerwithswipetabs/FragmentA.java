package com.androidbelieve.drawerwithswipetabs;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Ratan on 7/29/2015.
 */
public class FragmentA extends Fragment {

    static final String URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20cricket.scorecard.live.summary&diagnostics=true&env=store%3A%2F%2F0TxIGQMQbObzvU4Apia0V0";
    ArrayList<HashMap<String, String>> livesummary = new ArrayList<HashMap<String, String>>();

    ListView listView;
    //TryAdapter ta;

    // XML node keys
    static final String Scorecard = "Scorecard"; // parent node
    static final String series_name = "series_name";
    static final String city= "city";
    static final String country = "country";
    static final String team1 = "team1";
    static final String teams = "teams";
    static final String id ="i";
    static final String team2 = "team2";
    static final String fn = "fn";
    static final String gimaget = "Gimaget";
    static final String date = "date";
    static final String enddate = "enddate";
    static final String mn = "mn";
    static final String past_ings = "past_ings";

    static final String pms = "pms";
    static final String dm = "dm";
    static final String r = "r";
    static final String o = "o";
    static final String w = "w";

    static final String r1 = "r";
    static final String o1 = "o";
    static final String w1 = "w";

    boolean Flag=false;
    ListAdapter adapter;
    ProgressDialog progressDialog;
    AlertDialog alertDialog;
   // AlertDialogManager alert = new AlertDialogManager();
    NoLiveMatch alert= new NoLiveMatch();
// dynamic Array

    // Array[][] data = new Array[][]{{}};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);


        listView = (ListView) view.findViewById(R.id.listA);

        //ta = new TryAdapter(getActivity().getApplicationContext(),R.layout.list_item_scores);
        // listView.setAdapter(ta);
        // if(Flag==false)
        {

            BackGroundClass check = new BackGroundClass(getActivity());
            check.execute();
           /* try {

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        // getting values from selected ListItem

                        Toast.makeText(getContext(),"Working",Toast.LENGTH_LONG).show();

                        // Starting new intent
                        Intent in = new Intent(getActivity(), Scorecard.class);
                        startActivity(in);

                    }
                });

            }
            catch (Exception e)
            {
                Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_LONG).show();
            }*/
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

        }
        @Override
        protected String doInBackground(String... params)
        {

            XMLPARSER parser = new XMLPARSER();
            String xml = parser.getXmlFromUrl(URL); // getting XML
            Document doc = parser.getDomElement(xml); // getting DOM element

            NodeList nl = doc.getElementsByTagName(Scorecard);
            int chk=nl.getLength();
            // looping through all item nodes <item>
            for (int i = 0; i < nl.getLength(); i++) {
                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();
                Element e = (Element) nl.item(i);
                // adding each child node to HashMap key => value
                map.put(series_name, parser.getValue(e, series_name));
                map.put(city, parser.getValue(e, city));
                map.put(country, parser.getValue(e, country)+"." );
                map.put(gimaget, parser.getValue(e, gimaget) );
                map.put(date, parser.getValue(e, date) );
                map.put(enddate, parser.getValue(e, enddate) );
                map.put(mn, parser.getValue(e, mn) );

                //livesummary.add(map);
                NodeList nn = doc.getElementsByTagName(teams);
                Element en = (Element) nn.item (0) ;
                map.put(team1,parser.getValue(en, fn));
                Element enn = (Element) nn.item(1);
                map.put(team2, parser.getValue(enn, fn));
               /* NodeList nn = e.getElementsByTagName(teams);
                int chk1=nn.getLength();
                for (int p = 0; p < nn.getLength(); p++) {
                   // HashMap<String, String> map2 = new HashMap<String, String>();
                    Element en = (Element) nn.item(p);
                    if(p==0) {
                        map.put(fn, parser.getValue(en, fn));
                        String str1=map.get(fn);
                        map.put(id,parser.getValue(en,id));
                    }
                    if(p==1) {
                        map.put(team2, parser.getValue(en, team2));
                        String str1=map.get(team2);
                    }
                   // Element enn = (Element) nn.item(1);
                    //map2.put(team2, "VS " + parser.getValue(enn, fn));

                   // livesummary.add(map);
                }*/
                //livesummary.add(map);

                NodeList nnn = e.getElementsByTagName(past_ings);
                int chk2=nn.getLength();
                for (int p = 0; p < nnn.getLength(); p++) {
                    // HashMap<String, String> map1 = new HashMap<String, String>();
                    Element e1 = (Element) nnn.item(p);
                    map.put(pms, parser.getValue(e1, pms));
                    map.put(dm, parser.getValue(e1, dm));
                    map.put(r, parser.getValue(e1, r));
                    map.put(o,"Overs " + parser.getValue(e1, o));
                    map.put(w, "/" +parser.getValue(e1, w));
                    //  livesummary.add(map);
                }
                livesummary.add(map);

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
          //  if (progressDialog.isShowing())
             //   progressDialog.dismiss();

         /*   if (series_name=="series_name"&& city=="city")
            {
                alert.showAlertDialog(getActivity(), "Notification",
                        "No live match right now", false);
                // stop executing code by return
                return;

            }*/
            //listView.invalidate();

            // listView.setAdapter(null);
            //map.get("team1"),map.get("team2");


            adapter = new SimpleAdapter(ctx,livesummary,R.layout.list_item_scores ,new String[]{series_name,city,country,dm,team1,team2,pms,r,o,w,mn}, new int[]
                    {
                            R.id.series_name,R.id.city,R.id.country,R.id.match_day,R.id.fn,R.id.team2,R.id.live,R.id.runs,R.id.overs,R.id.wickets, R.id.mn
                    });

            //  listView.setEmptyView(listView);
            /// / ((BaseAdapter) listView.getAdapter()).notifyDataSetChanged();
            listView.setAdapter(adapter);


        }
    }

}
