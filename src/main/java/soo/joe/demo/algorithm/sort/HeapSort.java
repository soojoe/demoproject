package soo.joe.demo.algorithm.sort;

import java.util.Arrays;

/**
 * @author: suzhou
 * @createtime: 2019-03-26 15:11
 * @description: 堆排序算法
 */
public class HeapSort {

    /**
     * 堆排序
     *
     * 1.从最底层的非叶子节点构建大顶堆
     * 2.将末尾元素和堆顶元素进行交换
     * 3.重新调整堆
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr){
        for(int i=(arr.length-2)/2;i>=0;i--){
            heap(arr,i,arr.length-1);
        }

        for(int i=arr.length-1;i>0;i--){
            swap(arr,0,i);
            heap(arr,0,i-1);
        }
        return arr;
    }

    /**
     * 堆调整
     * @param arr
     * @param i
     * @param length
     */
    private static void heap(int[] arr, int i, int length) {
        int left=i*2+1;
        int right=i*2+2;
        int largerNum=arr[i];
        int largerIndex=i;
        if(right<=length){
            if(arr[right]>largerNum){
                largerNum=arr[right];
                largerIndex=right;
            }
        }
        if(left<=length){
            if(arr[left]>largerNum){
                largerNum=arr[left];
                largerIndex=left;
            }
        }
        if(largerIndex!=i){
            swap(arr,largerIndex,i);
            heap(arr,largerIndex,length);
        }
    }

    /**
     * 数组元素交换
     * @param arr
     * @param largerIndex
     * @param i
     */
    private static void swap(int[] arr, int largerIndex, int i) {
        int tmp=arr[i];
        arr[i]=arr[largerIndex];
        arr[largerIndex]=tmp;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{1,5,2,3,7};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
