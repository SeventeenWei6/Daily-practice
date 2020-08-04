class Solution {

    String[] letter_map = {" ","*","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0){
            return new ArrayList<String>();
        }
        //最终输出结果的list
        List<String> res = new ArrayList<>();
        dfs(digits,"",0,res);
        return res;
    }
    private void dfs(String digits,String ans,int depth,List<String> res){
       //递归何时结束？ 当遍历完每一层后结束
        if(digits.length() == depth){
            res.add(ans);
            return;
        }
      //取出对应每一层相对应元素，拼接后传递给下一层
        char tmp = digits.charAt(depth);
        int pos = tmp-'0';
        String str = letter_map[pos];
        for(int i = 0; i< str.length();i++){
            dfs(digits,ans+str.charAt(i),depth+1,res);
        }
    }
}