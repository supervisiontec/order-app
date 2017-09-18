package com.sv.ordermobile;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.sv.ordermobile.model.MTransactor;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClientSelectActivity extends AppCompatActivity {

    private EditText txtSearch;
    private Button btnSearch;
    private ListView lstClients;
    //
    private static final NumberFormat numberFormat = new DecimalFormat("#,##0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_select);

        this.txtSearch = (EditText) findViewById(R.id.txtSearch);
        this.btnSearch = (Button) findViewById(R.id.btnSearch);
        this.lstClients = (ListView) findViewById(R.id.lstClients);

        this.lstClients.setAdapter(new ClientListAdapter(this, getClients()));
    }

    private List<MTransactor> getClients() {
        List<MTransactor> transactors = new ArrayList<>();
        for (int i=0;i<100;++i){
            MTransactor transactor = new MTransactor();
            transactor.setCode(i+"");
            transactor.setName("Name "+ i);
            transactor.setCreditLimit(Math.random()*1000);
            transactor.setCreditAmount(Math.random()*transactor.getCreditLimit());
            transactors.add(transactor);
        }

        return transactors;
    }

    private class ClientListAdapter extends ArrayAdapter<MTransactor> {
        private Context context;
        private List<MTransactor> clients;

        public ClientListAdapter(Context context, List<MTransactor> clients) {
            super(context, R.layout.layout_client_list, clients);

            this.context = context;
            this.clients = clients;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View listRowView = inflater.inflate(R.layout.layout_client_list, parent, false);

            ImageView imgIcon = (ImageView) listRowView.findViewById(R.id.imgIcon);
            TextView lblTitle = (TextView) listRowView.findViewById(R.id.lblTitle);
            TextView lblDescription = (TextView) listRowView.findViewById(R.id.lblDescription);

            MTransactor transactor = clients.get(position);
            lblTitle.setText(transactor.getName());

            Double creditPrecent;
            if (transactor.getCreditLimit() == 0) {
                creditPrecent = 0.0;
            } else {
                creditPrecent = transactor.getCreditAmount() / transactor.getCreditLimit() * 100;
            }

            String description =
                    numberFormat.format(transactor.getCreditAmount()) +
                            " / " + numberFormat.format(transactor.getCreditLimit()) +
                            " = (" + numberFormat.format(creditPrecent) + ")";
            lblDescription.setText(description);
            imgIcon.setBackground(getDrawable(R.drawable.ic_face));

            return listRowView;
        }
    }
}
