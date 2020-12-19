package robert.li.asolution;

public class A_738_monotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int N) {
        char[] chars = Integer.toString(N).toCharArray();
        if(chars.length == 1) return chars[0];
        int index = chars.length;
        for (int i = chars.length - 2; i >= 0; i--) {
            if(chars[i] > chars[i + 1]) {
                chars[i]--;
                index = i + 1;
            }
        }
        for (int i = index; i < chars.length; i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(new String(chars));
    }
}
