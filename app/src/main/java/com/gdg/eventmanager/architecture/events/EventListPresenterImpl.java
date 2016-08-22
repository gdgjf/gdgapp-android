package com.gdg.eventmanager.architecture.events;

import com.gdg.eventmanager.model.Event;

import java.util.List;

/**
 * Created by atilabraga on 8/21/16.
 */

public class EventListPresenterImpl implements EventListPresenter {

    EventListView view;
    EventListInteractor interactor;

    EventListPresenterImpl(EventListView view) {
        this.view = view;

        interactor = new EventListInteractorImpl();
    }

    @Override
    public void getEvents() {
        view.showEventLoader();
        EventListInteractor.OnGetEventList listener = new EventListInteractor.OnGetEventList() {
            @Override
            public void OnGotEventList(List<Event> events) {
                if (events != null) {
                    view.showEvents(events);
                } else {
                    view.showEventsError();
                }
                view.hideEventLoader();
            }
        };
        interactor.getEvents(listener);
    }

}
