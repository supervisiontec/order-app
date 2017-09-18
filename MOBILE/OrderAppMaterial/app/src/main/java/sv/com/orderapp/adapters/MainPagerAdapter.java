package sv.com.orderapp.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mohan on 5/22/2016.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments = new ArrayList<>();
    private List<String> fragmentTitiles = new ArrayList<>();

    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        this.fragments.add(fragment);
        this.fragmentTitiles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitiles.get(position);
    }
}
