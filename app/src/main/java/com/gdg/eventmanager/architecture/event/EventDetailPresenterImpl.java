package com.gdg.eventmanager.architecture.event;

import com.gdg.eventmanager.api.GDGApi;
import com.gdg.eventmanager.architecture.GDGCallback;
import com.gdg.eventmanager.model.Event;

import retrofit2.Call;

/**
 * Created by atilabraga on 8/21/16.
 */

public class EventDetailPresenterImpl implements EventDetailPresenter {

    EventDetailView view;

    EventDetailPresenterImpl(EventDetailView view) {
        this.view = view;
    }

    @Override
    public void getEvent(long id) {
        GDGCallback<Event> callback = new GDGCallback<Event>() {
            @Override
            public void onSuccess(Call<Event> call, Event data) {
                view.showEvent(data);
            }

            @Override
            public void onFailure(Call<Event> call, Throwable t, String error) {
                view.showEvent(null);
            }
        };
        GDGApi.getInstance().getEvent(id).enqueue(callback);
    }

}
