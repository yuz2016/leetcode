package robert.li.bsolution;

public class B_10_isMatch {
    public static void main(String[] args) {
        B_10_isMatch b_10_isMatch = new B_10_isMatch();
        boolean aa = b_10_isMatch.isMatch("aa", "a");
        System.out.println(aa);
    }

    public boolean isMatch(String s, String p) {
        char[] pArr = p.toCharArray();
        char[] sArr = s.toCharArray();
        int i = 0;
        int j = 0;
        while(i < pArr.length && j < sArr.length) {
            if(i + 1 < pArr.length && pArr[i + 1] == '*') {
                if(pArr[i] == '.') {
                    return true;
                } else {
                    boolean b = false;
                    b = b || isMatch(s.substring(j), p.substring(i + 2));
                    while (j < sArr.length && sArr[j] == pArr[i]) {
                        b = b || isMatch(s.substring(j + 1), p.substring(i + 2));
                        j++;
                    }
                    return b;
                }
            } else {
                if(sArr[j] != pArr[i] || pArr[i] == '.') {
                    return false;
                } else {
                    i++;
                    j++;
                }
            }
        }
        return i == pArr.length && j == sArr.length;
    }
}
