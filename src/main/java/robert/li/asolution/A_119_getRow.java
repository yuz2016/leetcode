package robert.li.asolution;

import java.util.ArrayList;
import java.util.List;

public class A_119_getRow {
    public static void main(String[] args) {
        A_119_getRow a_119_getRow = new A_119_getRow();
        List<Integer> row = a_119_getRow.getRow(3);
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex == 0) return list;
        list.add(1);
        while(list.size() < rowIndex + 1) {
            int size = list.size();
            for (int i = size - 1; i > 0; i--) {
                list.set(i, list.get(i - 1) + list.get(i));
            }
            list.add(1);
        }
        return list;
    }
}
