package com.zipcodewilmington.arrayutility;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by leon on 3/6/18.
 */
public class ArrayUtility<T> {
    T[] array;
    T[] arrayMerged;
    public ArrayUtility(T[] array){
        this.array = array;
    }
    public Integer countDuplicatesInMerge(T[] arrayToMerge, T valueToEvaluate){
        int count = 0;
        arrayMerged = Arrays.copyOf(array,array.length + arrayToMerge.length);
        System.arraycopy(arrayToMerge,0,arrayMerged,array.length, arrayToMerge.length);
        for (T checker : arrayMerged) {
            if (checker == valueToEvaluate){
                count += 1;
            }
        }
        return count;
    }
    public T getMostCommonFromMerge(T[] arrayToMerge){
        T result = null;
        Integer count;
        int max_count = 0;
        arrayMerged = Arrays.copyOf(array,array.length + arrayToMerge.length);
        System.arraycopy(arrayToMerge,0,arrayMerged,array.length, arrayToMerge.length);
        Map<T,Integer> mappy = new HashMap<>();
        for (T i : arrayMerged) {
            count = mappy.get(i);
            mappy.put(i, count != null ? count +1 : 1);
        }
        for (Map.Entry<T, Integer> val : mappy.entrySet()) {
            if (max_count < val.getValue()){
                result = val.getKey();
                max_count = val.getValue();
            }
        }
        return result;
    }
    public Integer getNumberOfOccurrences(T checker){
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == checker){
                count++;
            }
        }
        return count;
    }
    public T[] removeValue(T thisOne){
        ArrayList<T>list = new ArrayList<>();
        list.addAll(Arrays.asList(array));
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == thisOne){
                list.remove(list.get(i));
            }
        }
        T[] result = (T[]) Array.newInstance(list.get(0).getClass(), list.size());
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }





}
