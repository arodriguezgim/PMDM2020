package com.creatersolutions.a12_fragmenttab.controlador;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class PageControler extends FragmentPagerAdapter {

    int numOfTabs;

    public PageControler(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        this.numOfTabs = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                    return new ContactosFragment();
            case 1:
                    return new CorreosFragment();
            case 2:
                    return new MensajesFragment();
            default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return numOfTabs;
    }
}
