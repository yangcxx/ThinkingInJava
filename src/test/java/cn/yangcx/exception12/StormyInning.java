package cn.yangcx.exception12;

/**
 * @author YANGCX
 * @date 2021/7/12 22:41
 */
public class StormyInning extends Inning implements Storm {


    public StormyInning() throws RainedOut, BaseballException {
        // todo 可以新增异常，但是必须抛出基类构造的异常
    }

    public StormyInning(String s) throws BaseballException {
        // todo 必须抛出基类异常
        super();
    }

    // todo 基类没有抛出异常，实现也不能抛出异常
    // public void walk() throws PopFoul {
    // }


    // todo Interface CANNOT add exceptions to existing methods from the base methods
    // @Override
    // public void event() throws RainedOut {
    //     super.event();
    // }


    @Override
    public void event() {
        // todo 可以不抛出任何异常
    }

    @Override
    public void atBat() throws Strike, Foul, PopFoul {
        // todo 可以新增抛出更小的异常
    }

    @Override
    public void rainHard() throws RainedOut {

    }
}

class BaseballException extends Exception {

    private static final long serialVersionUID = -1521970027294420926L;
}

class Foul extends BaseballException {

    private static final long serialVersionUID = -2496443775071961163L;
}

class Strike extends BaseballException {

    private static final long serialVersionUID = 1940239095369307381L;
}

abstract class Inning {
    public Inning() throws BaseballException {
    }

    public void event() throws BaseballException {

    }

    public abstract void atBat() throws Strike, Foul;

    public void walk() {
        // Throws no checked exceptions
    }
}

class StormException extends Exception {

    private static final long serialVersionUID = 4481901863605845778L;
}

class RainedOut extends StormException {

    private static final long serialVersionUID = 2902785188464079338L;
}

class PopFoul extends Foul {

    private static final long serialVersionUID = -1654092511702225667L;
}

interface Storm {
    void event() throws RainedOut;

    void rainHard() throws RainedOut;
}