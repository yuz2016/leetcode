package robert.li.asolution;

public class A_424_characterReplacement {
    public static void main(String[] args) {

        A_424_characterReplacement a_424_characterReplacement = new A_424_characterReplacement();
        a_424_characterReplacement.characterReplacement("BAAA", 0);
    }
    public int characterReplacement(String s, int k) {
        char[] chars = s.toCharArray();
        int[] map = new int[26];
        int historyMaxCount = 0;
        int left = 0;
        int right = 0;
        for(; right < chars.length; right++) {
            int index = chars[right] - 'A';
            map[index]++;
            historyMaxCount = Math.max(historyMaxCount, map[index]);
            if(right - left + 1 > historyMaxCount + k) {
                map[chars[left] - 'A']--;
                left++;
            }
        }
        System.out.println(3/2);
        return right - left;
    }

}
