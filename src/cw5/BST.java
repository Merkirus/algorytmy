package cw5;

import cw3.ArrayQueue;
import cw3.EmptyQueueException;

import java.util.*;

public class BST<T> {

    private class Node {
        Node left, right;
        T value;
        Node(T obj) {
            value = obj;
        }
        Node(T obj, Node leftNode, Node rightNode) {
            value = obj;
            left = leftNode;
            right = rightNode;
        }
    }

    private Comparator<T> comparator;
    private Node root;

    public BST(Comparator<T> comp) {
        comparator = comp;
        root = null;
    }

    public T find(T elem) {
        Node node = search(elem);
        return node==null ? null :node.value;
    }

    private Node search(T elem) {
        Node node = root;
        int cmp = 0;
        while (node!=null && (cmp=comparator.compare(elem, node.value))!=0)
            node = cmp < 0 ? node.left : node.right;
        return node;
    }

    public T getMin() {
        if (root==null) throw new NoSuchElementException();
        Node node = getMin(root);
        return node.value;
    }

    private Node getMin(Node node) {
        assert(node!=null);
        while (node.left!=null)
            node = node.left;
        return node;
    }

    public T getMax() {
        if (root==null) throw new NoSuchElementException();
        Node node = getMax(root);
        return node.value;
    }

    private Node getMax(Node node) {
        assert(node!=null);
        while (node.right != null)
            node = node.right;
        return node;
    }

    public T successor(T elem) {
        Node succNode = successorNode(root, elem);
        return succNode == null ? null : succNode.value;
    }

    private Node successorNode(Node node, T elem) {
        if (node == null) throw new NoSuchElementException();
        int cmp = comparator.compare(elem, node.value);
        if (cmp == 0 ) {
            if (node.right != null)
                return getMin(node.right);
            else return null;
        } else if (cmp < 0) {
            Node retNode = successorNode(node.left, elem);
            return retNode == null ? node : retNode;
        } else {
            return successorNode(node.right, elem);
        }
    }

    public void insert(T elem) {
        root = insert(root, elem);
    }

    private Node insert(Node node, T elem) {
        if (node==null)
            node = new Node(elem);
        else {
            int cmp = comparator.compare(elem, node.value);
            if (cmp < 0)
                node.left = insert(node.left, elem);
            else if (cmp > 0)
                node.right = insert(node.right, elem);
            else throw new NoSuchElementException();
        }
        return node;
    }

    public void delete(T elem) {
        root = delete(root, elem);
    }

    private Node delete(Node node, T elem) {
        if (node == null) throw new NoSuchElementException();
        else {
            int cmp = comparator.compare(elem, node.value);
            if (cmp < 0)
                node.left = delete(node.left, elem);
            else if (cmp > 0)
                node.right = delete(node.right, elem);
            else if (node.left!=null && node.right!=null)
                node.right = detachMin(node, node.right);
            else node = (node.left != null) ? node.left : node.right;
        }
        return node;
    }

    private Node detachMin(Node del, Node node) {
        if (node.left != null)
            node.left = detachMin(del, node.left);
        else {
            del.value = node.value;
            node = node.right;
        }
        return node;
    }

    public int liczbaWezlow() {
        return liczbaWezlow(root);
    }

    private int liczbaWezlow(Node node) {
        if (node == null) return 0;
        return liczbaWezlow(node.left) + liczbaWezlow(node.right) + 1;
    }

    public int liczbaParzystychKluczy() {
        return liczbaParzystychKluczy(root);
    }

    private int liczbaParzystychKluczy(Node node) {
        if (node == null) return 0;
        if (((int) node.value) % 2 != 0)
            return liczbaParzystychKluczy(node.left) + liczbaParzystychKluczy(node.right);
        else
            return liczbaParzystychKluczy(node.left) + liczbaParzystychKluczy(node.right) + 1;
    }

    public int liczbaWezlowZJednymDzieckiem() {
        return liczbaWezlowZJednymDzieckiem(root);
    }

