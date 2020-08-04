package com.zw;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

  public List<List<Integer>> permute(int[] nums){
      int len = nums.length;
      List<List<Integer>> res = new ArrayList<>();
      if(len == 0){
          return res;
      }
      Deque<Integer> path  =  new ArrayDeque<>();
      boolean []used = new boolean[len];
      dfs(nums,len,0,path,used,res);
      return  res;
  }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
      //递归何时结束? 当层数达到len时，代表每个数起码选了一遍
        if(len == depth){
            res.add(new ArrayList<>(path));
        }
        //本次递归应该干什么？
        //循环遍历每个元素
        for(int i = 0;i < len;i++){
            //判断是否遍历
            if(used[i]){
                continue;
            }
            //添加元素
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth+1, path, used, res);
            //递归结束后应该回溯 恢复之前状态
            path.removeLast();
            used[i] = false;

        }
    }
}


