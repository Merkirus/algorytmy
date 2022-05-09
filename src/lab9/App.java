package lab9;

import cw3.EmptyQueueException;
import cw3.EmptyStackException;
import cw3.FullStackException;
import cw5.BST;
import cw5.IntegerToStringExecutor;

import java.util.Comparator;

public class App {
    public static void main(String[] args) throws EmptyStackException, EmptyQueueException, FullStackException {
        String wyrazenie = "12.0+(3.0*2.0+6.0)";
        BSTRPN bstrpn = new BSTRPN(wyrazenie);
        wyrazenie = wyrazenie.replace("(", "");
        wyrazenie = wyrazenie.replace(")", "");
        System.out.println(bstrpn.getRownanie());
        BST<String> bst = new BST<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        bst.makeBST(bstrpn.getRownanie(),wyrazenie);
        ObjectToStringExecutor executor = new ObjectToStringExecutor();
        bst.postOrderWalk(executor);
        System.out.println(executor.getResult());
        System.out.println(bst.libczaLisci());
    }
}
