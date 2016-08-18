package com.gdg.eventmanager.architecture.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdg.eventmanager.R;
import com.gdg.eventmanager.ui.fragment.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atilabraga on 8/18/16.
 */

public class EventListFragment extends BaseFragment {

    @BindView(R.id.event_list_rv_events)
    RecyclerView rvEvents;
    EventAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

}
