package sv.com.orderapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import sv.com.orderapp.R;
import sv.com.orderapp.activities.ClientViewActivity;
import sv.com.orderapp.adapters.MainVisitsRecyclerAdapter;
import sv.com.orderapp.database.DatabaseHelper;
import sv.com.orderapp.listeners.RecyclerViewRowClickListener;
import sv.com.orderapp.model.MTransactor;
import sv.com.orderapp.util.EnvironmentVariables;


public class MainVisitListFragment extends Fragment {

    private DatabaseHelper databaseHelper;

    public MainVisitListFragment() {
        // Required empty public constructor
    }

    public static MainVisitListFragment newInstance() {
        MainVisitListFragment fragment = new MainVisitListFragment();
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
        View view = inflater.inflate(R.layout.fragment_visit_list, container, false);

        this.databaseHelper = new DatabaseHelper(getContext());

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_visits);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new MainVisitsRecyclerAdapter(getActivity(), getTransactorList(), new RecyclerViewRowClickListener<MTransactor>() {
            @Override
            public void onClickRow(MTransactor transactor) {
                attemptClientActivity(transactor);
            }
        }));

        return view;
    }

    private List<MTransactor> getTransactorList() {

        Log.d("ROUTE", EnvironmentVariables.CURRENT_ROUTE+"");
        List<MTransactor> transactors = databaseHelper.getTransactorList(EnvironmentVariables.CURRENT_ROUTE);

        return transactors;
    }

    private void attemptClientActivity(MTransactor transactor) {
        Log.d(transactor.getName(), transactor.getName());

        Intent intent = new Intent(getContext(), ClientViewActivity.class);
        intent.putExtra(ClientViewActivity.CURRENT_CLIENT_KEY, transactor.getIndexNo());

        startActivity(intent);
    }

}
