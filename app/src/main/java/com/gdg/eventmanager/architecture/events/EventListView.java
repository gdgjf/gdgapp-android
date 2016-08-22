package com.gdg.eventmanager.architecture.events;

import com.gdg.eventmanager.model.Event;

import java.util.List;

/**
 * Created by atilabraga on 8/21/16.
 */

public interface EventListView {

    void showEventLoader();

    void hideEventLoader();

    void showEvents(List<Event> events);

    void showEventsError();

}
