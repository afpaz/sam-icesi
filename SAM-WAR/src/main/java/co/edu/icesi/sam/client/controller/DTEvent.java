package co.edu.icesi.sam.client.controller;

import com.extjs.gxt.ui.client.event.EventType;
import com.extjs.gxt.ui.client.mvc.AppEvent;

public class DTEvent
{      
    public static AppEvent getAppEvent(EventType ev)
    {
        return new AppEvent(ev);
    }
}
