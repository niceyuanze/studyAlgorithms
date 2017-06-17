package search;

/**
 * Created by niceyuanze on 17-6-15.
 */
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        Key key;
        Value val;
        Node left, right;
        int N;
        boolean color;

        Node(Key key, Value val, int N, boolean color){
            this.key = key;
            this.val = val;
            this.N = N;
            this.color = color;
        }

    }


    private Node put(Node h, Key key, Value val){
        if(h == null){
            return new Node(key, val, 1, RED);
        }

        int cmp = key.compareTo(h.key);
        if(cmp < 0){
            h.left = put(h.left, key, val);
        }else if(cmp > 0){
            h.right = put(h.right, key, val);
        }else{
            h.val = val;
        }
        if(isRed(h.right) && !isRed(h.left)){
            h = rotateLeft(h);
        }
        if(isRed(h.left) && isRed(h.left.left)){
            h = rotateRight(h);
        }
        if(isRed(h.left) && isRed(h.right)){
            flipColors(h);
        }
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }


    private boolean isRed(Node x){
        if(x == null) return false;
        return x.color == RED;
    }



    private void flipColors(Node h){
        if(h != null){
            h.left.color = false;
            h.right.color = false;
            h.color = true;
        }
    }
    private Node rotateLeft(Node h){
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private Node rotateRight(Node h){
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = size(h.left) + size(h.right) + 1;
        return x;
    }

    private int size(Node node){
        if(node == null){
            return 0;
        }else{
            return node.N;
        }

    }



}
