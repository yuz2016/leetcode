package robert.li;

interface MountainArray {
    int get(int index);

    int length();
}

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-04-29
 */
public class A_1095_findInMountainArray {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int start = 0;
        int end = mountainArr.length() - 1;
        int peak = 0;
        // find peak
        while (start <= end) {
            int mid = start + (end - start + 1) / 2;
            int cur = mountainArr.get(mid);
            int left = mid - 1 < 0 ? -1 : mountainArr.get(mid - 1);
            int right = mid + 1 > mountainArr.length() - 1 ? -1 : mountainArr.get(mid + 1);
            if (cur > left && cur < right) {
                start = mid + 1;
            } else if (cur < left && cur > right) {
                end = mid - 1;
            } else {
                peak = mid;
                break;
            }
        }
        start = 0;
        end = mountainArr.length() - 1;
        int fromSortedUpArr = findFromSortedUpArr(start, peak, target, mountainArr);
        if (fromSortedUpArr != -1) {
            return fromSortedUpArr;
        }
        int fromSortedDownArr = findFromSortedDownArr(peak + 1, end, target, mountainArr);
        if (fromSortedDownArr != -1) {
            return fromSortedDownArr;
        }
        return -1;
    }

    private int findFromSortedUpArr(int start, int end, int target, MountainArray mountainArr) {
        while (start <= end) {
            int mid = start + (end - start + 1) / 2;
            int cur = mountainArr.get(mid);
            if (cur == target) {
                return mid;
            }
            if (target > cur) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private int findFromSortedDownArr(int start, int end, int target, MountainArray mountainArr) {
        while (start <= end) {
            int mid = start + (end - start + 1) / 2;
            int cur = mountainArr.get(mid);
            if (cur == target) {
                return mid;
            }
            if (target > cur) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

}
