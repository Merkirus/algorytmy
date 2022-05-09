package lab9;

import cw3.*;

public class BSTRPN {

    String rownanie;
    IQueue<Object> queue;

    public BSTRPN(String wyrazenie) throws EmptyStackException, EmptyQueueException, FullStackException {
        RPN rpn = new RPN(wyrazenie);
        rownanie = rpn.getRpnVersion();
        queue = rpn.getQueue();
    }

    public String getRownanie() {
        return rownanie;
    }

    public IQueue<Object> getQueue() {
        return queue;
    }
}
