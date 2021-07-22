package cn.yangcx.inner_class10.controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YANGCX
 * @date 2021/6/28 7:09
 */
public class Controller {

    private final List<Event> eventList = new ArrayList<>();

    public void addEvent(Event event) {
        eventList.add(event);
    }

    public void run() {
        while (eventList.size() > 0) {
            new ArrayList<>(eventList).forEach(event -> {
                if (!event.ready()) {
                    return;
                }
                System.out.println(event);
                // todo “变化的事务与不变的事务相互分离”
                event.action();
                eventList.remove(event);
            });
        }
    }

}
