public class Solution {

   private List<Integer> list;

    public int[] printNumbers(int n) {
        list = new ArrayList<>();
        dfs(n, 0, new StringBuilder());
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(int n, int i, StringBuilder sb) {
        if (i == n) {
            //固定完所有位  由于第一次固定完所有位时 必有0 所以此时清除前置位0
            while (sb.length() != 0 && sb.charAt(0) == '0') {

                sb.deleteCharAt(0);

            }
            if (sb.length() != 0) {

                list.add(Integer.valueOf(sb.toString()));
            }
            return;
        }
        for (int j = 0; j < 10; j++) {
            //开始固定第i位
            sb.append(j);
            //开始固定第i+1位
            dfs(n, i + 1, sb);
            //第i位为j的这种情况已经遍历完，删除j换下一个数字
            if (sb.length() != 0) {
                sb.deleteCharAt(sb.length() - 1);

            }
        }
    }
}