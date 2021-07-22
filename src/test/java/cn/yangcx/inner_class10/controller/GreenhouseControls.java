package cn.yangcx.inner_class10.controller;

import lombok.ToString;

import java.util.Arrays;

/**
 * @author YANGCX
 * @date 2021/6/28 7:14
 */
public class GreenhouseControls extends Controller {

    @ToString
    public static class Terminate extends Event {
        public Terminate(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            System.exit(0);
        }
    }

    @ToString
    public class Restart extends Event {

        private final Event[] eventList;

        public Restart(long delayTime, Event[] eventList) {
            super(delayTime);
            this.eventList = eventList;
            Arrays.asList(eventList).forEach(GreenhouseControls.this::addEvent);
        }

        @Override
        public void action() {
            Arrays.asList(eventList).forEach(event -> {
                event.start();
                addEvent(event);
            });
            start();
            addEvent(this);
        }
    }

    @ToString
    public class Bell extends Event {
        public Bell(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            // insert a new one of itself into the event list
            addEvent(new Bell(delayTime));
        }
    }

    private String thermostat = "Day";

    @ToString
    public class ThermostatDay extends Event {
        public ThermostatDay(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Day";
        }
    }

    @ToString
    public class ThermostatNight extends Event {
        public ThermostatNight(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            thermostat = "Night";
        }
    }

    private boolean water = false;

    @ToString
    public class WaterOff extends Event {
        public WaterOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = false;
        }
    }

    @ToString
    public class WaterOn extends Event {
        public WaterOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            water = true;
        }
    }

    private boolean light = false;

    @ToString
    public class LightOff extends Event {

        public LightOff(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = false;
        }
    }

    @ToString
    public class LightOn extends Event {
        public LightOn(long delayTime) {
            super(delayTime);
        }

        @Override
        public void action() {
            light = true;
        }
    }

    public static void main(String[] args) {
        GreenhouseControls gc = new GreenhouseControls();
        gc.addEvent(gc.new Bell(900));
        Event[] eventList = {
                gc.new ThermostatNight(0),
                gc.new LightOn(200),
                gc.new LightOff(400),
                gc.new WaterOn(600),
                gc.new WaterOff(800),
                gc.new ThermostatDay(1400),
        };
        // Restart Event 可以触发周期性事件执行
        gc.addEvent(gc.new Restart(2000, eventList));
        if (args.length == 1) {
            gc.addEvent(new GreenhouseControls.Terminate(Integer.parseInt(args[0])));
        }
        gc.run();
    }

}
