package solutions.utils;

import org.apache.commons.lang3.ArrayUtils;

public class Utils {

    public static void printArray(Object[] arr) {
        System.out.print("[");
        for (int i = 0; i < arr.length - 1; ++i) {
            System.out.print(arr[i].toString() + ", ");
        }
        System.out.println(arr[arr.length-1].toString() + "]");
    }

    public static void printArray(int[] arr) {
        Integer[] _arr = ArrayUtils.toObject(arr);
        printArray(_arr);
    }

}
