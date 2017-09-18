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

import com.sv.ordermobile.model.MItem;
import com.sv.ordermobile.model.MTransactor;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class ItemListActivity extends AppCompatActivity {
    private ListView lstItems;
    //
    private static final NumberFormat numberFormat = new DecimalFormat("#,##0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_list);

        this.lstItems = (ListView) findViewById(R.id.lstItems);
        this.lstItems.setAdapter(new ItemListAdapter(this, getItems()));
    }

    private List<MItem> getItems() {
        List<MItem> transactors = new ArrayList<>();
        for (int i = 0; i < 100; ++i) {
            MItem item = new MItem();
            item.setCode(i + "");
            item.setName("Name " + i);
//            item.setCreditLimit(Math.random() * 1000);
//            item.setCreditAmount(Math.random() * item.getCreditLimit());
            transactors.add(item);
        }

        return transactors;
    }

    private class ItemListAdapter extends ArrayAdapter<MItem> {
        private Context context;
        private List<MItem> clients;

        public ItemListAdapter(Context context, List<MItem> clients) {
            super(context, R.layout.layout_client_list, clients);

            this.context = context;
            this.clients = clients;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View listRowView = inflater.inflate(R.layout.layout_item_list, parent, false);

            ImageView imgIcon = (ImageView) listRowView.findViewById(R.id.imgIcon);
            TextView lblTitle = (TextView) listRowView.findViewById(R.id.lblTitle);
            TextView lblDescription = (TextView) listRowView.findViewById(R.id.lblDescription);

            MItem item = clients.get(position);
            lblTitle.setText(item.getName());

//            Double creditPrecent;
//            if (transactor.getCreditLimit() == 0) {
//                creditPrecent = 0.0;
//            } else {
//                creditPrecent = transactor.getCreditAmount() / transactor.getCreditLimit() * 100;
//            }
//
//            String description =
//                    numberFormat.format(transactor.getCreditAmount()) +
//                            " / " + numberFormat.format(transactor.getCreditLimit()) +
//                            " = (" + numberFormat.format(creditPrecent) + ")";
//            lblDescription.setText(description);
            imgIcon.setBackground(getDrawable(R.drawable.ic_face));

            return listRowView;
        }
    }
}

