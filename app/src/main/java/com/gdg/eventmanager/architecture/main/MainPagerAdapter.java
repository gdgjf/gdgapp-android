package com.gdg.eventmanager.architecture.main;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.gdg.eventmanager.R;
import com.gdg.eventmanager.architecture.events.EventListFragment;

/**
 * Created by atilabraga on 8/17/16.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    enum Page {
        EVENTS(POSITION_EVENTS, R.string.title_tab_events, EventListFragment.newInstance()),
        GAMEFICATION(POSITION_GAMEFICATION, R.string.title_tab_events, EventListFragment.newInstance()),
        SCHEDULE(POSITION_SCHEDULE, R.string.title_tab_events, EventListFragment.newInstance());

        int position;
        int titleRes;
        Fragment fragment;

        Page(int position, @StringRes int titleRes, Fragment fragment) {
            this.position = position;
            this.titleRes = titleRes;
            this.fragment = fragment;
        }

        public static Page findByPosition(int position) {
            switch (position) {
                case POSITION_EVENTS:
                    return EVENTS;

                case POSITION_GAMEFICATION:
                    return GAMEFICATION;

                case POSITION_SCHEDULE:
                    return SCHEDULE;
            }
            return null;
        }

        @StringRes
        public int getTitleRes() {
            return titleRes;
        }

        public Fragment getFragment() {
            return fragment;
        }
    }

    private static final int POSITION_EVENTS = 0;
    private static final int POSITION_GAMEFICATION = 1;
    private static final int POSITION_SCHEDULE = 2;

    Context context;

    public MainPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        Page page = Page.findByPosition(position);
        if (page != null) {
            return page.getFragment();
        } else {
            return new Fragment();
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        Page page = Page.findByPosition(position);
        if (page != null) {
            return context.getString(page.getTitleRes());
        } else {
            return "";
        }
    }

    @Override
    public int getCount() {
        return Page.values().length;
    }

}
