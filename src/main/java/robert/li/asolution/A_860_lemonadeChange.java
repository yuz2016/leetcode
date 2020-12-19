package robert.li.asolution;

public class A_860_lemonadeChange {
    public static void main(String[] args) {
        A_860_lemonadeChange a_860_lemonadeChange = new A_860_lemonadeChange();
        a_860_lemonadeChange.lemonadeChange(new int[]{5,5,5,10,20});
    }
    public boolean lemonadeChange(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5) fiveCount++;
            if(bills[i] == 10) tenCount++;
            int backCount = bills[i] - 5;
            while (backCount > 0) {
                if (backCount >= 10 && tenCount > 0) {
                    backCount -= 10;
                    tenCount--;
                } else if (backCount >= 5 && fiveCount > 0) {
                    backCount -= 5;
                    fiveCount--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
