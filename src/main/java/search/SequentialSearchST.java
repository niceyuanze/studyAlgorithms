package search;

/**
 * Created by niceyuanze on 17-6-11.
 */

import java.util.*;

/**
 *
 * @param <Key>
 * @param <Value>
 *     this is the symbol table based the linked list
 */
public class SequentialSearchST<Key, Value> {


    private Node first;


    private int size;

    private class Node{
        Key key;
        Value val;
        Node next;

        public Node(Key key, Value val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }

    public Value get(Key key){
        for(Node node = first; first != null; node = node.next){
            if(node.key.equals(key) ){
                return node.val;
            }
        }
        return null;
    }

    public void put(Key key,Value value){
        for(Node node = first; node != null; node = node.next ){
            if(key.equals(node.key)){
                node.val = value;
                return;
            }
        }
        first = new Node(key,value,first);
        size++;
    }








    public int size(){
        return size;
    }




    public Iterable<Key> keys(){
        Set<Key> set = new HashSet<>();
        for(Node node = first;node != null; node = node.next){
            set.add(node.key);
        }
        return set;
    }

    public static void main(String[] args) {
        SequentialSearchST<String,Integer> sequentialSearchST = new SequentialSearchST();
        String input = "SEARCHEXAMPLE";
        int  len = input.length();
        for(int i = 0; i < len; i++){
            sequentialSearchST.put(input.charAt(i)+"",i);
        }
        for(String key:sequentialSearchST.keys()){
            System.out.println(key+" "+sequentialSearchST.get(key));
        }
    }




}
