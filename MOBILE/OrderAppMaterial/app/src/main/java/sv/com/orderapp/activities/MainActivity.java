package sv.com.orderapp.activities;

import android.app.VoiceInteractor;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.quinny898.library.persistentsearch.SearchBox;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import sv.com.orderapp.R;
import sv.com.orderapp.database.DatabaseHelper;
import sv.com.orderapp.fragments.SyncFragment;
import sv.com.orderapp.fragments.MainFragment;
import sv.com.orderapp.model.MTransactor;
import sv.com.orderapp.network.SyncUtility;
import sv.com.orderapp.util.EnvironmentVariables;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TabLayout tabLayout;
    private FloatingActionButton floatingActionButton;
    private SearchBox searchBox;

    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SyncUtility syncUtility = new SyncUtility(this);
        syncUtility.syncDepartments();


        //toolbar
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        final ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);

        //
        EnvironmentVariables.CURRENT_ROUTE = 1;


        //search box
        searchBox = (SearchBox) findViewById(R.id.searchbox);
        searchBox.setLogoText("Order App");
        searchBox.enableVoiceRecognition(this);
        searchBox.setMenuListener(new SearchBox.MenuListener() {

            @Override
            public void onMenuClick() {
                drawerLayout.openDrawer(GravityCompat.START);
            }

        });

        //tab layout
        tabLayout = (TabLayout) findViewById(R.id.tabs);

        //navigationView settings
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                return MainActivity.this.onNavigationItemSelected(item);
            }
        });

        //fab
        floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptNewClient();
            }
        });

        //set main fragment
        attemptVisits();
        navigationView.getMenu().findItem(R.id.mnuHome).setChecked(true);

        //database helper
        this.databaseHelper = new DatabaseHelper(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case SearchBox.VOICE_RECOGNITION_CODE: {
                if (resultCode == RESULT_OK && null != data) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    for (String t :
                            result) {
//                        Log.d("A", t);
                    }

                    searchBox.populateEditText(result.get(0));
                }
                break;
            }
        }

        if (requestCode == 111) {
            if (resultCode == RESULT_OK) {
                ArrayList<String> matches = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                float[] scores = data.getFloatArrayExtra(RecognizerIntent.EXTRA_CONFIDENCE_SCORES);
                //  TODO:  loop through possible matches,
                //         and choose what you think is appropriate

                int i = 0;
                for (String t :
                        matches) {
                    Log.d("SPEECH", t + " - " + scores[i]);
                    ++i;
                }
            }
        }
    }

    @Override
    public boolean onSearchRequested() {
        return super.onSearchRequested();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
            default:
                return false;
        }
    }

    private boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnuHome:
                attemptVisits();
                return true;
            case R.id.mnuSync:
                attemptSync();
                return true;
            case R.id.mnuReports:
                attemptReports();
                return true;
            default:
                return false;
        }
    }


    private void attemptVisits() {
        MainFragment mainFragment = MainFragment.newInstance();
        setContentFragment(mainFragment);

        setTitle("Order App");

        tabLayout.setVisibility(View.VISIBLE);
    }

    private void attemptSync() {
        SyncFragment syncFragment = SyncFragment.newInstance();
        setContentFragment(syncFragment);

        tabLayout.setVisibility(View.GONE);
    }

    private void attemptReports() {

    }


    private void attemptNewClient() {
        Intent intent = new Intent(this, NewClientActivity.class);

        startActivity(intent);
    }


    private void setContentFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content, fragment);
        transaction.commit();
    }

    public void setFabVisibility(boolean state) {
        if (state) {
            floatingActionButton.show();
        } else {
            floatingActionButton.hide();
        }
    }
}