    private int liczbaWezlowZJednymDzieckiem(Node node) {
        if (node == null) return 0;
        if ((node.left == null || node.right == null) && !(node.left == null && node.right == null))
            return liczbaWezlowZJednymDzieckiem(node.right) + liczbaWezlowZJednymDzieckiem(node.left) + 1;
        return liczbaWezlowZJednymDzieckiem(node.right) + liczbaWezlowZJednymDzieckiem(node.left);
    }

    public int wysokosc() {
        if (root == null) return -1;
        return wysokosc(root, 0);
    }

    private int wysokosc(Node node, int curr_height) {
        if (node == null) return curr_height-1;
        int left = wysokosc(node.left, curr_height+1);
        int right = wysokosc(node.right, curr_height+1);
        if (left >= right)
            return left;
        else
            return right;
    }

    public int liczbaWezlowZJednymBratem() {
        return liczbaWezlowZJednymBratem(root);
    }

    private int liczbaWezlowZJednymBratem(Node node) {
        ArrayList<ArrayList<Node>> container = new ArrayList<>();
        for (int i = 0; i < wysokosc()+1; i++)
            container.add(new ArrayList<Node>());
        wysokoscDlaBraci(root, 0, container);
        int sum = 0;
        for (ArrayList<Node> nodes : container) {
            if (nodes.size() == 2)
                sum++;
        }
        return sum;
    }

    private int wysokoscDlaBraci(Node node, int curr_height, ArrayList<ArrayList<Node>> arr) {
        if (node == null) return curr_height-1;
        arr.get(curr_height).add(node);
        int left = wysokoscDlaBraci(node.left, curr_height+1, arr);
        int right = wysokoscDlaBraci(node.right, curr_height+1, arr);
        if (left >= right)
            return left;
        else
            return right;
    }

    public T findNajdluzszaSekwencja() {
        HashMap<Node, Integer> map = new HashMap<>();
        findNajdluzszaSekwencja(root, map);
        int max = 0;
        Node longestNode = null;
        for (Map.Entry<Node, Integer> entry : map.entrySet()) {
            System.out.println("Klucz: " + entry.getKey().value + " Wartość: " + entry.getValue());
            if (entry.getValue() > max) {
                max = entry.getValue();
                longestNode = entry.getKey();
            }
        }
        assert longestNode != null;
        return longestNode.value;
    }

    private int findNajdluzszaSekwencja(Node node, HashMap<Node, Integer> memo) {
        if (node.left == null && node.right == null) {
            memo.put(node, 0);
            return 0;
        }
        if (node.left != null && node.right != null) {
            memo.put(node, 0);
            findNajdluzszaSekwencja(node.left, memo);
            findNajdluzszaSekwencja(node.right, memo);
            return 0;
        }
        int path = 0;
        if (node.left == null) {
            path = findNajdluzszaSekwencja(node.right, memo) + 1;
        } else {
            path = findNajdluzszaSekwencja(node.left, memo) + 1;
        }
        memo.put(node, path);
        return path;
    }

    public void tablicaPozimow() {
        ArrayList<Node> finalArray = pomocPoziomy(root);
        for (Node nodus : finalArray) {
            System.out.print(nodus.value + ", ");
        }
    }

    private ArrayList<Node> pomocPoziomy(Node node) {
        ArrayList<ArrayList<Node>> container = new ArrayList<>();
        for (int i = 0; i < wysokosc()+1; i++)
            container.add(new ArrayList<Node>());
        wysokoscDlaBraci(root, 0, container);
        ArrayList<Node> finalArray = new ArrayList<>();
        for (ArrayList<Node> arr : container) {
            finalArray.addAll(arr);
        }
        return finalArray;
    }

