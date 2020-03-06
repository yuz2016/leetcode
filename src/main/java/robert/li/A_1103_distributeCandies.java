package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-05
 */
public class A_1103_distributeCandies {


    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];
        int c = candies;
        int k = 0;// 当前层数
        while(true) {
            int cur = (2 * k * num_people +  num_people + 1) * num_people / 2;
            int newValue = c - cur;
            if(newValue < 0) {
                break;
            } else {
                c = newValue;
                k++;
            }
        }
        if(k - 1 >= 0) {
            int t = k - 1;
            for (int i = 0; i < res.length; i++) {
                res[i] = (t+1) * (t * num_people)/2  + (t+1) *(i + 1);
            }
        }

        for (int i = 0; i < res.length; i++) {
            if(c - (k * num_people + i + 1)> 0) {
                res[i] = res[i] + k * num_people + i + 1;
                c = c - (k * num_people + i + 1);
            } else {
                res[i] = res[i] + c;
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        A_1103_distributeCandies a_1103_distributeCandies = new A_1103_distributeCandies();
        a_1103_distributeCandies.distributeCandies(60,5);

    }

}
