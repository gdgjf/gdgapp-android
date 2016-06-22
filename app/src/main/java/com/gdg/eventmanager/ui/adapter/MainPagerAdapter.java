package com.gdg.eventmanager.ui.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gdg.eventmanager.R;
import com.gdg.eventmanager.ui.fragment.EventListFragment;
import com.gdg.eventmanager.ui.fragment.GamificationListFragment;
import com.gdg.eventmanager.ui.fragment.ScheduleListFragment;

/**
 * Created by atilabraga on 6/21/16.
 */
public class MainPagerAdapter extends FragmentPagerAdapter {

    private enum MainPagerContent {
        FIRST(EventListFragment.newInstance(), R.string.tab_events),
        SECOND(GamificationListFragment.newInstance(), R.string.tab_gamification),
        THIRD(ScheduleListFragment.newInstance(), R.string.tab_schedule);

        private Fragment fragment;
        private int title;

        MainPagerContent(Fragment fragment, int title) {
            this.fragment = fragment;
            this.title = title;
        }

        public Fragment getFragment() {
            return fragment;
        }

        public int getTitle() {
            return title;
        }
    }

    private Context context;

    public MainPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return MainPagerContent.FIRST.getFragment();

            case 1:
                return MainPagerContent.SECOND.getFragment();

            case 2:
                return MainPagerContent.THIRD.getFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return MainPagerContent.values().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(MainPagerContent.FIRST.getTitle());

            case 1:
                return context.getString(MainPagerContent.SECOND.getTitle());

            case 2:
                return context.getString(MainPagerContent.THIRD.getTitle());
        }
        return super.getPageTitle(position);
    }
}
