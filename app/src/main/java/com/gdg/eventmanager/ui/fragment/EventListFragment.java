package com.gdg.eventmanager.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdg.eventmanager.R;

/**
 * Created by atilabraga on 6/22/16.
 */

public class EventListFragment extends BaseFragment {

    RecyclerView mRecycler;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRecycler = (RecyclerView) inflater.inflate(R.layout.fragment_recycler, container, false);

        return mRecycler;
    }

    public static EventListFragment newInstance() {
        return new EventListFragment();
    }

}
