package sv.com.orderapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import sv.com.orderapp.R;
import sv.com.orderapp.activities.ProductActivity;
import sv.com.orderapp.adapters.OrderListRecyclerAdapter;
import sv.com.orderapp.database.DatabaseHelper;
import sv.com.orderapp.listeners.OrderItemChangeListener;
import sv.com.orderapp.listeners.RecyclerViewRowClickListener;
import sv.com.orderapp.model.MItem;
import sv.com.orderapp.model.TOrderDetail;
import sv.com.orderapp.model.TOrderSummary;
import sv.com.orderapp.util.DateTimeUtil;
import sv.com.orderapp.util.FormatUtil;

/**
 * Created by Mohan on 5/23/2016.
 */
public class OrderListFragment extends Fragment {

    private DatabaseHelper databaseHelper;

    private static TOrderSummary orderSummary;

    public static TOrderSummary getOrderSummary() {
        return orderSummary;
    }

    public static void setOrderSummary(TOrderSummary orderSummary) {
        OrderListFragment.orderSummary = orderSummary;
    }

    public OrderListFragment() {
        // Required empty public constructor
    }

    public static SyncFragment newInstance() {
        SyncFragment fragment = new SyncFragment();
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
        View view = inflater.inflate(R.layout.fragment_order_list, container, false);

        this.databaseHelper = new DatabaseHelper(getContext());

        if (orderSummary == null) {
            orderSummary = initOrderSummary();
        }
        initView();

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.lstOrderItem);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(new OrderListRecyclerAdapter(getContext(), orderSummary.getOrderDetails(), new RecyclerViewRowClickListener<TOrderDetail>() {
            @Override
            public void onClickRow(TOrderDetail orderDetail) {
                attemptProductView(orderDetail.getItem().getIndexNo());
            }
        },
                new OrderItemChangeListener() {
                    @Override
                    public void orderItemChanged() {
                        OrderListFragment.this.orderItemChanged();
                    }
                }));

        return view;
    }

    private TOrderSummary initOrderSummary() {
        TOrderSummary orderSummary = new TOrderSummary();

        orderSummary.setOrderDate(DateTimeUtil.getDate());
        orderSummary.setClient(getActivity().getIntent().getIntExtra(ProductActivity.CURRENT_CLIENT_KEY, -1));

        //items
        List<MItem> items = databaseHelper.getItemList();
        List<TOrderDetail> orderDetails = new ArrayList<>();

        for (MItem item : items) {
            TOrderDetail orderDetail = new TOrderDetail();

            orderDetail.setItem(item);
            orderDetail.setCostPrice(item.getCostPrice());
            orderDetail.setRetailPrice(item.getRetailPrice());
            orderDetail.setMaxDiscountPercent(item.getMaxDiscountPercent());
            orderDetail.setQuantity(0.0);
            orderDetail.setDiscountPercent(0.0);
            orderDetail.setItemValue(0.0);
            orderDetail.setVersion(1);

            orderDetails.add(orderDetail);
        }
        orderSummary.setOrderDetails(orderDetails);

        orderSummary.setStatus(TOrderDetail.STATUS_PENDING);
        orderSummary.setVersion(1);

        return orderSummary;
    }

    private void initView() {
        ((EditText) getActivity().findViewById(R.id.total_item_value)).setText(FormatUtil.formatDouble(orderSummary.getTotalItemValue()));
        ((EditText) getActivity().findViewById(R.id.total_item_discount)).setText(FormatUtil.formatDouble(orderSummary.getItemDiscountValue()));
        ((EditText) getActivity().findViewById(R.id.net_invoice_value)).setText(FormatUtil.formatDouble(orderSummary.getNetValue()));
    }

    private void orderItemChanged() {
        double itemValue = 0.0;
        double itemDiscountValue = 0.0;


        for (TOrderDetail orderDetail : orderSummary.getOrderDetails()) {
            orderDetail.setItemValue(orderDetail.getRetailPrice() * orderDetail.getQuantity());
            orderDetail.setDiscountValue((orderDetail.getRetailPrice() * orderDetail.getQuantity()) * orderDetail.getDiscountPercent() / 100);
            orderDetail.setNetValue(orderDetail.getItemValue() - orderDetail.getDiscountValue());

            itemValue = +orderDetail.getItemValue();
            itemDiscountValue = +orderDetail.getDiscountValue();
        }

        double specialDiscountPercent = 0.0;
        try {
            specialDiscountPercent = Double.parseDouble(((EditText) getActivity().findViewById(R.id.special_discount_percent)).getText().toString());
        } catch (Exception e) {
            specialDiscountPercent = 0.0;
        }

        double specialDiscountValue = (itemValue - itemDiscountValue) * specialDiscountPercent / 100;
        double netValue = itemValue - itemDiscountValue - specialDiscountValue;

        orderSummary.setTotalItemValue(itemValue);
        orderSummary.setItemDiscountValue(itemDiscountValue);
        orderSummary.setSpecialDiscountPercent(specialDiscountPercent);
        orderSummary.setSpecialDiscountValue(specialDiscountValue);
        orderSummary.setNetValue(netValue);

        initView();
    }

    private void attemptProductView(int indexNo) {
        ((ProductActivity) getActivity()).attemptItemView(indexNo);
    }
}
