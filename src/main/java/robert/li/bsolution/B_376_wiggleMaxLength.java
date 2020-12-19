package robert.li.bsolution;

public class B_376_wiggleMaxLength {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        // 如果数组长度小于2 ，只有0个元素或只有1个元素，整个数组是摆动序列
        if(length < 2){
            return length;
        }

        // 定义两个数组，分别记录原数组中，第i个元素如果是（上升节点/下降节点）的话，最长摆动序列的长度
        int[] up = new int[length], down = new int[length];
        // 第一个元素左边没有元素，所以它既可能是上升节点，也可能是下降节点
        up[0] = 1;
        down[0] = 1;

        // 从第二个元素开始遍历整个数组，根据每一个位置的元素，判断该元素下最长摆动序列的长度
        for(int i = 1; i < length; i++){
            // 如果该元素大于前面的元素，该元素为这两个元素中的上升节点
            if(nums[i] > nums[i-1]){
                // 该元素为上升节点时，该元素下最长摆动序列长度 = 上一个元素作为下降节点最长摆动序列长度 + 1
                up[i] = Math.max(down[i-1] + 1, up[i - 1]);
                // 因为该元素为上升节点，所以该元素作为下降节点下的最长摆动序列长度 = 上一个元素作为下降节点最长摆动序列长度
                down[i] = down[i - 1];
            } else if(nums[i] < nums[i-1]){
                // 同上
                up[i] = up[i - 1];
                down[i] = Math.max(up[i-1] + 1, down[i]);
            } else{
                // 如果该元素 = 上一个元素，则该元素作为（上升节点/下降节点）的情况不变
                up[i] = up[i - 1];
                down[i] = down[i - 1];
            }
        }
        // 输出最长摆动序列长度
        return Math.max(up[length - 1], down[length - 1]);
    }
}
