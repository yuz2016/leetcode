package robert.li;

import com.google.common.collect.Lists;
import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2018/12/31
 */
public class A_102_levelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        ArrayList<List<Integer>> lists = new ArrayList<>();
        if(root == null){
            return lists;
        }
        queue.add(root);
        ArrayList<Integer> list0 = new ArrayList<>();
        list0.add(root.val);
        lists.add(list0);
        while(!queue.isEmpty()){
            ArrayList<Integer> tmpList = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode pop = ((LinkedList<TreeNode>) queue).pop();
                if(pop.left!=null){
                    ((LinkedList<TreeNode>) tmp).add(pop.left);
                    tmpList.add(pop.left.val);
                }
                if(pop.right!=null){
                    ((LinkedList<TreeNode>) tmp).add(pop.right);
                    tmpList.add(pop.right.val);
                }
            }
            if(!tmpList.isEmpty()) {
                lists.add(tmpList);
            }
            while(!tmp.isEmpty()){
                ((LinkedList<TreeNode>) queue).add(((LinkedList<TreeNode>) tmp).pop());
            }
        }
        return lists;
    }

    /**
     * 一个队列解决问题，
     * 依靠上个队列的size，判断出队的元素。
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();

        if(root == null) return wrapList;

        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().val);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }
}
