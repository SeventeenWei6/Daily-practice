class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
    int len = nums.length;
    List<List<Integer>> res = new ArrayList<>();
    if(len == 0){
        return res;
    }
    //对数组排序，因为要剪枝所以必须排序
    Arrays.sort(nums);
    //双端队列，存放每一次遍历结果
    Deque<Integer> path = new ArrayDeque<>();
    //用来标记数组中元素是否用过
    boolean used[] = new boolean[len];
    //开始遍历
    dfs(nums,len,0,path,used,res);
    return res;
    }
    private void dfs(int []nums,int len,int depth,Deque<Integer> path,boolean[] used,List<List<Integer>> res){
        //递归何时结束? 当层数达到len时，代表每个数起码选了一遍
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        //本次递归应该干什么？
        //循环遍历每个元素
        for(int i = 0;i < len;i++){
             if (used[i]) {
                continue;
            }
            //剪枝  若当前搜索数字nums[i]和上一次搜索数字nums[i-1]一样 ，并且需要判断是否在同一层!used[i]
            if(i>0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,path,used,res);
            //递归结束后应该回溯 恢复之前状态
            path.removeLast();
            used[i] = false;
        }
    }
}