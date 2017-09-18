package sv.com.orderapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import de.hdodenhof.circleimageview.CircleImageView;
import sv.com.orderapp.R;
import sv.com.orderapp.database.DatabaseHelper;
import sv.com.orderapp.model.MTransactor;
import sv.com.orderapp.util.FormatUtil;
import sv.com.orderapp.util.ImageUtil;

/**
 * Created by Mohan on 5/23/2016.
 */
public class ClientViewActivity extends AppCompatActivity {
    public static final String CURRENT_CLIENT_KEY = "CURRENT_CLIENT";

    private FloatingActionButton fabVisited;
    private FloatingActionButton fabNewOrder;
    private CoordinatorLayout coordinatorLayout;

    private DatabaseHelper databaseHelper;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_view);

        //database helper
        this.databaseHelper = new DatabaseHelper(this);
        initView(getIntent().getIntExtra(CURRENT_CLIENT_KEY, -1));

        //coordinator layout
        this.coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);

        //toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //fab
        this.fabVisited = (FloatingActionButton) findViewById(R.id.fab_visited);
        this.fabNewOrder = (FloatingActionButton) findViewById(R.id.fab_new_order);

        fabVisited.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptVisited();
            }
        });

        fabNewOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                attemptNewOrder();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return false;
        }
    }

    private void initView(int indexNo) {
        if (indexNo != -1) {
            MTransactor transactor = this.databaseHelper.getTransactor(indexNo);

            ((CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar)).setTitle(transactor.getName());
            ImageUtil.getClientAvatar(((CircleImageView) findViewById(R.id.profile_image)), transactor.getIndexNo());

            ((TextView) findViewById(R.id.name)).setText(transactor.getName());
            ((TextView) findViewById(R.id.contact_person)).setText(transactor.getContactPerson());
            ((TextView) findViewById(R.id.address_line1)).setText(transactor.getAddressLine1());
            ((TextView) findViewById(R.id.address_line2)).setText(transactor.getAddressLine2());
            ((TextView) findViewById(R.id.address_line3)).setText(transactor.getAddressLine3());
            ((TextView) findViewById(R.id.mobile)).setText(transactor.getMobile());
            ((TextView) findViewById(R.id.telephone)).setText(transactor.getTelephone1() + "/" + transactor.getTelephone2());
            ((TextView) findViewById(R.id.credit_amount)).setText("Rs. " + FormatUtil.formatDouble(transactor.getCreditAmount()));
            ((TextView) findViewById(R.id.credit_limit)).setText("Rs. " + FormatUtil.formatDouble(transactor.getCreditLimit()));
        } else {
            ((CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar)).setTitle(null);
            ImageUtil.getClientAvatar(((CircleImageView) findViewById(R.id.profile_image)), -1);

            ((TextView) findViewById(R.id.name)).setText(null);
            ((TextView) findViewById(R.id.contact_person)).setText(null);
            ((TextView) findViewById(R.id.address_line1)).setText(null);
            ((TextView) findViewById(R.id.address_line2)).setText(null);
            ((TextView) findViewById(R.id.address_line3)).setText(null);
            ((TextView) findViewById(R.id.mobile)).setText(null);
            ((TextView) findViewById(R.id.telephone)).setText(null);
            ((TextView) findViewById(R.id.credit_amount)).setText(null);
            ((TextView) findViewById(R.id.credit_limit)).setText(null);
        }
    }

    private void attemptVisited() {
        Toast.makeText(this, "Client marked as visited", Toast.LENGTH_SHORT)
                .show();

        //TODO: MARK AS VISITED DATABASE PERSIST

        onBackPressed();
    }

    private void attemptNewOrder() {
        Intent intent = new Intent(this, ProductActivity.class);

        intent.putExtra(ProductActivity.VIEW_MODE, ProductActivity.VIEW_MODE_ORDER_VIEW);
        intent.putExtra(ProductActivity.CURRENT_CLIENT_KEY, getIntent().getIntExtra(CURRENT_CLIENT_KEY, -1));

        startActivity(intent);
    }
}
