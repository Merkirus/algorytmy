package cw3;

public class App {

    public static void main(String[] args) throws FullStackException, EmptyStackException, EmptyQueueException {
        RPN rpn = new RPN("12+3*4+6");
        rpn.wyswietl();
        rpn.oblicz();
        rpn.wyswietlWynik();
    }

}
