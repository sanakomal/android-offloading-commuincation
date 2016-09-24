package com.androidbelieve.drawerwithswipetabs;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

public class MainActivity extends AppCompatActivity{
    DrawerLayout mDrawerLayout;
    NavigationView mNavigationView;
    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;
    ConnectionDetector cd;

    // Alert dialog manager
    AlertDialogManager alert = new AlertDialogManager();

    // Progress Dialog
    private ProgressDialog pDialog;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
//        searchView.setIconified(false);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cd = new ConnectionDetector(getApplicationContext());

        if (!cd.isConnectingToInternet()) {
            alert.showAlertDialog(MainActivity.this, "Internet Connection Error",
                    "Please connect to working Internet connection", false);
            return;
        }


        /**
         *Setup the DrawerLayout and NavigationView
         */

             mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
             mNavigationView = (NavigationView) findViewById(R.id.navigationstuff) ;

        /**
         * Lets inflate the very first fragment
         * Here , we are inflating the TabFragment as the first Fragment
         */

             mFragmentManager = getSupportFragmentManager();
             mFragmentTransaction = mFragmentManager.beginTransaction();
             mFragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();
        /**
         * Setup click events on the Navigation View Items.
         */

             mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
             @Override
             public boolean onNavigationItemSelected(MenuItem menuItem) {
                mDrawerLayout.closeDrawers();



                 if (menuItem.getItemId() == R.id.home_id) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView,new TabFragment()).commit();

                 }
                 if (menuItem.getItemId() == R.id.id_all) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView,new AllMatches()).commit();
                     menuItem.setChecked(true);
                 }
                 if (menuItem.getItemId() == R.id.id_recent) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView,new FragmentC()).commit();
                     menuItem.setChecked(true);
                 }
                 if (menuItem.getItemId() == R.id.id_photos) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView,new PhotosFragment()).commit();
                     menuItem.setChecked(true);
                 }
                 if (menuItem.getItemId() == R.id.id_past) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView,new PastMatches()).commit();
                     menuItem.setChecked(true);
                 }
                 if (menuItem.getItemId() == R.id.id_coming) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView,new UpcomingSeries()).commit();
                     menuItem.setChecked(true);
                 }

                 if (menuItem.getItemId() == R.id.id_t20) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView,new t20ranking()).commit();
                     menuItem.setChecked(true);
                 }
                 if (menuItem.getItemId() == R.id.id_test) {
                     FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                     fragmentTransaction.replace(R.id.containerView, new testranking()).commit();
                     menuItem.setChecked(true);
                 }

               if (menuItem.getItemId() == R.id.id_odi) {
                         FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
                         fragmentTransaction.replace(R.id.containerView,new odiranking()).commit();
                         menuItem.setChecked(true);
                     }

                 return false;
            }

        });

        /**
         * Setup Drawer Toggle of the Toolbar
         */

                android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);
                ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(this,mDrawerLayout, toolbar,R.string.app_name,
                R.string.app_name);

                mDrawerLayout.setDrawerListener(mDrawerToggle);

                mDrawerToggle.syncState();

    }

}