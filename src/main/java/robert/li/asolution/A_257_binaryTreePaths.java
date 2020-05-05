package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-19
 */
public class A_257_binaryTreePaths {
    List<String> strings = new LinkedList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        List<Integer> list = new LinkedList<>();
        helper(root, list);
        return strings;
    }

    void helper(TreeNode root, List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null) {
            generateString(list);
        }
        helper(root.left, list);
        helper(root.right, list);
        list.remove(list.size() - 1);
    }

    void generateString(List<Integer> list) {
        String s = list.get(0).toString();
        for(int i = 1; i < list.size();i++) {
            s = s + "->" + list.get(i);
        }
        strings.add(s);
    }

    class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            LinkedList<String> paths = new LinkedList();
            if (root == null)
                return paths;

            LinkedList<TreeNode> node_stack = new LinkedList();
            LinkedList<String> path_stack = new LinkedList();
            node_stack.add(root);
            path_stack.add(Integer.toString(root.val));
            TreeNode node;
            String path;
            while (!node_stack.isEmpty()) {
                node = node_stack.pollLast();
                path = path_stack.pollLast();
                if ((node.left == null) && (node.right == null))
                    paths.add(path);
                if (node.left != null) {
                    node_stack.add(node.left);
                    path_stack.add(path + "->" + Integer.toString(node.left.val));
                }
                if (node.right != null) {
                    node_stack.add(node.right);
                    path_stack.add(path + "->" + Integer.toString(node.right.val));
                }
            }
            return paths;
        }
    }
}
