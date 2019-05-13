package robert.li;

import java.util.Arrays;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2019/4/25
 */
public class B_5_QuickSort {
    public static void main(String[] args) {
        B_5_QuickSort b_5_quickSort = new B_5_QuickSort();
        int[] a = {1,5,32,3,2,223,61,8,9,622,533,4,3,1};
        System.out.println(Arrays.toString(a));
        b_5_quickSort.quickSort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));
    }

    public void quickSort(int arr[], int left, int right) {
        if(right <= left) {
            return;
        }
        int partition = partition(arr, left, right);
        quickSort(arr, left, partition - 1);
        quickSort(arr, partition + 1, right);
    }

    /**
     * 快慢之针法
     * @param arr 数组饮用
     * @param left 左下标
     * @param right 右下标
     * @return 基准位置
     */
    private int partition(int arr[], int left, int right) {
        int x = left - 1;
        int y = left;
        while(y < right) {
            // 如果arr[y] < arr[right] 交换 arr[++x]
            if (arr[y] < arr[right]) {
                swap(arr, ++x, y);
            }
            y++;
        }
        swap(arr, ++x, right);
        return x;
    }

    private void swap(int arr[], int x, int y) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }

}
