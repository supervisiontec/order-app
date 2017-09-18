package sv.com.orderapp.activities;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import sv.com.orderapp.R;
import sv.com.orderapp.database.DatabaseHelper;
import sv.com.orderapp.model.MTransactor;
import sv.com.orderapp.util.EnvironmentVariables;

public class NewClientActivity extends AppCompatActivity {

    private DatabaseHelper databaseHelper;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_client);

        //database
        this.databaseHelper = new DatabaseHelper(this);

        //toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        this.collapsingToolbarLayout.setTitle("New Client");
        
        //fab
        FloatingActionButton fabDone = (FloatingActionButton) findViewById(R.id.fab_done);
        fabDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveClient();   
            }
        });
    }
    
    private void saveClient(){
        MTransactor transactor = new MTransactor();

        transactor.setName(((EditText) findViewById(R.id.name)).getText().toString());
        transactor.setContactPerson(((EditText) findViewById(R.id.contact_person)).getText().toString());
        transactor.setAddressLine1(((EditText) findViewById(R.id.address_line1)).getText().toString());
        transactor.setAddressLine2(((EditText) findViewById(R.id.address_line2)).getText().toString());
        transactor.setAddressLine3(((EditText) findViewById(R.id.address_line3)).getText().toString());
        transactor.setMobile(((EditText) findViewById(R.id.mobile)).getText().toString());
        transactor.setTelephone1(((EditText) findViewById(R.id.telephone1)).getText().toString());
        transactor.setTelephone2(((EditText) findViewById(R.id.telephone2)).getText().toString());
        transactor.setFax(((EditText) findViewById(R.id.fax)).getText().toString());
        transactor.setRoute(EnvironmentVariables.CURRENT_ROUTE);
        transactor.setCreditAmount(Double.valueOf(((EditText) findViewById(R.id.credit_amount)).getText().toString()));
        transactor.setCreditLimit(Double.valueOf(((EditText) findViewById(R.id.credit_limit)).getText().toString()));
        transactor.setClient(true);
        transactor.setVersion(1);

        databaseHelper.saveTransactor(transactor);

        Toast.makeText(this,"Client saved successfully",Toast.LENGTH_SHORT)
                .show();

        onBackPressed();
    }
    
    
}
