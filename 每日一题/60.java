class Solution {
    public String getPermutation(int n, int k) {
        //计算阶乘数组
        int  []factorial = new int[n + 1];
        factorial[0] = 1;
        for (int i = 1; i <= n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }
        return dfs(n,k,0,new boolean[n],new ArrayList<Integer>(),factorial);

    }
    private String dfs(int n,int k,int depth,boolean used[],List<Integer> path,int []factorial){
        if(depth == n){
            String res ="";
            for (Integer i:path
                 ) {
                res += ""+i;
            }
            return res;
        }
        int ps = factorial[n-1-depth];
        for (int i = 0; i < n ; i++) {
            if (used[i]){
                continue;
            }
            if(ps < k){
                k -= ps;
                continue;
            }
            path.add(i+1);
            used[i] = true;
            return dfs(n,k,depth+1,used,path,factorial);
        }
        return "";
    }
}