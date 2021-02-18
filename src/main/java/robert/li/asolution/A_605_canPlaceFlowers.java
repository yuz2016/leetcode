package robert.li.asolution;

public class A_605_canPlaceFlowers {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if(flowerbed.length == 1) {
            if((flowerbed[0] == 0 && n <= 1) || (flowerbed[0] == 1 && n == 0)) return true;
            else return false;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            if(flowerbed[i] == 1) continue;
            if (i == 0) {
                if(flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else
            if (i == flowerbed.length - 1) {
                if(flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            } else
            if (flowerbed[i] == 0) {
                if(flowerbed[i - 1] == 0 && flowerbed[i + 1] == 0) {
                    flowerbed[i] = 1;
                    n--;
                }
            }
        }
        return n <= 0;
    }
}
