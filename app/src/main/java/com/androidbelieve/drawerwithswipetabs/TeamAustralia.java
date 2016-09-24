package com.androidbelieve.drawerwithswipetabs;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.HashMap;

public class TeamAustralia extends AppCompatActivity {


    static final String URL = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20cricket.team.profile%20where%20team_id%3D1&diagnostics=true&env=store%3A%2F%2F0TxIGQMQbObzvU4Apia0V0";
    ArrayList<HashMap<String, String>> aussquad = new ArrayList<HashMap<String, String>>();

    // XML node keys
    static final String KEY_TEAMPROFILE = "TeamProfile";// parent
    static final String KEY_TEAMNAME = "TeamName";
    static final String KEY_PLAYERS = "Players";
    static final String KEY_PLAYER = "Player";
    static final String KEY_FIRSTNAME = "FirstName";
    static final String KEY_LASTNAME = "LastName";
    static final String player1F="player1F";
    static final String player1L="player1L";
    static final String player2F="player2F";
    static final String player2L="player2L";
    static final String player3F="player3F";
    static final String player3L="player3L";
    static final String player4F="player4F";
    static final String player4L="player4L";
    static final String player5F="player5F";
    static final String player5L="player5L";
    static final String player6F="player6F";
    static final String player6L="player6L";
    static final String player7F="player7F";
    static final String player7L="player7L";
    static final String player8F="player8F";
    static final String player8L="player8L";
    static final String player9F="player9F";
    static final String player9L="player9L";
    static final String player10F="player10F";
    static final String player10L="player10L";
    static final String player11F="player11F";
    static final String player11L="player11L";
    static final String player12F="player12F";
    static final String player12L="player12L";
    static final String player13F="player13F";
    static final String player13L="player13L";
    static final String player14F="player14F";
    static final String player14L="player14L";
    static final String player15F="player15F";
    static final String player15L="player15L";
    static final String player16F="player16F";
    static final String player16L="player16L";
    static final String player17F="player17F";
    static final String player17L="player17L";
    static final String player18F="player18F";
    static final String player18L="player18L";
    static final String player19F="player19F";
    static final String player19L="player19L";
    static final String player20F="player20F";
    static final String player20L="player20L";
    static final String player21F="player21F";
    static final String player21L="player21L";
    static final String player22F="player22F";
    static final String player22L="player22L";
    static final String player23F="player23F";
    static final String player23L="player23L";
    static final String player24F="player24F";
    static final String player24L="player24L";
    static final String player25F="player25F";
    static final String player25L="player25L";
    static final String player26F="player26F";
    static final String player26L="player26L";
    static final String player27F="player27F";
    static final String player27L="player27L";
    static final String player28F="player28F";
    static final String player28L="player28L";
    static final String player29F="player29F";
    static final String player29L="player29L";
    static final String player30F="player30F";
    static final String player30L="player30L";

