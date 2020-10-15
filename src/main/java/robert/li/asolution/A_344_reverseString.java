package robert.li.asolution;

public class A_344_reverseString {
    public void reverseString(char[] s) {
        if(s.length == 0) return;
        char tmp;
        int i = 0;
        int j = s.length - 1;
        while(i < j) {
            tmp = s[i];
            s[i] = s[j];
            s[j] = tmp;
            i++;
            j--;
        }
    }
}
