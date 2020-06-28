package robert.li.asolution;

public class A_41_firstMissingPositive {

    public static void main(String[] args) {
        int[] a = new int[]{1, 1};
        A_41_firstMissingPositive a_41_firstMissingPositive = new A_41_firstMissingPositive();
        int i = a_41_firstMissingPositive.firstMissingPositive(a);
        System.out.println(i);
    }

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while(true) {
                if(nums[i] <= 0 || nums[i] - 1 > nums.length - 1 || nums[i] - 1 == i) {
                    break;
                } else {
                    if(nums[i] == nums[nums[i] - 1]) {
                        break;
                    }
                    swap(nums, i, nums[i] - 1);
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] - 1 != i) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
