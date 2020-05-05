package robert.li.asolution;

import robert.li.common.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-22
 */
public class A_449_Codec {

    String rserialize(TreeNode root) {
        if(root == null) {
            return "null,";
        } else {
            String s = String.valueOf(root.val) + ",";
            s += rserialize(root.left);
            s += rserialize(root.right);
            return s;
        }
    }

    TreeNode rdeserialize(List<String> strings) {
        if(strings.size() > 0) {
            String s = strings.get(0);
            if(s.equals("null")) {
                strings.remove(0);
                return null;
            } else {
                int i = Integer.parseInt(s);
                TreeNode node = new TreeNode(i);
                strings.remove(0);
                node.left = rdeserialize(strings);
                node.right = rdeserialize(strings);
                return node;
            }
        }
        return null;
    }



    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> strings = new LinkedList<>(Arrays.asList(data.split(",")));
        TreeNode rdeserialize = rdeserialize(strings);
        return rdeserialize;
    }

}
