class Solution {
    public boolean isNumber(String s) {
        if(s == null || s.length()==0)  return false;
        boolean preDot = false;
        boolean preNumber = false;
        boolean preEore = false;
        char[] str = s.trim().toCharArray();
        for(int i = 0; i < str.length;i++){
            if(str[i] >='0' && str[i] <= '9'){
                preNumber = true;
            }else if(str[i] == '.'){
                if(preEore || preDot){
                    return false;
                }
                preDot = true;
            }else if(str[i] == 'e'||str[i] == 'E'){
                //e之前不能出现e，必须出现数
                if(preEore || !preNumber){
                    return false;
                }
                preEore = true;
                preNumber = false;//重置numSeen，排除123e或者123e+的情况,确保e之后也出现数
            }else if(str[i] == '-' || str[i] == '+'){
                //+-出现在0位置或者e/E的后面第一个位置才是合法的
                if(i != 0 && str[i-1] != 'e' && str[i-1] != 'E'){
                    return false;
                }
            }else{//其他不合法字符
                return false;
            }
        }
          return preNumber;
    }
}