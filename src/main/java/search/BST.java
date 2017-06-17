package search;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by niceyuanze on 17-6-12.
 */
public class BST<Key extends Comparable<Key>, Value> {


    private Node root;


    private class Node{

        private Key key;
        private Value value;
        private Node left,right;
        private int N;

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    ", N=" + N +
                    '}';
        }

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
            N = n;


        }
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public int size(){
        return size(root);

    }
    private int size(Node node){
        if(node == null){
            return 0;
        }
        return node.N;
    }
    public Value get(Key key){
        return get(root,key);
    }
    private Value get(Node node, Key key){
        if(node == null){
            return null;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            return get(node.left, key);
        }else if(cmp > 0){
            return get(node.right, key);
        }else{
            return node.value;
        }
    }



    public Value getNonRecursive(Key key){
        Node node = getNonRecursive(root, key);
        if(getNonRecursive(root,key) != null){
            return node.value;
        }else{
            return null;
        }

    }

    private Node getNonRecursive(Node node,Key key){

        while(node != null){
            int cmp  = key.compareTo(node.key);
            if(cmp < 0){
                node = node.left;
            }else if(cmp < 0){
                node = node.right;
            }else{
                return node;
            }
        }
        return null;


    }

    public void putNonRecursive(Key key, Value value){
        if(root == null){
            root = new Node(key,value,1);
        }
        Node highnow = root;
        Node now = root;
        int cmp = 0;
        while( now != null){
            cmp = key.compareTo(now.key);
            if(cmp < 0){
                highnow = now;
                now = now.left;
            }else if(cmp > 0){
                highnow = now;
                now = now.right;
            }else{
                now.value = value;
                return;
            }
        }
        if(cmp < 0){
            highnow.left = new Node(key,value,1);
        }else if(cmp > 0){
            highnow.right = new Node(key,value,1);
        }

    }

    public void put(Key key,Value value){
        root = put(root,key,value);
    }

    public Node put(Node x, Key key, Value value){
        if(x == null){
            return new Node(key,value,1);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = put(x.left, key, value);
        }else if(cmp > 0){
            x.right = put(x.right,key,value);
        }else{
            x.value = value;
            return x;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }


    public Key min(){
        return min(root).key;
    }
    public Node min(Node node){
        if(node.left == null){
            return node;
        }else{
            return min(node.left);
        }
    }

    public Key floor(Key key){
        Node t = floor(root,key);
        if(t == null){
            return null;
        }else{
            return t.key;
        }
    }

    private Node floor(Node x, Key key){
        if(x == null){
            return null;
        }

        if(key.equals(x.key)){
            return x;
        }
        if(x.left != null){
            return floor(x.left,key);
        }
        Node t = floor(x.right,key);
        if(t != null){
            return t;
        }else{
            return x;
        }


    }

    public Key select(int k){
        if(root == null){
            return null;
        }else{
            return select(root,k).key;
        }
    }

    private Node select(Node x, int k){
        if(x == null){
            return null;
        }
        if(size(x.left) > k){
            return select(x.left,k);
        }else if(size(x.left) < k){
            return select(x.right,k - size(x.left) - 1);
        }
        return x;
    }

    public int rank(Key key){
        return rank(root,key);
    }
    private int rank(Node node, Key key){
        if(node == null){
            return 0;
        }
        int cmp = key.compareTo(node.key);
        if(cmp < 0){
            return rank(node.left,key);
        }else if(cmp > 0){
            return rank(node.right,key) + size(node.left) + 1;
        }else{
            return size(node.left);
        }

    }


    public void deleteMin(){
        root = deleteMin(root);
    }

    private Node deleteMin(Node node){

        if(node.left == null){
            return node.right;
        }
        node.left = deleteMin(node.left);
        node.N = size(node.left) + size(node.right) + 1;
        return node;
    }

    public void delete(Key key){

    }
    private Node delete(Node x, Key key){

        int cmp = key.compareTo(x.key);
        if(cmp < 0){
            x.left = delete(x.left,key);
        }else if(cmp < 0){
            x.right = delete(x.right,key);
        }else{
            if(x.left == null){
                return x.right;
            }
            if(x.right == null){
                return x.left;
            }

            Node t = x;
            x = min(x);
            x.left = t.left;
            x.right = deleteMin(t);

        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public static void main(String[] args) {
        String input = "SEARCHEXAMPLE";

        BST bst = new BST();

        IntStream.range(0,input.length()).forEach(i -> bst.put(input.charAt(i)+"",i));

        System.out.println(bst.keys("F","T"));

//        System.out.println(bst.getRoot());
//        IntStream.range(0,input.length()).forEach(i -> System.out.println(input.charAt(i)+"   "+bst.get(""+input.charAt(i))));


//        input.chars().mapToObj(c -> c+"").for;
    }

    public Iterable<Key> keys(Key lo, Key hi){
        List<Key> list = new ArrayList<>();
        keys(root,list,lo,hi);
        return list;
    }

//[H, L, M, P, R, S]
    private void keys(Node x, List<Key> queue, Key lo, Key hi){
        if(x == null){
            return ;
        }
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if(cmplo < 0){
            keys(x.left,queue,lo,hi);
        }
        if(cmphi > 0){
            keys(x.right,queue,lo,hi);
        }
        if(cmplo <=0 && cmphi >= 0){
            queue.add(x.key);
        }

    }



}



