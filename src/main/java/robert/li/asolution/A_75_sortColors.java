package robert.li.asolution;

public class A_75_sortColors {
    public static void main(String[] args) {
        A_75_sortColors a_75_sortColors = new A_75_sortColors();
        a_75_sortColors.sortColors(new int[]{2,0,2,1,1,0});
    }

    public void sortColors(int[] nums) {
        if(nums.length == 0) return;
        // [0, zero] is 0
        // (zero, i) is 1
        // [two, length - 1] is 2
        int zero = -1;
        int two = nums.length;
        int i = 0;
        while(i < two) {
            if(nums[i] == 0) {
                zero++;
                swap(nums, zero, i);
                i++;
            } else if(nums[i] == 2) {
                --two;
                swap(nums, two, i);
            } else i++;
        }

    }

    void swap(int[] nums, int x, int y) {
        int tmp = nums[x];
        nums[x] = nums[y];
        nums[y] = tmp;
    }
}
