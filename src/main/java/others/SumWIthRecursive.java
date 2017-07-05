package others;

import java.util.List;

/**
 * Created by niceyuanze on 17-6-17.
 */
public class SumWIthRecursive {

    private int sum(int[] array,int i){
        if(i == array.length - 1){
            return array[i];
        }
        return array[i] + sum(array,i+1);
    }

    public int sum(int[] array){
        int sum = 0;
        return sum + sum(array,0);
    }

    public int count(List list){
        return 0;
    }



    public static void main(String[] args) {
        SumWIthRecursive sumWIthRecursive = new SumWIthRecursive();
        int[] x = {1,2,3};
        System.out.println(sumWIthRecursive.sum(x));
    }

}
