package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/27
 */
public class A_88_merge {

    public static void main(String[] args) {
        int[] nums1 = {1,2,4,5,6,0};
        int m = 5;
        int[] nums2 = {3};
        int n = 1;


        merge(nums1,m,nums2,n);
    }


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if(nums2.length == 0){
            return ;
        }


        // 移动
        int t = m + n;
        for (int x = t - 1, y = m-1; y >= 0; x--,y--) {
            nums1[x] = nums1[y];
        }

        // 比较付值
        int i = n, j = 0, z = 0;
        while (i < t && j < n) {
            if (nums1[i] <= nums2[j]) {
                nums1[z++] = nums1[i++];
            } else {
                nums1[z++] = nums2[j++];
            }
        }

        if (i == t) {
            while (j < n) {
                nums1[z++] = nums2[j++];
            }
        } else if (j == n) {
            while (i < t) {
                nums1[z++] = nums1[i++];
            }
        }
    }

    /**
     * 不用移动 比较最后一个元素 放到最后的位置
     * @param A
     * @param m
     * @param B
     * @param n
     */
    void merge1(int A[], int m, int B[], int n) {
        int i=m-1;
        int j=n-1;
        int k = m+n-1;
        while(i >=0 && j>=0)
        {
            if(A[i] > B[j])
                A[k--] = A[i--];
            else
                A[k--] = B[j--];
        }
        while(j>=0)
            A[k--] = B[j--];
    }
}
