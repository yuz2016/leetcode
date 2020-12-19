package robert.li.asolution;

import java.util.Arrays;
import java.util.Comparator;

public class A_1024_videoStitching {
    public static void main(String[] args) {
        int[][] a = new int[][]{
                {0,2},{4,6},{8,10},{1,9},{1,5},{5,9}
        };
        A_1024_videoStitching a_1024_videoStitching = new A_1024_videoStitching();
        a_1024_videoStitching.videoStitching(a, 10);
    }

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, Comparator.comparingInt(o -> o[0]));
        int max = 0;
        int nextMax = 0;
        int i = 0;
        // 初始状态
        while(clips[i][0] == 0) {
            int end = clips[i][1];
            max = Math.max(max, end);
            i++;
        }
        int count = 1;
        nextMax = max;
        while(i < clips.length) {
            if(max >= T) {
                return count;
            }
            int start = clips[i][0];
            int end = clips[i][1];
            if(start <= max) {
                nextMax = Math.max(nextMax, end);
                i++;
            } else {
                if(nextMax < start) {
                    break;
                }
                // 开启新一轮
                count++;
                max = nextMax;
            }
        }
        if(nextMax >= T) {
            return count + 1;
        } else return -1;
    }
}