    private ArrayList<ArrayList<Node>> pomocPoziomy2(Node node) {
        ArrayList<ArrayList<Node>> container = new ArrayList<>();
        for (int i = 0; i < wysokosc()+1; i++)
            container.add(new ArrayList<Node>());
        wysokoscDlaBraci(root, 0, container);
        return container;
    }

//    public void printPoziomy() {
//        ArrayList<ArrayList<Node>> arrayList = getPoziomy();
//        int _root = (int)arrayList.get(0).get(0).value;
//        System.out.printf("%100d", _root);
//        arrayList.remove(0);
//        int step = 30;
//        int prevStep = step;
//        int counter = -1;
//        for (ArrayList<Node> nodes : arrayList) {
//            System.out.println();
//            int count = nodes.size();
//            int left = 0;
//            int right = 0;
//            int single = 0;
//
//
//            if (count == 2) {
//                left = Math.min((int) nodes.get(0).value, (int) nodes.get(1).value);
//                right = Math.max((int) nodes.get(0).value, (int) nodes.get(1).value);
//            } else {
//                single = (int)nodes.get(0).value;
//            }
//
//            int adjust = 2*step;
//
//            if (counter == -1) {
//                if (count == 2) {
//                    System.out.printf("%"+(100-step)+"d%"+(adjust)+"d", left,right);
//                } else {
//                    if (single < _root)
//                        System.out.printf("%"+(100-step)+"d%"+(adjust)+"s", single,"");
//                    else
//                        System.out.printf("%"+(100-step)+"s%"+(adjust)+"d", "",single);
//                }
//            } else {
//                if (count == 2) {
//                    if (arrayList.get(counter).size() >= 2) {
//                        if  (left < _root) {
//
//                        }
//                    } else {
//
//                    }
//                } else {
//                    if (arrayList.get(counter).size() >= 2) {
//                        if (single < _root) {
//                            if (single < (int)arrayList.get(counter).get(0).value) {
//                                System.out.printf("%"+(100-step-5)+"d%"+(adjust)+"s", single,"");
//                            } else {
//                                System.out.printf("%"+(100-step+5)+"d%"+(adjust)+"s", single,"");
//                            }
//                        } else {
//                            if (single < (int)arrayList.get(counter).get(1).value) {
//                                System.out.printf("%"+(100-step)+"s%"+(adjust-5)+"d", "",single);
//                            } else {
//                                System.out.printf("%"+(100-step)+"s%"+(adjust+5)+"d", "",single);
//                            }
//                        }
//                    } else {
//                        if (single < (int)arrayList.get(counter).get(0).value) {
//                            System.out.printf("%"+(100-step)+"d%"+(adjust)+"s", single,"");
//                        } else {
//                            System.out.printf("%"+(100-step)+"s%"+(adjust)+"d", "",single);
//                        }
//                    }
//                }
//            }
//
//            prevStep = step;
//            step -= 5;
//            counter++;
//        }
//    }

    private ArrayList<ArrayList<Node>> getPoziomy() {
        return pomocPoziomy2(root);
    }

    public <R> void inOrderWalk(IExecutor<T,R> executor) {
        inOrderWalk(root,executor);
    }

    private <R> void inOrderWalk(Node node, IExecutor<T,R> executor) {
        if (node!=null) {
            inOrderWalk(node.left, executor);
            executor.execute(node.value);
            inOrderWalk(node.right, executor);
        }
    }

    public <R> void preOrderWalk(IExecutor<T,R> executor) {
        preOrderWalk(root, executor);
    }

    private <R> void preOrderWalk(Node node, IExecutor<T,R> executor) {
        if (node!=null) {
            executor.execute(node.value);
            preOrderWalk(node.left, executor);
            preOrderWalk(node.right, executor);
        }
    }

    public <R> void postOrderWalk(IExecutor<T,R> executor) {
        postOrderWalk(root, executor);
    }

    private <R> void postOrderWalk(Node node, IExecutor<T,R> executor) {
        if (node!=null) {
            postOrderWalk(node.left, executor);
            postOrderWalk(node.right, executor);
            executor.execute(node.value);
        }
    }
}