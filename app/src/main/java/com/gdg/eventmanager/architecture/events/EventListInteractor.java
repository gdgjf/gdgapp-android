package com.gdg.eventmanager.architecture.events;

import com.gdg.eventmanager.model.Event;

import java.util.List;

/**
 * Created by atilabraga on 8/21/16.
 */

public interface EventListInteractor {

    interface OnGetEventList {
        void OnGotEventList(List<Event> events);
    }

    void getEvents(OnGetEventList listener);

}
