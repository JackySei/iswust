package com.example.work4.Adapter;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import com.example.work4.Activities.MainpageActivity;
import com.example.work4.Fragment.MyFragment1;
import com.example.work4.Fragment.MyFragment2;
import com.example.work4.Fragment.MyFragment3;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 3;
    private MyFragment1 myFragment1 ;
    private MyFragment2 myFragment2 ;
    private MyFragment3 myFragment3 ;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        myFragment1 = new MyFragment1();
        myFragment2 = new MyFragment2();
        myFragment3 = new MyFragment3();
    }
    @Override
    public int getCount() {
        return PAGER_COUNT;
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
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case MainpageActivity.PAGE_ONE:
                fragment = myFragment1;
                break;
            case MainpageActivity.PAGE_TWO:
                fragment = myFragment2;
                break;
            case MainpageActivity.PAGE_THREE:
                fragment = myFragment3;
                break;
        }
        return fragment;
    }
}