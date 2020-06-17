package robert.li.bsolution;

import robert.li.common.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-16
 */
public class B_297_serialize {
    public static void main(String[] args) {
        B_297_serialize b_297_serialize = new B_297_serialize();
        String serialize = b_297_serialize.serialize(null);
        System.out.println(serialize);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll == null) {
                res.add(null);
            } else {
                res.add(poll.val);
                queue.add(poll.left);
                queue.add(poll.right);
            }

        }
        return res.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.length() == 0) {
            return null;
        }
        String[] preStr = data.substring(1, data.length() - 1).split(",");
        Integer[] bfsOrder = new Integer[preStr.length];
        for (int i = 0; i < preStr.length; i++) {
            if (preStr[i].trim().equals("null")) {
                bfsOrder[i] = null;
            } else {
                bfsOrder[i] = Integer.parseInt(preStr[i].trim());
            }
        }
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode node = new TreeNode(bfsOrder[0]);
        queue.add(node);
        int cur = 1;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (bfsOrder[cur] != null) {
                poll.left = new TreeNode(bfsOrder[cur]);
                queue.add(poll.left);
            }
            cur++;
            if (bfsOrder[cur] != null) {
                poll.right = new TreeNode(bfsOrder[cur]);
                queue.add(poll.right);
            }
            cur++;
        }
        return node;
    }
}
