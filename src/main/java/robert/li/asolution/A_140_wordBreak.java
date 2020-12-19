package robert.li.asolution;

import java.util.*;

public class A_140_wordBreak {
    public static void main(String[] args) {
        A_140_wordBreak a_140_wordBreak = new A_140_wordBreak();
        a_140_wordBreak.wordBreak("catsanddog", Arrays.asList("cat", "cats", "and", "sand", "dog"));
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        int len = s.length();

        // 第 1 步：动态规划计算是否有解
        // dp[i] 表示「长度」为 i 的 s 前缀子串可以拆分成 wordDict 中的单词
        // 长度包括 0 ，因此状态数组的长度为 len + 1
        boolean[] dp = new boolean[len + 1];
        // 0 这个值需要被后面的状态值参考，如果一个单词正好在 wordDict 中，dp[0] 设置成 true 是合理的
        dp[0] = true;

        for (int right = 1; right <= len; right++) {
            // 如果单词集合中的单词长度都不长，从后向前遍历是更快的
            for (int left = right - 1; left >= 0; left--) {
                // substring 不截取 s[right]，dp[left] 的结果不包含 s[left]
                if (wordSet.contains(s.substring(left, right)) && dp[left]) {
                    dp[right] = true;
                    // 这个 break 很重要，一旦得到 dp[right] = True ，不必再计算下去
                    break;
                }
            }
        }
        List<String> res = new ArrayList<>();
        if (dp[len]) {
            List<String> tmp = new ArrayList<>();
            dfs(s, 0, res, wordDict, tmp);
        }
        return res;
    }

    private void dfs(String s, int start, List<String> res, List<String> wordDict, List<String> tmp) {
        if (start == s.length()) {
            res.add(join(tmp));
            return;
        }
        for (int i = 0; i < wordDict.size(); i++) {
            int length = wordDict.get(i).length();
            if (start + length > s.length()) {
                continue;
            }
            String substring = s.substring(start, start + length);
            if (!substring.equals(wordDict.get(i))) {
                continue;
            }
            tmp.add(wordDict.get(i));
            dfs(s, start + length, res, wordDict, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    String join(List<String> tmp) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < tmp.size(); i++) {
            if (i != 0) {
                s.append(" ");
            }
            s.append(tmp.get(i));
        }
        return s.toString();
    }

}
