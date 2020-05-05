package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-05-04
 */
public class A_1306_canReach {
    public static void main(String[] args) {
        A_1306_canReach a_1306_canReach = new A_1306_canReach();
        boolean b = a_1306_canReach.canReach(new int[]{0, 0}, 0);
        System.out.println(b);
    }

    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] b = new boolean[n];
        dfs(arr, start, b);
        boolean res = false;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                res = res || b[i];
            }
        }
        return res;
    }

    void dfs(int[] arr, int start, boolean[] b) {
        if(start < 0 || start > b.length - 1) return;
        if(b[start]) return;
        b[start] = true;
        dfs(arr, start + arr[start], b);
        dfs(arr, start - arr[start], b);
    }
}
