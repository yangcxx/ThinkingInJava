package cn.yangcx.typeinfo14;

import cn.yangcx.typeinfo14.factory.Factory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author YANGCX
 * @date 2021/7/22 10:08
 */
public class RegisteredFactories {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(Part.createRandom());
        }
    }

}

class Part {
    @Override
    public String toString() {
        return getClass().getCanonicalName();
    }

    static List<Factory<? extends Part>> partFactories = new ArrayList<>();

    static {
        Collections.addAll(partFactories,
                new FuelFilter.Factory(),
                new AirFilter.Factory(),
                new CabinAirFilter.Factory(),
                new OilFilter.Factory(),
                new FanBelt.Factory(),
                new PowerSteeringBelt.Factory(),
                new GeneratorBelt.Factory());
        // partFactories.add(new FuelFilter.Factory());
        // partFactories.add(new AirFilter.Factory());
        // partFactories.add(new CabinAirFilter.Factory());
        // partFactories.add(new OilFilter.Factory());
        // partFactories.add(new FanBelt.Factory());
        // partFactories.add(new PowerSteeringBelt.Factory());
        // partFactories.add(new GeneratorBelt.Factory());
    }

    private static final Random rand = new Random(47);

    public static Part createRandom() {
        int n = rand.nextInt(partFactories.size());
        return partFactories.get(n).create();
    }
}

class Filter extends Part {
}

class FuelFilter extends Filter {
    public static class Factory implements cn.yangcx.typeinfo14.factory.Factory<FuelFilter> {
        @Override
        public FuelFilter create() {
            return new FuelFilter();
        }
    }
}

class AirFilter extends Filter {
    public static class Factory implements cn.yangcx.typeinfo14.factory.Factory<AirFilter> {
        @Override
        public AirFilter create() {
            return new AirFilter();
        }
    }
}

class CabinAirFilter extends Filter {
    public static class Factory implements cn.yangcx.typeinfo14.factory.Factory<CabinAirFilter> {
        @Override
        public CabinAirFilter create() {
            return new CabinAirFilter();
        }
    }
}

class OilFilter extends Filter {
    public static class Factory implements cn.yangcx.typeinfo14.factory.Factory<OilFilter> {
        @Override
        public OilFilter create() {
            return new OilFilter();
        }
    }
}

class Belt extends Part {
}

class FanBelt extends Belt {
    public static class Factory implements cn.yangcx.typeinfo14.factory.Factory<FanBelt> {
        @Override
        public FanBelt create() {
            return new FanBelt();
        }
    }
}

class GeneratorBelt extends Belt {
    public static class Factory implements cn.yangcx.typeinfo14.factory.Factory<GeneratorBelt> {
        @Override
        public GeneratorBelt create() {
            return new GeneratorBelt();
        }
    }
}

class PowerSteeringBelt extends Belt {
    public static class Factory implements cn.yangcx.typeinfo14.factory.Factory<PowerSteeringBelt> {
        @Override
        public PowerSteeringBelt create() {
            return new PowerSteeringBelt();
        }
    }
}
