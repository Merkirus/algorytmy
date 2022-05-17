package lab10;

import cw3.EmptyQueueException;
import cw3.EmptyStackException;
import cw3.FullQueueException;
import cw3.FullStackException;
import cw5.IntegerToStringExecutor;

import java.util.HashMap;

public class App {
    public static void main(String[] args) throws EmptyStackException, EmptyQueueException, FullQueueException, FullStackException {
        HuffmanTree ht = new HuffmanTree();
        HashMap<Character, Integer> map = ht.frequency();
        ht.displayMap(map);
        ht.generateTree(map);
        ht.convertToCode();
        ht.displayCode();
        IntegerToStringExecutor executor = new IntegerToStringExecutor();
        ht.inOrderWalk(executor);
        System.out.println(executor.getResult());
        ht.saveCodeToFile();
    }
}
