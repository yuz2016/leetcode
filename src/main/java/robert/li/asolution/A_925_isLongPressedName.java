package robert.li.asolution;

public class A_925_isLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        char[] names = name.toCharArray();
        char[] typeds = typed.toCharArray();
        int i = 0;
        int j = 0;
        while(i < names.length && j < typeds.length) {
            if(names[i] == typeds[j]) {
                i++;
                j++;
            } else {
                if(j > 0 && typeds[j] == typeds[j - 1]) {
                    j++;
                } else {
                    return false;
                }
            }
        }
        if(i != names.length) return false;
        while(j < typeds.length) {
            if(typeds[j] == typeds[j - 1]) {
                j++;
            } else {
                return false;
            }
        }
        return true;
    }
}
