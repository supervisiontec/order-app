package sv.com.orderapp.activities;

import android.content.DialogInterface;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RadioButton;
import android.widget.Toast;

import me.relex.circleindicator.CircleIndicator;
import sv.com.orderapp.R;
import sv.com.orderapp.adapters.ProductImagePagerAdapter;
import sv.com.orderapp.database.DatabaseHelper;
import sv.com.orderapp.fragments.OrderListFragment;
import sv.com.orderapp.fragments.ProductViewFragment;
import sv.com.orderapp.model.TOrderDetail;
import sv.com.orderapp.model.TOrderSummary;

public class ProductActivity extends AppCompatActivity {
    public static final String CURRENT_PRODUCT_KEY = "CURRENT_PRODUCT";
    public static final String CURRENT_CLIENT_KEY = "CURRENT_CLIENT";

    public static final String VIEW_MODE = "VIEW_MODE";
    public static final String VIEW_MODE_PRODUCT_VIEW = "PRODUCT_VIEW";
    public static final String VIEW_MODE_ORDER_VIEW = "ORDER_VIEW";

    private ViewPager viewPager;
    private boolean orderInProgress = false;
    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        //database helper
        this.databaseHelper = new DatabaseHelper(this);

        //toolbar
        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //
        this.viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new ProductImagePagerAdapter(this));

        CircleIndicator indicator = (CircleIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(viewPager);

        switch (getIntent().getStringExtra(VIEW_MODE)) {
            case VIEW_MODE_PRODUCT_VIEW:
                orderInProgress = false;
                attemptItemView(getIntent().getIntExtra(CURRENT_PRODUCT_KEY, -1));
                break;
            case VIEW_MODE_ORDER_VIEW:
                orderInProgress = true;
                attemptOrderView();
                break;
        }

        //fab actions
        findViewById(R.id.fab_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //save order
                TOrderSummary orderSummary = OrderListFragment.getOrderSummary();

                databaseHelper.saveOrderSummary(orderSummary);
                for (TOrderDetail orderDetail:orderSummary.getOrderDetails()){
                    databaseHelper.saveOrderDetail(orderDetail);
                }

                Toast.makeText(ProductActivity.this, "Order saved successfully", Toast.LENGTH_SHORT)
                        .show();

                OrderListFragment.setOrderSummary(null);
                finish();
            }
        });

        findViewById(R.id.fab_toggle).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //toggle
            }
        });

        findViewById(R.id.fab_filter).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //filter
            }
        });

//        RadioButton b;
//        b.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                switch (v.getId()){
//                    case R.id.rad_cash:
//
//                        break;
//                    case R.id.rad_cheque:
//
//                        break;
//                    case R.id.rad_credit:
//
//                        break;
//                }
//            }
//        });
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

    @Override
    public void onBackPressed() {
        if (orderInProgress) {
            attemptOrderView();
        } else {
            super.onBackPressed();
        }
    }

    public void attemptItemView(int indexNo) {
        findViewById(R.id.product_view_header).setVisibility(View.VISIBLE);
        findViewById(R.id.order_form_header).setVisibility(View.GONE);
        findViewById(R.id.searchbox).setVisibility(View.GONE);
        findViewById(R.id.fab_toggle).setVisibility(View.GONE);
        findViewById(R.id.fab_filter).setVisibility(View.GONE);
        findViewById(R.id.fab_done).setVisibility(View.GONE);

        final float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) (250 * scale + 0.5f);

        findViewById(R.id.appbar).setLayoutParams(new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, pixels));

        ProductViewFragment productViewFragment = ProductViewFragment.newInstance(indexNo);

        setContentFragment(productViewFragment);
    }

    private void attemptOrderView() {
        findViewById(R.id.appbar).setVisibility(View.VISIBLE);

        findViewById(R.id.product_view_header).setVisibility(View.GONE);
        findViewById(R.id.order_form_header).setVisibility(View.VISIBLE);
        findViewById(R.id.searchbox).setVisibility(View.VISIBLE);
        findViewById(R.id.fab_toggle).setVisibility(View.VISIBLE);
        findViewById(R.id.fab_filter).setVisibility(View.VISIBLE);
        findViewById(R.id.fab_done).setVisibility(View.VISIBLE);

        final float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) (320 * scale + 0.5f);

        findViewById(R.id.appbar).setLayoutParams(new CoordinatorLayout.LayoutParams(CoordinatorLayout.LayoutParams.MATCH_PARENT, pixels));

        ((CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar)).setTitle("New Order");

        OrderListFragment orderListFragment = new OrderListFragment();
        setContentFragment(orderListFragment);
    }

    private void setContentFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.main_content, fragment);
        transaction.commit();
    }
}
