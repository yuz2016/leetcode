package robert.li;

import java.util.Arrays;

/**
 * 切蛋糕问题
 * 我们有5块蛋糕，蛋糕的大小分别是 5，17，25，3，15
 * 我们有7位顾客，他们的饭量分别是 2，5，7，9，12，14，20
 * 在分发蛋糕时，有一个特殊的规则：蛋糕可分不可合。
 *
 * 什么意思呢？
 *
 * 一块较大的蛋糕，可以切分成多个小块，用来满足多个胃口较小的顾客 但是，若干块较小的蛋糕，不允许合并成一块大蛋糕，用来满足一个胃口较大的顾客
 * 最后的问题是：给定蛋糕大小的集合cakes，给定顾客饭量的集合mouths，如何计算出这些蛋糕可以满足的最大顾客数量？
 *
 * @author robert.li
 * @version v1.0.0
 * @since 2019/5/13
 */
public class B_6_CutCakes {
    //剩余蛋糕数量
    static int leftCakes[];
    //蛋糕总量（不是数量，而是大小之和）
    static int totalCake = 0;
    //浪费蛋糕量
    static int lostCake = 0;

    static boolean canFeed(int[] mouths, int monthIndex, int sum) {
        if (monthIndex <= 0) {
            //递归边界
            return true;
        }

        //如果 蛋糕总量-浪费蛋糕量 小于当前的需求量，直接返回false，即无法满足
        if (totalCake - lostCake < sum) {
            return false;
        }

        //从小到大遍历蛋糕
        for (int i = 0; i < leftCakes.length; i++) {
            if (leftCakes[i] >= mouths[monthIndex]) {
                //找到并吃掉匹配的蛋糕
                leftCakes[i] -= mouths[monthIndex];

                //剩余蛋糕小于最小的需求，变为浪费蛋糕
                if (leftCakes[i] < mouths[1]) {
                    lostCake += leftCakes[i];
                }

                //继续递归，试图满足mid下标之前的需求
                if (canFeed(mouths, monthIndex - 1, sum)) {
                    return true;
                }

                //无法满足需求，蛋糕状态回滚
                if (leftCakes[i] < mouths[1]) {
                    lostCake -= leftCakes[i];
                }
                leftCakes[i] += mouths[monthIndex];
            }
        }
        return false;
    }

    public static int findMaxFeed(int[] cakes, int[] mouths) {

        //蛋糕升序排列，并把0下标空出
        int[] cakesTemp = Arrays.copyOf(cakes, cakes.length + 1);
        Arrays.sort(cakesTemp);
        for (int cake : cakesTemp) {
            totalCake += cake;
        }

        //顾客胃口升序排列，并把0下标空出
        int[] mouthsTemp = Arrays.copyOf(mouths, mouths.length + 1);
        Arrays.sort(mouthsTemp);
        leftCakes = new int[cakes.length + 1];

        //需求之和（下标0的元素是0个人的需求之和，下标1的元素是第1个人的需求之和，下标2的元素是第1,2个人的需求之和.....）
        int[] sum = new int[mouths.length + 1];
        for (int i = 1; i <= mouths.length; i++) {
            sum[i] = sum[i - 1] + mouthsTemp[i];
        }

        //left和right用于计算二分查找的“中点”
        int left = 1, right = mouths.length;

        //如果胃口总量大于蛋糕总量，right指针左移
        while (sum[right] > totalCake) {
            right--;
        }

        //中位指针，用于做二分查找
        int mid = ((left + right) >> 1);

        while (left <= right) {
            //重置剩余蛋糕数组
            leftCakes = Arrays.copyOf(cakesTemp, cakesTemp.length);

            //重置浪费蛋糕量
            lostCake = 0;

            //递归寻找满足需求的临界点
            if (canFeed(mouthsTemp, mid, sum[mid])) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
            mid = ((left + right) >> 1);
        }

        //最终找到的是刚好满足的临界点
        return mid;
    }

    public static void main(String[] args) {
        int[] cakes = new int[] { 3, 5, 15, 17, 25 };
        int[] mouths = new int[] { 2, 5, 7, 9, 12, 14, 20 };
        int maxFeed = findMaxFeed(cakes, mouths);
        System.out.println("最大满足顾客数：" + maxFeed);
    }
}
