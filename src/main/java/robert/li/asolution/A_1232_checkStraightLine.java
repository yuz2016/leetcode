package robert.li.asolution;

public class A_1232_checkStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        int length = coordinates.length;
        if(length <= 2) return true;
        int y1y0 = coordinates[1][1] - coordinates[0][1];
        int x1x0 = coordinates[1][0] - coordinates[0][0];
        for (int i = 2; i < length; i++) {
            int tmpy = (coordinates[i][1] - coordinates[0][1]) * x1x0;
            int tmpx = (coordinates[i][0] - coordinates[0][0]) * y1y0;
            if(tmpy != tmpx) return false;
        }
        return true;
    }
}
