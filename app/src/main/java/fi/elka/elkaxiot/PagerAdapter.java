package fi.elka.elkaxiot;

import android.graphics.pdf.PdfDocument;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import layout.HomeFragment;
import layout.LogFragment;

/**
 * Created by fadhlika on 10/29/2016.
 */


public class PagerAdapter extends FragmentStatePagerAdapter {
    int numTabs;

    public PagerAdapter(FragmentManager fm, int numOfTabs){
        super(fm);
        this.numTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
            switch (position){
                case 0:
                    HomeFragment homeFragment = new HomeFragment();
                    return homeFragment;
                case 1:
                    LogFragment logFragment = new LogFragment();
                    return logFragment;
                default:
                    return null;
            }
    }

    @Override
    public int getCount() {
        return numTabs;
    }
}
