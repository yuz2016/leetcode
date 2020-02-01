package robert.li;

import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-31
 */
public class A_655_printTree {

    public List<List<String>> printTree(TreeNode root) {
        int height = getHeight(root);
        int width = (1 << height) - 1;
        List<List<String>> lists = generateLists(height, width);
        helper(root, lists, 0, 0, width - 1);
        return lists;
    }

    void helper(TreeNode root, List<List<String>> lists, int height, int start, int end) {
        if(root == null) return;
        int medium = (start + end) / 2;
        List<String> strings = lists.get(height);
        strings.set(medium, Integer.toString(root.val));
        helper(root.left, lists, height + 1, start, medium - 1);
        helper(root.right, lists, height + 1, medium + 1, end);
    }

    private List<List<String>> generateLists(int height, int width) {
        List<List<String>> lists = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            List<String> strings = new ArrayList<>(width);
            for (int j = 0; j < width; j++) {
                strings.add("");
            }
            lists.add(strings);
        }
        return lists;
    }

    int getHeight(TreeNode root) {
        if(root == null) return 0;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        System.out.println(1 << 10 -1);
        int height = 4;
        int width = 5;
        List<List<String>> lists = new ArrayList<>(height);
        for (int i = 0; i < height; i++) {
            List<String> strings = new ArrayList<>(width);
            for (int j = 0; j < width; j++) {
                strings.add("");
            }
            lists.add(strings);
        }
        System.out.println(lists);
        System.out.println(lists.size());
    }
}
