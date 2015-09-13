package solutions.utils;

import org.apache.commons.lang3.ArrayUtils;

public class Utils {

    public static void printArray(Object[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.print("[]");
            return;
        }
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

    public static void printArray(char[] arr) {
        Character[] _arr = ArrayUtils.toObject(arr);
        printArray(_arr);
    }

    public static void printArray(boolean[] arr) {
        Boolean[] _arr = ArrayUtils.toObject(arr);
        printArray(_arr);
    }

    public static void printArray(double[] arr) {
        Double[] _arr = ArrayUtils.toObject(arr);
        printArray(_arr);
    }

    public static void printArray(float[] arr) {
        Float[] _arr = ArrayUtils.toObject(arr);
        printArray(_arr);
    }

    public static void printArray(long[] arr) {
        Long[] _arr = ArrayUtils.toObject(arr);
        printArray(_arr);
    }

    public static void printArray(short[] arr) {
        Short[] _arr = ArrayUtils.toObject(arr);
        printArray(_arr);
    }

}
