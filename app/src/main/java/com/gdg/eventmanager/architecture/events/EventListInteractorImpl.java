package com.gdg.eventmanager.architecture.events;

import com.gdg.eventmanager.api.GDGApi;
import com.gdg.eventmanager.architecture.GDGCallback;
import com.gdg.eventmanager.model.Event;

import java.util.List;

import retrofit2.Call;

/**
 * Created by atilabraga on 8/21/16.
 */

public class EventListInteractorImpl implements EventListInteractor {

    @Override
    public void getEvents(final OnGetEventList listener) {
        GDGCallback<List<Event>> callback = new GDGCallback<List<Event>>() {
            @Override
            public void onSuccess(Call<List<Event>> call, List<Event> data) {
                listener.OnGotEventList(data);
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t, String error) {
                listener.OnGotEventList(null);
            }
        };
        GDGApi.getInstance().getEvents().enqueue(callback);
    }

}
