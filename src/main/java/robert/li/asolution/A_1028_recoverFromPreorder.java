package robert.li.asolution;

import robert.li.common.TreeNode;

/**
 * @author robert.li
 * @version v1.0.0
 * @since 2020-06-18
 */
public class A_1028_recoverFromPreorder {

    public static void main(String[] args) {
        String s = "1-2--3--4-5--6--7";
        A_1028_recoverFromPreorder a_1028_recoverFromPreorder = new A_1028_recoverFromPreorder();
        TreeNode node = a_1028_recoverFromPreorder.recoverFromPreorder(s);
        System.out.println(1);
    }
    public TreeNode recoverFromPreorder(String s) {
        if(s.length() == 0) return null;

        char[] chars = s.toCharArray();
        int x = getX(chars, 0);
        int i = Integer.parseInt(s.substring(0, x));
        TreeNode root = new TreeNode(i);
        helper(root, s.substring(x), 1);
        return root;
    }

    void helper(TreeNode p, String s, int level) {
        if(s.length() == 0) return;
        char[] chars = s.toCharArray();
        int left = -1;
        int right = -1;
        for (int i = chars.length - 1; i >= 0;) {
            if(chars[i] == '-') {
                int count = 0;
                int j = i;
                while(j >= 0 && chars[j] == '-') {
                    count++;
                    j--;
                }
                if(count == level) {
                    if(right == -1) {
                        right = i + 1;
                    } else {
                        left = i + 1;
                    }
                }
                i = i - count;
            } else {
                i--;
            }
        }
        if(left != -1) {
            int x = getX(chars, left);
            int i = Integer.parseInt(s.substring(left, x));
            p.left = new TreeNode(i);
            helper(p.left, s.substring(x, right - level), level + 1);

            int y = getX(chars, right);
            int j = Integer.parseInt(s.substring(right, y));
            p.right = new TreeNode(j);
            helper(p.right, s.substring(y), level + 1);
        } else if(right != -1) {
            int y = getX(chars, right);
            int j = Integer.parseInt(s.substring(right, y));
            p.left = new TreeNode(j);
            helper(p.left, s.substring(y), level + 1);
        }
    }

    private int getX(char[] chars, int right) {
        int y = right + 1;
        while (y < chars.length) {
            if (chars[y] == '-') {
                break;
            } else {
                y++;
            }
        }
        return y;
    }
}
