package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-01-14
 */
public class B_8_TreeNodeRefTest {

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        setTreeNode(a);
        System.out.println(a.val);
    }

    /**
     * a 指向node3
     * node一开始指向node3
     * 后来node指向node2
     * a仍然指向node3
     * @param node
     */
    static void setTreeNode(TreeNode node) {
        if(node.val == 3) {
            node = new TreeNode(2);
        }
    }
}
