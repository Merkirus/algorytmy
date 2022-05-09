package lab9;

import cw3.*;

public class BSTRPN {

    String rownanie;
    IQueue<Object> queue;
    double wynik;

    public BSTRPN(String wyrazenie) throws Exception {
        RPN rpn = new RPN(wyrazenie);
        rownanie = rpn.getRpnVersion();
        queue = rpn.getQueue();
        rpn.oblicz();
        wynik = rpn.getResult();
    }

    public double getWynik() {
        return wynik;
    }

    public String getRownanie() {
        return rownanie;
    }

    public IQueue<Object> getQueue() {
        return queue;
    }
}
