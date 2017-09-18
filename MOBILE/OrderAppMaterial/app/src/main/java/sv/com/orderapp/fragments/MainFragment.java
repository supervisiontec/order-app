package sv.com.orderapp.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import sv.com.orderapp.R;
import sv.com.orderapp.activities.MainActivity;
import sv.com.orderapp.adapters.MainPagerAdapter;


public class MainFragment extends Fragment {

    public MainFragment() {
    }


    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ViewPager viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);

        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    public void setupViewPager(ViewPager viewPager) {
        MainPagerAdapter adapter = new MainPagerAdapter(getChildFragmentManager());
        adapter.addFragment(MainVisitListFragment.newInstance(), "Visits");
        adapter.addFragment(MainProductListFragment.newInstance(), "Products");
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                ((MainActivity) getActivity()).setFabVisibility(position == 0);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
