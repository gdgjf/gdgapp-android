package com.gdg.eventmanager.architecture.event;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.gdg.eventmanager.R;
import com.gdg.eventmanager.architecture.BaseActivity;
import com.gdg.eventmanager.model.Event;

import butterknife.ButterKnife;

/**
 * Created by atilabraga on 8/21/16.
 */

public class EventDetailActivity extends BaseActivity implements EventDetailView {

    public static final String EXTRA_EVENT_ID = "event_id";
    public static final String KEY_EVENT_ID = "event_id";

    EventDetailPresenter presenter;
    Event event;

    public static void start(Context context, long id) {
        Intent intent = new Intent(context, EventDetailActivity.class);
        intent.putExtra(EXTRA_EVENT_ID, id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);

        presenter = new EventDetailPresenterImpl(this);

        buildState(savedInstanceState);
        showEvent(event);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
//        outState.putParcelable(KEY_EVENT_ID, event);
    }

    private void buildState(@Nullable Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            long id = getIntent().getLongExtra(EXTRA_EVENT_ID, 0);
            presenter.getEvent(id);
        } else {
//            event = savedInstanceState.getParcelable(KEY_EVENT_ID);
        }
    }

    @Override
    public void showContentLoader() {
    }

    @Override
    public void hideContentLoader() {
    }

    @Override
    public void showEvent(Event event) {
        if (event == null) return;
    }

}