    ListView listView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teamaustralia);

        listView = (ListView) findViewById(R.id.listViewA);

        BackGroundClass check = new BackGroundClass(this);
        check.execute();
    }

    public class BackGroundClass extends AsyncTask<String,Void,String> {
       ProgressDialog progressDialog;
        Context ctx;

        BackGroundClass(Context context) {
            this.ctx = context;
        }

        @Override
        protected void onPreExecute() {
            progressDialog = new ProgressDialog(ctx);
            progressDialog.setMessage("Please Wait...");
            progressDialog.setTitle("Wait");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            progressDialog.setCancelable(false);
            progressDialog.show();

        }

        @Override
        protected String doInBackground(String... params) {

            XMLPARSER parser = new XMLPARSER();
            String xml = parser.getXmlFromUrl(URL); // getting XML
            Document doc = parser.getDomElement(xml); // getting DOM element

            NodeList nl = doc.getElementsByTagName(KEY_TEAMPROFILE);
            // looping through all item nodes <item>
            for (int i = 0; i < nl.getLength(); i++) {
                // creating new HashMap
                HashMap<String, String> map = new HashMap<String, String>();
                Element e = (Element) nl.item(i);
                // map.put(KEY_TEAMNAME, parser.getValue(e, KEY_TEAMNAME));

                NodeList nnl = doc.getElementsByTagName(KEY_PLAYERS);
                for (int a1 = 0; a1 < nnl.getLength(); a1++) {
                    HashMap<String, String> map1 = new HashMap<String, String>();
                    Element e1 = (Element) nnl.item(a1);
                    {
                        NodeList nn = e1.getElementsByTagName(KEY_PLAYER);
                        // for (int t = 0; t < nn.getLength(); t++) {

                        Element ep1 = (Element) nn.item(0);
                        map1.put(player1F, parser.getValue(ep1, KEY_FIRSTNAME));
                        map1.put(player1L,parser.getValue(ep1,KEY_LASTNAME));

                        Element ep2 = (Element) nn.item(1);
                        map1.put(player2F, parser.getValue(ep2, KEY_FIRSTNAME));
                        map1.put(player2L, parser.getValue(ep2, KEY_LASTNAME));

                        Element ep3 = (Element) nn.item(2);
                        map1.put(player3F, parser.getValue(ep3, KEY_FIRSTNAME));
                        map1.put(player3L, parser.getValue(ep3, KEY_LASTNAME));

                        Element ep4 = (Element) nn.item(3);
                        map1.put(player4F, parser.getValue(ep4, KEY_FIRSTNAME));
                        map1.put(player4L, parser.getValue(ep4, KEY_LASTNAME));

                        Element ep5 = (Element) nn.item(4);
                        map1.put(player5F, parser.getValue(ep5, KEY_FIRSTNAME));
                        map1.put(player5L, parser.getValue(ep5, KEY_LASTNAME));

                        Element ep6 = (Element) nn.item(5);
                        map1.put(player6F, parser.getValue(ep6, KEY_FIRSTNAME));
                        map1.put(player6L, parser.getValue(ep6, KEY_LASTNAME));

                        Element ep7 = (Element) nn.item(6);
                        map1.put(player7F, parser.getValue(ep7, KEY_FIRSTNAME));
                        map1.put(player7L, parser.getValue(ep7, KEY_LASTNAME));

                        Element ep8 = (Element) nn.item(7);
                        map1.put(player8F, parser.getValue(ep8, KEY_FIRSTNAME));
                        map1.put(player8L, parser.getValue(ep8, KEY_LASTNAME));

                        Element ep9 = (Element) nn.item(8);
                        map1.put(player9F, parser.getValue(ep9, KEY_FIRSTNAME));
                        map1.put(player9L, parser.getValue(ep9, KEY_LASTNAME));

                        Element ep10 = (Element) nn.item(9);
                        map1.put(player10F, parser.getValue(ep10, KEY_FIRSTNAME));
                        map1.put(player10L, parser.getValue(ep10, KEY_LASTNAME));

                        Element ep11 = (Element) nn.item(10);
                        map1.put(player11F, parser.getValue(ep11, KEY_FIRSTNAME));
                        map1.put(player11L, parser.getValue(ep11, KEY_LASTNAME));

                        Element ep12 = (Element) nn.item(11);
                        map1.put(player12F, parser.getValue(ep12, KEY_FIRSTNAME));
                        map1.put(player12L, parser.getValue(ep12, KEY_LASTNAME));

                        Element ep13 = (Element) nn.item(12);
                        map1.put(player13F, parser.getValue(ep13, KEY_FIRSTNAME));
                        map1.put(player13L, parser.getValue(ep13, KEY_LASTNAME));

                        Element ep14 = (Element) nn.item(13);
                        map1.put(player14F, parser.getValue(ep14, KEY_FIRSTNAME));
                        map1.put(player14L, parser.getValue(ep14, KEY_LASTNAME));

                        Element ep15 = (Element) nn.item(14);
                        map1.put(player15F, parser.getValue(ep15, KEY_FIRSTNAME));
                        map1.put(player15L, parser.getValue(ep15, KEY_LASTNAME));

                        Element ep16 = (Element) nn.item(15);
                        map1.put(player16F, parser.getValue(ep16, KEY_FIRSTNAME));
                        map1.put(player16L, parser.getValue(ep16, KEY_LASTNAME));

                        Element ep17 = (Element) nn.item(16);
                        map1.put(player17F, parser.getValue(ep17, KEY_FIRSTNAME));
                        map1.put(player17L, parser.getValue(ep17, KEY_LASTNAME));

                        Element ep18 = (Element) nn.item(17);
                        map1.put(player18F, parser.getValue(ep18, KEY_FIRSTNAME));
                        map1.put(player18L, parser.getValue(ep18, KEY_LASTNAME));

                        Element ep19 = (Element) nn.item(18);
                        map1.put(player19F, parser.getValue(ep19, KEY_FIRSTNAME));
                        map1.put(player19L, parser.getValue(ep19, KEY_LASTNAME));

                        Element ep20 = (Element) nn.item(19);
                        map1.put(player20F, parser.getValue(ep20, KEY_FIRSTNAME));
                        map1.put(player20L, parser.getValue(ep20, KEY_LASTNAME));

                        Element ep21 = (Element) nn.item(20);
                        map1.put(player21F, parser.getValue(ep21, KEY_FIRSTNAME));
                        map1.put(player21L, parser.getValue(ep21, KEY_LASTNAME));

                        Element ep22 = (Element) nn.item(21);
                        map1.put(player22F, parser.getValue(ep22, KEY_FIRSTNAME));
                        map1.put(player22L, parser.getValue(ep22, KEY_LASTNAME));

                        Element ep23 = (Element) nn.item(22);
                        map1.put(player23F, parser.getValue(ep23, KEY_FIRSTNAME));
                        map1.put(player23L, parser.getValue(ep23, KEY_LASTNAME));

                        Element ep24 = (Element) nn.item(23);
                        map1.put(player24F, parser.getValue(ep24, KEY_FIRSTNAME));
                        map1.put(player24L, parser.getValue(ep24, KEY_LASTNAME));

                        Element ep25 = (Element) nn.item(24);
                        map1.put(player25F, parser.getValue(ep25, KEY_FIRSTNAME));
                        map1.put(player25L, parser.getValue(ep25, KEY_LASTNAME));

                        Element ep26 = (Element) nn.item(25);
                        map1.put(player26F, parser.getValue(ep26, KEY_FIRSTNAME));
                        map1.put(player26L, parser.getValue(ep26, KEY_LASTNAME));

                        Element ep27 = (Element) nn.item(26);
                        map1.put(player27F, parser.getValue(ep27, KEY_FIRSTNAME));
                        map1.put(player27L, parser.getValue(ep27, KEY_LASTNAME));

                        Element ep28 = (Element) nn.item(27);
                        map1.put(player28F, parser.getValue(ep28, KEY_FIRSTNAME));
                        map1.put(player28L, parser.getValue(ep28, KEY_LASTNAME));

                       /* Element ep29 = (Element) nn.item(28);
                        map1.put(player29F, parser.getValue(ep29, KEY_FIRSTNAME));
                        map1.put(player29L, parser.getValue(ep29, KEY_LASTNAME));

                        Element ep30 = (Element) nn.item(29);
                        map1.put(player30F, parser.getValue(ep30, KEY_FIRSTNAME));
                        map1.put(player30L, parser.getValue(ep30, KEY_LASTNAME));*/


                        aussquad.add(map1);
                    }
                }
                //  indiasquad.add(map);
            }
            // }

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

            ListAdapter adapter = new SimpleAdapter(ctx,aussquad,R.layout.activity_team_australia,new String[]{ player1F,player1L,player2F,player2L,player3F,player3L,player4F,player4L,player5F,player15L,player6F,player6L,player7F,player7L,player8F,player8L,player9F,player9L,player10F,player10L,
                    player11F,player11L,player12F,player12L,player13F,player13L,player14F,player14L,player15F,player15L,player16F,player16L,player17F,player17L,player18F,player18L,player19F,player19L,player20F,player20L,
                    player21F,player21L,player22F,player22L,player23F,player23L,player24F,player24L,player25F,player25L,player26F,player26L,player27F,player27L,player28F,player28L,//player29L,player29F,player30F,player30L,
                    }, new int[]
                    {
                            R.id.player1F,R.id.player1L,R.id.player2F,R.id.player2L,R.id.player3F,R.id.player3L,R.id.player4F,R.id.player4L,R.id.player5F,R.id.player5L,R.id.player6F,R.id.player6L,R.id.player7F,R.id.player7L,R.id.player8F,R.id.player8L,R.id.player9F,R.id.player9L,R.id.player10F,R.id.player10L,
                            R.id.player11F,R.id.player11L,R.id.player12F,R.id.player12L,R.id.player13F,R.id.player13L,R.id.player14F,R.id.player14L,R.id.player15F,R.id.player15L,R.id.player16F,R.id.player16L,R.id.player17F,R.id.player17L,R.id.player18F,R.id.player18L,R.id.player19F,R.id.player19L,R.id.player20F,R.id.player20L,
                            R.id.player21F,R.id.player21L, R.id.player22F,R.id.player22L,R.id.player23F,R.id.player23L,R.id.player24F,R.id.player24L,R.id.player25F,R.id.player25L,R.id.player26F,R.id.player26L,R.id.player27F,R.id.player27L,//R.id.player28F,R.id.player28L,R.id.player29F,R.id.player29L, R.id.player30F,R.id.player30L,
                             });
            listView.setAdapter(adapter);
        }



    }


}
