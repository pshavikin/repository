package ru.tsc.differenceFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainFunction {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();                            //("a", "b", "c", "f", "g");
        List<String> list2 = new ArrayList<>();                             //("a", "b", "c", "f", "k");
        list1.add(0, "a");
        list1.add(0, "b");
        list1.add(0, "c");
        list1.add(0, "f");
        list1.add(0, "g");
        list2.add(0, "a");
        list2.add(0, "b");
        list2.add(0, "c");
        list2.add(0, "f");
        list2.add(0, "k");
        System.out.println(differenceSort1(list1, list2));
        System.out.println(differenceSort2(list1, list2));
    }

    public static Collection<String> differenceSort1(Collection<String> list1, Collection<String> list2) {
        Collection<String> result = new ArrayList<>();
        Collection<String> finalResult = result;
        result = list1.stream().filter(s -> list2.contains(s) ? finalResult.remove(s) : finalResult.add(s)).collect(Collectors.toList());
        result = list2.stream().filter(s -> list1.contains(s) ? finalResult.remove(s) : finalResult.add(s)).collect(Collectors.toList());

        return finalResult;
    }
    public static Collection<String> differenceSort2(Collection<String> list1, Collection<String> list2) {
        Collection<String> listSave = new ArrayList<>();
         listSave.addAll(list1);
         list1.removeAll(list2);
         list2.removeAll(listSave);
         list1.addAll(list2);
        return list1;
    }

}


