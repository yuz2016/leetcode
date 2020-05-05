package robert.li.asolution;

import javafx.util.Pair;
import robert.li.common.TreeNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/10/24
 */
public class A_104_TreeMaxDepth {

    public static void main(String[] args) {
        new Pair<Integer,Integer>(1,2);
    }

    /**
     * 思路1：遍历所有节点，同时记录深度
     * 发现没存父节点
     * <p>
     * 思路2：队列方法
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        //empty
        if(root == null){
            return 0;
        }

        int max = 1;
        Queue<TreeNode> treeNodes1 = new ArrayDeque<>();
        Queue<TreeNode> treeNodes2 = new ArrayDeque<>();
        treeNodes1.add(root);
        while (true) {
            while (treeNodes1.peek() != null) {
                TreeNode tmp = treeNodes1.poll();
                if (tmp.left != null) {
                    treeNodes2.offer(tmp.left);
                }
                if (tmp.right != null) {
                    treeNodes2.offer(tmp.right);
                }
            }
            if (treeNodes2.peek() != null) {
                max++;
            }else{
                break;
            }
            Queue<TreeNode> temp = treeNodes1;
            treeNodes1 = treeNodes2;
            treeNodes2 = temp;
        }

        return max;
    }

}
