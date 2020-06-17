package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-08
 */
public class A_990_equationsPossible {

    int[] uf = new int[26];

    int find(int x) {
        return uf[x] == x ? x : (uf[x] = find(uf[x]));
    }

    void merge(int a, int b) {
        uf[find(a)] = find(b);
    }

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < uf.length; i++) {
            uf[i] = i;
        }

        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            char[] chars = equation.toCharArray();
            if(chars[1] == '=') {
                int a = chars[0] - 'a';
                int b = chars[3] - 'a';
                merge(a, b);
            }
        }

        for (int i = 0; i < equations.length; i++) {
            String equation = equations[i];
            char[] chars = equation.toCharArray();
            if(chars[1] == '!') {
                int a = chars[0] - 'a';
                int b = chars[3] - 'a';
                if(find(a) == find(b)) {
                    return false;
                }
            }
        }
        return true;
    }
}
