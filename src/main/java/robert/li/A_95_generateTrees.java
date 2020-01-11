package robert.li;

import robert.li.common.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 总结：
 * 1。巧妙的分割问题start => i-1; i+1 => end
 * 2。子问题返回的是个列表
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-07
 */
public class A_95_generateTrees {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate_trees(1, n);
    }

    LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> treeNodes = new LinkedList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }

        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> leftNodes = generate_trees(start, i - 1);
            LinkedList<TreeNode> rightNodes = generate_trees(i + 1, end);
            for (TreeNode leftNode : leftNodes) {
                for (TreeNode rightNode : rightNodes) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftNode;
                    treeNode.right = rightNode;
                    treeNodes.add(treeNode);
                }
            }
        }
        return treeNodes;
    }

}

