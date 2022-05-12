package lab9;

public class App {
    public static void main(String[] args) throws Exception {
        String wyrazenie = "((4.0+3.0)-(2.0+1.0)*2.0+3.0)/2.0";
        BSTRPN bstrpn = new BSTRPN(wyrazenie);
        bstrpn.makeTree();
        bstrpn.oblicz();
        System.out.println(bstrpn.getWynik());
    }
}
