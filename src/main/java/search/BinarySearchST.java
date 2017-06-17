package search;

import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * Created by niceyuanze on 17-6-12.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;


    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public int size(){
        return N;
    }


    public Value get(Key key){
        if(isEmpty()){
            return null;
        }
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0 ){
            return vals[i];
        }else{
            return null;
        }
    }


    public void put(Key key, Value value){
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            vals[i] = value;
            return;
        }
        for(int j = N; j > i; j--){
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = value;
        N++;
    }








    public boolean isEmpty(){
        return N == 0;
    }




    public int rank(Key key){
        return rank(key, 0,N - 1);
    }



    public int rank(Key key, int lo, int hi){
        if(hi < lo){
            return lo;
        }
        int mid = (lo + hi) / 2;
        int cmp = key.compareTo(keys[mid]);
        if(key.equals(keys[mid])){
            return mid;
        }
        if(cmp < 0){
            return rank(key,lo,mid - 1);
        }else if(cmp > 0){
            return rank(key, mid + 1, hi);

        }else{
            return mid;
        }

    }


    public int rank1(Key key, int lo, int hi){

        while(lo <= hi){
            if(hi < lo){
                return lo;
            }
            int mid = (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if(cmp > 0){
                lo = mid + 1;
            }else if(cmp < 0){
                hi = mid - 1;
            }else{
                return mid;
            }
        }
        return lo;
    }

    public Key min(){
        return keys[0];
    }

    public Key max(){
        return keys[N - 1];
    }

    public Key select(int k){
        return keys[k];
    }


//
//    public Iterable<Key> keys(Key lo, Key hi){
//        Set<Key> s = new HashSet<>();
//        for(int i = rank(lo); i < rank(hi);i++){
//            s.add(keys[i]);
//        }
//
//    }

    public boolean contains(Key key){
        int i = rank(key);
        if(i < N && keys[i].compareTo(key) == 0){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        BinarySearchST<String, Integer> binarySearchST = new BinarySearchST<>(13);
        String input = "SEARCHEXAMPLE";
        int  len = input.length();
        for(int i = 0; i < len; i++){
            binarySearchST.put(input.charAt(i)+"",i);
        }
        for(int i = 0; i < len; i++){
            System.out.println(input.charAt(i)+"    "+binarySearchST.get(input.charAt(i)+""));
        }
    }


}
