package robert.li;

import robert.li.common.TreeNode;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-20
 */
public class A_297_serialize {
    String reserialize(TreeNode root, String s) {
        if(root == null) {
            s = s + "null,";
        } else {
            s = s + (root.val) + ",";
            s = reserialize(root.left, s);
            s = reserialize(root.right, s);
        }
        return s;
    }

    TreeNode redeserialize(List<String> strings) {
        if(strings.get(0).equals("null")) {
            strings.remove(0);
            return null;
        } else {
            int i = Integer.parseInt(strings.get(0));
            TreeNode node = new TreeNode(i);
            strings.remove(0);
            node.left = redeserialize(strings);
            node.right = redeserialize(strings);
            return node;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return reserialize(root, "");
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> strings = new LinkedList<>(Arrays.asList(data.split(",")));
        return redeserialize(strings);
    }

}
