package robert.li.asolution;

public class A_844_backspaceCompare {

    public static void main(String[] args) {
        A_844_backspaceCompare a_844_backspaceCompare = new A_844_backspaceCompare();
        boolean b = a_844_backspaceCompare.backspaceCompare("ab##", "c#d#");
        System.out.println(b);
    }
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        char[] chars = S.toCharArray();
        char[] chart = T.toCharArray();
        while(true) {
            int countI = 0;
            while(i >= 0 && chars[i] == '#') {
                while(i >= 0 && chars[i] == '#') {
                    i--;
                    countI++;
                }
                while(i >= 0 && chars[i] != '#' && countI > 0) {
                    i--;
                    countI--;
                }
            }
            int countJ = 0;
            while(j >= 0 && chart[j] == '#') {
                while(j >= 0 && chart[j] == '#') {
                    j--;
                    countJ++;
                }
                while(j >= 0 && chart[j] != '#' && countJ > 0) {
                    j--;
                    countJ--;
                }
            }
            if(i < 0 && j < 0) {
                return true;
            }
            if(i < 0 || j < 0) {
                return false;
            }
            if(chars[i] == chart[j]) {
                i--;
                j--;
            } else {
                return false;
            }
        }
    }
}
