package com.gdg.eventmanager.architecture.event;

import com.gdg.eventmanager.model.Event;

/**
 * Created by atilabraga on 8/21/16.
 */

public interface EventDetailView {

    void showContentLoader();

    void hideContentLoader();

    void showEvent(Event event);

}
