package robert.li.asolution;

public class A_134_canCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int length = gas.length;
        int maxRange = Integer.MAX_VALUE;
        int range = 0;
        int start = 0;
        for (int i = 0; i < length; i++) {
            range += gas[i] - cost[i];
            if(range < maxRange) {
                maxRange = range;
                start = i;
            }
        }
        if(range < 0) return -1;
        return start == length - 1 ? 0 : start + 1;
    }

}
