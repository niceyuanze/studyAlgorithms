package search;

import com.sun.corba.se.spi.orb.OperationFactory;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by niceyuanze on 17-6-13.
 */
public class Test {

    public static void main(String[] args) {
        List<String> list =
                new ArrayList<String>(
                        Arrays.asList("a", "b", "b", "c", "c",
                                "c", "d", "d", "d", "f", "f", "g"));
        System.out.println(getElementPositions5(list));




        String[] names = {"111","222","333","444"};
        List<String> nameList;
        Stream<Integer> indices = IntStream.range(1,names.length).boxed();




    }

    public static Map<String, List<Integer>> getElementPositions1(List<String> list){
        Map<String, List<Integer>> positionMap = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            String str = list.get(i);
            List<Integer> positions = positionMap.get(str);
            if(positions == null){
                positions = new ArrayList<>();
                positions.add(i);
                positionMap.put(str,positions);
            }else{
                positions.add(i);
            }
        }
        return positionMap;

    }

    public static Map<String, List<Integer>> getElementPositions2(List<String> list){
        Map<String, List<Integer>> positionMap = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            String str = list.get(i);
            positionMap.putIfAbsent(str,new ArrayList<>());
            positionMap.get(str).add(i);
        }

        return positionMap;

    }



    public static Map<String, List<Integer>> getElementPositions3(List<String> list){
        Map<String, List<Integer>> positionsMap = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            positionsMap.compute(list.get(i), (k, v) -> v == null ? new ArrayList<>(1) : v).add(i);
        }

        return positionsMap;

    }


    public static Map<String, List<Integer>> getElementPositions4(List<String> list){
        Map<String, List<Integer>> positionsMap = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            positionsMap.computeIfAbsent(list.get(i), v -> new ArrayList<>()).add(i);
        }

        return positionsMap;

    }

    public static Map<String, List<Integer>> getElementPositions5(List<String> list){
        Map<String, List<Integer>> positionsMap = new HashMap<>();

        IntStream.range(0,list.size())
                .forEach(i -> positionsMap.computeIfAbsent(list.get(i), v -> new ArrayList<>()).add(i)
                );

        return positionsMap;

    }

}
