package sv.com.orderapp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sv.com.orderapp.R;
import sv.com.orderapp.activities.ProductActivity;
import sv.com.orderapp.adapters.MainProductsRecyclerAdapter;
import sv.com.orderapp.database.DatabaseHelper;
import sv.com.orderapp.listeners.RecyclerViewRowClickListener;
import sv.com.orderapp.model.MItem;


public class MainProductListFragment extends Fragment {
    private DatabaseHelper databaseHelper;

    public MainProductListFragment() {
        // Required empty public constructor
    }

    public static MainProductListFragment newInstance() {
        MainProductListFragment fragment = new MainProductListFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_list, container, false);

        this.databaseHelper = new DatabaseHelper(view.getContext());

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_products);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new MainProductsRecyclerAdapter(getActivity(), getProductList(), new RecyclerViewRowClickListener<MItem>() {
            @Override
            public void onClickRow(MItem item) {
                attemptProductView(item);
            }
        }));

        return view;
    }

    private List<MItem> getProductList() {
        List<MItem> items = this.databaseHelper.getItemList();
        return items;
    }

    private void attemptProductView(MItem item) {
        Intent intent = new Intent(getContext(), ProductActivity.class);

        intent.putExtra(ProductActivity.VIEW_MODE, ProductActivity.VIEW_MODE_PRODUCT_VIEW);
        intent.putExtra(ProductActivity.CURRENT_PRODUCT_KEY, item.getIndexNo());

        startActivity(intent);
    }

}
