package robert.li.bsolution;

public class B_10_isMatch {
    public static void main(String[] args) {
        B_10_isMatch b_10_isMatch = new B_10_isMatch();
        boolean aa = b_10_isMatch.isMatch("aa", "a*");
    }

    public boolean isMatch(String s, String p) {
        char[] pArr = p.toCharArray();
        char[] sArr = s.toCharArray();
        int i = 0;
        int j = 0;
        while(i < pArr.length && j < sArr.length) {
            if(i < pArr.length && i + 1 == '*') {
                if(pArr[i] == '.') {
                    return true;
                } else {
                    boolean b = false;
                    b = b || isMatch(s.substring(i), p.substring(j + 2));
                    while (sArr[j] == pArr[i]) {
                        b = b || isMatch(s.substring(i + 1), p.substring(j + 2));
                        i++;
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
