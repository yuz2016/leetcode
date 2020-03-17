package robert.li;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-12
 */
public class A_969_pancakeSort {

    List<Integer> res = new LinkedList<>();

    public List<Integer> pancakeSort(int[] A) {
        helper(A, A.length);
        return res;
    }

    void helper(int[] cakes, int n) {
        if (n == 1)
            return;

        // 最大饼索引
        int maxCake = 0;
        int maxCakeIndex = 0;
        for (int i = 0; i < n; i++) {
            if (cakes[i] > maxCake) {
                maxCakeIndex = i;
                maxCake = cakes[i];
            }
        }

        // 最大饼翻到最上面
        reverse(cakes, 0, maxCakeIndex);
        res.add(maxCakeIndex + 1);
        // 最大饼翻到最后面
        reverse(cakes, 0, n - 1);
        res.add(n);

        helper(cakes, n - 1);
    }

    void reverse(int[] arr, int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}
