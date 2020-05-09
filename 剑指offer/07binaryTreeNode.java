/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    HashMap<Integer,Integer> map = new HashMap<>();
    int tmp[];
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        tmp = preorder;
        for(int i = 0;i<inorder.length;i++)
        {
            map.put(inorder[i],i);
        }
       
        return  digui(0,0,inorder.length-1);
    }
     TreeNode digui(int prerootIndex,int inleft,int inright)
     {

         if(inleft > inright)
         {
             return null;
         }
         int i = map.get(tmp[prerootIndex]);
         TreeNode root =new TreeNode(tmp[prerootIndex]);
         root.left = digui(prerootIndex+1,inleft,i-1);
         root.right = digui(prerootIndex+i-inleft+1,i+1,inright);
         return root;
     }
}