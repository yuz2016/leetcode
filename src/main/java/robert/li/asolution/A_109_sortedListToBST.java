package robert.li.asolution;

import robert.li.common.ListNode;
import robert.li.common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class A_109_sortedListToBST {

    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        TreeNode helper = helper(list, 0, list.size() - 1);
        return helper;
    }

    TreeNode helper(List<Integer> list, int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode treeNode = new TreeNode(list.get(mid));
        treeNode.left = helper(list, start, mid - 1);
        treeNode.right = helper(list, mid + 1, end);
        return treeNode;
    }


}
