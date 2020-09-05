package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-07-22
 */
public class J_11_minArray {
    public static void main(String[] args) {
        int[] ints = {3,1};
        J_11_minArray j_11_minArray = new J_11_minArray();
        int i = j_11_minArray.minArray(ints);
        System.out.println(i);
    }

    public int minArray(int[] numbers) {
        int length = numbers.length;
        if(length == 0) {
            return 0;
        }
        int left = 0;
        int right = length - 1;
        while(left < right) {
            int mid = left + (right - left + 1) / 2;
            if(numbers[mid] > numbers[0]) {
                left = mid;
            } else if(numbers[mid] < numbers[0]){
                right = mid - 1;
            } else {
                left++;
            }
        }
        return left == length - 1 ? numbers[0] : numbers[left + 1];
    }
}
