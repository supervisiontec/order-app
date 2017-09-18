package com.sv.ordermobile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.Arrays;

public class NavigationActivity extends AppCompatActivity {


    private ListView lstNavigation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        this.lstNavigation = (ListView) findViewById(R.id.lstNavigation);
        this.lstNavigation.setAdapter(new NavigationListAdapter(this));
    }


    //NAVIGATION LIST
    private static final String VISITS_NAV_TITLE = "Visits";
    private static final String NEW_CLIENT_NAV_TITLE = "New Client";
    private static final String SYNC_NAV_TITLE = "Sync";
    private static final String REPORTS_NAV_TITLE = "Reports";
    private static final String LOGOUT_NAV_TITLE = "Logout";

    private static final String[] NAV_TITLES = new String[]{
            VISITS_NAV_TITLE,
            NEW_CLIENT_NAV_TITLE,
            SYNC_NAV_TITLE,
            REPORTS_NAV_TITLE,
            LOGOUT_NAV_TITLE
    };

    private static final String[] NAV_DESCRIPTIONS= new String[]{
            "Daily visits and get client orders.",
            "Register new client.",
            "Sync with online server",
            "View reports.",
            "Logout System"
    };

    private static final int[] NAV_ICONS = new int[]{
            R.drawable.ic_add_shopping_cart,
            R.drawable.ic_accessibility,
            R.drawable.ic_backup,
            R.drawable.ic_description,
            R.drawable.ic_exit_to_app
    };

    class NavigationListAdapter extends ArrayAdapter<String> {
        Context context;

        public NavigationListAdapter(Context context) {
            super(context, R.layout.layout_navigation_item, NAV_TITLES);
            this.context = context;
//            android.R.drawable.ic
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View listRowView = inflater.inflate(R.layout.layout_navigation_item, parent, false);

            ImageView imgIcon = (ImageView) listRowView.findViewById(R.id.imgIcon);
            TextView lblTitle = (TextView) listRowView.findViewById(R.id.lblTitle);
            TextView lblDescription = (TextView) listRowView.findViewById(R.id.lblDescription);

            lblTitle.setText(NAV_TITLES[position]);
            lblDescription.setText(NAV_DESCRIPTIONS[position]);
            imgIcon.setBackground(getDrawable(NAV_ICONS[position]));

            return listRowView;
        }
    }
}
