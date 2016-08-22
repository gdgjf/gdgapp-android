package com.gdg.eventmanager.architecture.events;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gdg.eventmanager.R;
import com.gdg.eventmanager.architecture.event.EventDetailActivity;
import com.gdg.eventmanager.model.Event;
import com.gdg.eventmanager.ui.fragment.BaseFragment;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by atilabraga on 8/18/16.
 */

public class EventListFragment extends BaseFragment implements EventListView, SwipeRefreshLayout.OnRefreshListener,
        EventAdapter.OnEventClickListener{

    @BindView(R.id.event_list_srv_swipe_refresh)
    SwipeRefreshLayout mSwipeRefresh;
    @BindView(R.id.event_list_rv_events)
    RecyclerView rvEvents;

    EventListPresenter presenter;
    EventAdapter adapter;

    public static Fragment newInstance() {
        EventListFragment fragment = new EventListFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_event_list, container, false);
        ButterKnife.bind(this, view);

        mSwipeRefresh.setOnRefreshListener(this);
        adapter = new EventAdapter(null);
        adapter.setListener(this);
        rvEvents.setAdapter(adapter);
        rvEvents.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,
                false));

        presenter = new EventListPresenterImpl(this);
        presenter.getEvents();

        return view;
    }

    @Override
    public void showEventLoader() {
        mSwipeRefresh.setRefreshing(true);
    }

    @Override
    public void hideEventLoader() {
        mSwipeRefresh.setRefreshing(false);
    }

    @Override
    public void showEvents(List<Event> events) {
        adapter.update(events);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showEventsError() {
    }

    @Override
    public void onRefresh() {
        presenter.getEvents();
    }

    @Override
    public void onEventClick(Event event) {
        if (event != null) {
            EventDetailActivity.start(getActivity(), event.getId());
        }
    }

    @Override
    public void onScheduleClick(Event event) {

    }

    @Override
    public void onShareClick(Event event) {

    }
}
