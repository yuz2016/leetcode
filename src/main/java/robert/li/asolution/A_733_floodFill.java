package robert.li.asolution;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-03-22
 */
public class A_733_floodFill {

    int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int origColor = image[sr][sc];
        if(origColor == newColor) return image;
        fill(image, sr, sc, origColor, newColor);
        return image;
    }

    void fill(int[][] image, int x, int y, int origColor, int newColor) {
        // 出界：超出边界索引
        if (!inArea(image, x, y))
            return;
        // 碰壁：遇到其他颜色，超出 origColor 区域
        if (image[x][y] != origColor)
            return;
        image[x][y] = newColor;
//        System.out.println("x :"+ x + " y :" + y);
        fill(image, x, y + 1, origColor, newColor);

        fill(image, x, y - 1, origColor, newColor);

        fill(image, x - 1, y, origColor, newColor);

        fill(image, x + 1, y, origColor, newColor);
    }

    boolean inArea(int[][] image, int x, int y) {
        return x >= 0 && x < image.length && y >= 0 && y < image[0].length;
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 0, 0}, {0, 1, 1}};
        A_733_floodFill a = new A_733_floodFill();
        a.floodFill(arr, 1, 1, 1);
    }
}