package com.example.work4.Adapter;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.work4.Activities.MainpageActivity;
import com.example.work4.Fragment.AdFragment1;
import com.example.work4.Fragment.AdFragment2;
import com.example.work4.Fragment.AdFragment3;

public class AdAdapter extends FragmentPagerAdapter {
private AdFragment1 adfragment1;
private AdFragment2 adfragment2;
private AdFragment3 adfragment3;
    public AdAdapter(FragmentManager fm) {
        super(fm);
        adfragment1=new AdFragment1();
        adfragment2=new AdFragment2();
        adfragment3=new AdFragment3();
    }



    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainpageActivity.PAGE_ONE:
                fragment = adfragment1;
                break;
            case MainpageActivity.PAGE_TWO:
                fragment = adfragment2;
                break;
            case MainpageActivity.PAGE_THREE:
                fragment = adfragment3;
                break;
        }
        return fragment;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);
    }
    @Override
    public int getCount() {
        return 3;
    }

}
