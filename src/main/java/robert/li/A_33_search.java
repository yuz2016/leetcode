package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-27
 */
public class A_33_search {
    public static void main(String[] args) {
        int[] ints = { 4, 5, 6, 7, 0, 1, 2 };
        A_33_search a_33_search = new A_33_search();
//        int search = a_33_search.search(ints, 3);
//        System.out.println(search);
        int search = a_33_search.search(new int[]{1,3}, 1);
        System.out.println(search);
    }

    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n < 1) return -1;
        int left = 0;
        int right = n - 1;
        if(target <= nums[right]) {
            while(left < right) {
                int mid = (left + right) / 2;
                if(nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    if(nums[mid] > target) {
                        right = mid - 1;
                    } else if(nums[mid] < target){
                        left = mid + 1;
                    }  else {
                        return mid;
                    }
                }
            }
        } else {
            while(left < right) {
                int mid = (left + right) / 2;
                if(nums[mid] < nums[left]) {
                    right = mid - 1;
                } else {
                    if(nums[mid] > target) {
                        right = mid - 1;
                    } else if(nums[mid] < target){
                        left = mid + 1;
                    }  else {
                        return mid;
                    }
                }
            }
        }
        return nums[left] == target ? left : -1;
    }
}
