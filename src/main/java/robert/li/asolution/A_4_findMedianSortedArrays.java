package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-24
 */
public class A_4_findMedianSortedArrays {
    public static void main(String[] args) {
        A_4_findMedianSortedArrays a_4_findMedianSortedArrays = new A_4_findMedianSortedArrays();
        double medianSortedArrays = a_4_findMedianSortedArrays.findMedianSortedArrays(new int[]{1, 2}, new int[]{3});
        System.out.println(medianSortedArrays);
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        int kth = getKth(nums1, nums2, 0, m - 1, 0, n - 1, left);
        int kth1 = getKth(nums1, nums2, 0, m - 1, 0, n - 1, right);
        return (kth + kth1) * 0.5;
    }

    int getKth(int[] nums1, int[] nums2, int start1, int end1, int start2, int end2, int k) {
        int length1 = end1 - start1 + 1;
        int length2 = end2 - start2 + 1;
        if(length1 > length2) return getKth(nums2, nums1, start2, end2, start1, end1, k);
        if(length1 == 0) return nums2[start2 + k - 1];
        if(k == 1) return Math.min(nums1[start1], nums2[start2]);
        int i = start1 + Math.min(length1, k / 2) - 1;
        int j = start2 + Math.min(length2, k / 2) - 1;
        if(nums1[i] < nums2[j]) {
            return getKth(nums1, nums2, i + 1, end1, start2, end2, k - (i - start1 + 1));
        } else {
            return getKth(nums1, nums2, start1, end1, j + 1, end2, k - (j - start2 + 1));
        }
    }
}
