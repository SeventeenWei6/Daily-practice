class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words  =  word.toCharArray();
        for(int i = 0;i < board.length;i++)
        {
            for(int j = 0;j< board[0].length;j++)
            {
                if(dfs(board,words,i,j,0))  return true;
            }
        }
        return false;
    }
    boolean dfs(char[][]board,char[] word,int i,int j,int k){
        //如果①i或者j越界 ② 未找到字符 返回false
      if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])  return false;
      if(k == word.length-1)  return true;
      char tmp = board[i][j];//标记
      board[i][j] = '/';
      // 根据  dfs  下上右左顺序遍历
      boolean res = dfs(board,word,i+1,j,k+1) || dfs(board,word,i-1,j,k+1) ||  dfs(board,word,i,j+1,k+1) ||  dfs(board,word,i,j-1,k+1);
       board[i][j] = tmp;
       return res;
    }
}