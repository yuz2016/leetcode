package robert.li.contest;

public class C_5511_numSpecial {
    public int numSpecial(int[][] mat) {
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            int index = -1;
            boolean more = false;
            for (int j = 0; j < mat[i].length; j++) {
                if(mat[i][j] == 1) {
                    if(index == -1) {
                        index = j;
                    } else {
                        more = true;
                    }
                }
            }
            if(!more && index != -1) {
                boolean isMore = false;
                for(int y = 0; y < mat.length; y++) {
                    if(y != i && mat[y][index] == 1) {
                        isMore = true;
                        break;
                    }
                }
                if(!isMore) {
                    count++;
                }
            }
        }
        return count;
    }
}
