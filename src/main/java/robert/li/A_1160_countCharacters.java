package robert.li;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-17
 */
public class A_1160_countCharacters {
    public int countCharacters(String[] words, String chars) {
        int[] c = new int[26];
        for (char cc : chars.toCharArray()) {
            c[(cc - 'a')] += 1;
        }
        int res = 0;
        a:
        for (String word : words) {
            int[] w = new int[26];
            for (char ww : word.toCharArray()) {
                w[(ww - 'a')] += 1;
            }
            for (int i = 0; i < 26; i++) {
                if (w[i] > c[i]) {
                    continue a;
                }
            }
            res += word.length();
        }
        return res;
    }
}
