package soo.joe.demo.algorithm;

import java.util.Arrays;

public class QuickSort {


    private static void quickSort(int[] arr) {
        if(arr==null||arr.length==0){
            return;
        }
        quick(arr,0,arr.length-1);
    }

    private static void quick(int[] arr, int low, int high) {
        int flag=partition(arr,low,high);
        if(flag>low+1){
            quick(arr,low,flag-1);
        }
        if(flag<high-1){
            quick(arr,flag+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int tmp=arr[low];
        while (low<high){
            while (low<high && arr[high] >= tmp){
                --high;
            }
            if(low>=high){
                break;
            }else {
                arr[low]=arr[high];
            }

            while (low<high && arr[low] <= tmp){
                ++low;
            }
            if(low>=high){
                break;
            }else {
                arr[high]=arr[low];
            }
        }
        arr[low]=tmp;
        return low;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{2,4,5,1};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
