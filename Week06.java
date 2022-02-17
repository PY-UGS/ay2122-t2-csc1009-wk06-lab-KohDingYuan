package School.Week06;

import java.util.*;

public class Week06 {
    public void tutQuestion01(){
        int[] values = { 11, 9, 1, 3, 7, 5};
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int value : values) list = addAndSort(list, value);

        System.out.print("LinkedList elements: ");
        for(int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
        System.out.print("\n");
    }
    public void tutQuestion02(){
        int[] values = { 11, 9, 1, 3, 7, 5};
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int value : values) list = addAndSort(list, value);
        list = swapValues(list, 1, 5);

        System.out.print("LinkedList elements: ");
        for(int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
        System.out.print("\n");
    }
    public void tutQuestion03(){
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i = 0; i < 500; i++) list.add(generateRandomNum(1000,9999));

        int targetInt = generateRandomNum(1000,9999);
        System.out.println(
            "TargetInt of " + targetInt + 
            (findValue(list, targetInt) > -1 ? " found": " not found") +
            ".");
    }
    public void tutQuestion04(){
        int[] values = { 11, 9, 1, 3, 7, 5};
        LinkedHashMap<Integer, Integer> list = new LinkedHashMap<Integer, Integer>();

        for(int i = 0; i < values.length; i++) list = addAndSort(list, values[i]);

        System.out.print("LinkedHashMap elements: ");
        for(int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
        System.out.print("\n");
    }
    public void tutQuestion05(){
        int[] values = { 11, 9, 1, 3, 7, 5};
        LinkedHashMap<Integer, Integer> list = new LinkedHashMap<Integer, Integer>();

        for(int i = 0; i < values.length; i++) list = addAndSort(list, values[i]);
        list = swapValues(list, 1, 5);

        System.out.print("LinkedHashMap elements: ");
        for(int i = 0; i < list.size(); i++) System.out.print(list.get(i) + " ");
        System.out.print("\n");
    }
    public void tutQuestion06(){
        LinkedHashMap<Integer, Integer> list = new LinkedHashMap<Integer, Integer>();
        for(int i = 0; i < 500; i++) list.put(i, generateRandomNum(1000,9999));

        int targetInt = generateRandomNum(1000,9999);
        System.out.println(
            "TargetInt of " + targetInt + 
            (findValue(list, targetInt) > -1 ? " found": " not found") +
            ".");
    }

    public LinkedList<Integer> addAndSort(LinkedList<Integer> list, int value){
        list.add(value);
        Collections.sort(list);
        return list;
    }
    public LinkedHashMap<Integer, Integer> addAndSort(LinkedHashMap<Integer, Integer> list, int value){
        list.put(list.size(), value);

        //Bubble Sort
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for(int i = 1; i < list.size(); i++){
                if(list.get(i) < list.get(i - 1)){
                    list = swapValues(list, i, i - 1);
                    sorted = false;
                }
            }
        }
        
        return list;
    }

    public LinkedList<Integer> swapValues(LinkedList<Integer> list, int indexOne, int indexTwo){
        int temp = list.get(indexOne);
        list.set(indexOne, list.get(indexTwo));
        list.set(indexTwo, temp);
        return list;
    }
    public LinkedHashMap<Integer, Integer> swapValues(LinkedHashMap<Integer, Integer> list, int indexOne, int indexTwo){
        int temp = list.get(indexOne);
        list.put(indexOne, list.get(indexTwo));
        list.put(indexTwo, temp);
        return list;
    }

    public int findValue(LinkedList<Integer> list, int searchVal){
        return list.indexOf(searchVal);
    }
    public int findValue(LinkedHashMap<Integer, Integer> list, int searchVal){
        for (Map.Entry<Integer, Integer> entry : list.entrySet()) {
            if (entry.getValue() == searchVal){
                return entry.getKey();
            };
        }
        return -1;
    }

    public int generateRandomNum(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}