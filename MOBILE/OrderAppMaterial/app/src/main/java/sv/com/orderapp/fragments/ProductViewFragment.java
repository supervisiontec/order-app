package sv.com.orderapp.fragments;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import sv.com.orderapp.R;
import sv.com.orderapp.activities.ProductActivity;
import sv.com.orderapp.adapters.MainPagerAdapter;
import sv.com.orderapp.database.DatabaseHelper;
import sv.com.orderapp.model.MItem;
import sv.com.orderapp.util.FormatUtil;

/**
 * Created by Mohan on 5/23/2016.
 */
public class ProductViewFragment extends Fragment {

    private DatabaseHelper databaseHelper;

    public ProductViewFragment() {
    }

    public static ProductViewFragment newInstance(int indexNo) {
        ProductViewFragment fragment = new ProductViewFragment();
        Bundle args = new Bundle();

        args.putInt(ProductActivity.CURRENT_PRODUCT_KEY, indexNo);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product_view, container, false);

        this.databaseHelper = new DatabaseHelper(getActivity());

        int indexNo = getArguments().getInt(ProductActivity.CURRENT_PRODUCT_KEY);
        initProduct(view, indexNo);

        return view;
    }

    private void initProduct(View view, int indexNo) {
        if (indexNo != -1) {
            MItem item = this.databaseHelper.getItem(indexNo);

            ((CollapsingToolbarLayout) getActivity().findViewById(R.id.collapsing_toolbar)).setTitle(item.getName());

            ((TextView) view.findViewById(R.id.code)).setText(item.getCode());
            ((TextView) view.findViewById(R.id.name)).setText(item.getName());
            ((TextView) view.findViewById(R.id.print_description)).setText(item.getPrintDescription());
            ((TextView) view.findViewById(R.id.department)).setText(item.getDepartment().getName());
            ((TextView) view.findViewById(R.id.main_category)).setText(item.getMainCategory().getName());
            ((TextView) view.findViewById(R.id.retail_price)).setText("Rs. " + FormatUtil.formatDouble(item.getRetailPrice()));
            ((TextView) view.findViewById(R.id.max_discount_percent)).setText(FormatUtil.formatDouble(item.getMaxDiscountPercent()) + " %");
            ((TextView) view.findViewById(R.id.cost_price)).setText("Rs. " + FormatUtil.formatDouble(item.getCostPrice()));
        } else {
            ((TextView) view.findViewById(R.id.code)).setText(null);
            ((TextView) view.findViewById(R.id.name)).setText(null);
            ((TextView) view.findViewById(R.id.print_description)).setText(null);
            ((TextView) view.findViewById(R.id.department)).setText(null);
            ((TextView) view.findViewById(R.id.main_category)).setText(null);
            ((TextView) view.findViewById(R.id.retail_price)).setText(null);
            ((TextView) view.findViewById(R.id.max_discount_percent)).setText(null);
            ((TextView) view.findViewById(R.id.cost_price)).setText(null);
        }
    }
}
