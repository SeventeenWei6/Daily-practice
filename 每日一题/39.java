class Solution {
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(candidates == null || len <0){
            return   res;
        }
        Arrays.sort(candidates);

        dfs(len,candidates,target,0,0,new ArrayDeque<>(),res);
        return  res;
    }

    private void dfs(int len,int []candidates, int target, int sum,int begin, ArrayDeque<Integer> path, List<List<Integer>> res) {
        if(sum == target){
            res.add(new ArrayList<Integer>(path));
            return;
        }
        for(int i = begin;i < len;i++){

            if(candidates[i] +sum > target){
                break;
            }
            path.addLast(candidates[i]);
            dfs(len,candidates,target,sum+candidates[i],i,path,res);
            path.removeLast();
        }
    }

}