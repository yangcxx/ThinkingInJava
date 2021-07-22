package cn.yangcx.inner_class10.test;

import cn.yangcx.inner_class10.Destination;

/**
 * @author YANGCX
 * @date 2021/6/23 7:26
 */
public class Test2 {

    private class PDestination implements Destination {

        private final String label;

        public PDestination(String label) {
            this.label = label;
        }

        @Override
        public String readLabel() {
            System.out.println("PDestination.readLabel==>" + label);
            return label;
        }

        private void invokeReadLabel() {
            readLabel();
        }
    }

    public Destination destination() {
        return new PDestination("abc");
    }

}
