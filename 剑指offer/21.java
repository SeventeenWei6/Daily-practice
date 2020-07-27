class Solution {
//首尾指针
    public int[] exchange(int[] nums) {
        int i = 0;
        int j = nums.length-1;
        while(i < j)
        {
            while(i < j && (nums[i]%2) == 1)  i++;  
            while(i < j && (nums[j]%2) == 0)  j--;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp; 
        }
        return nums;
    }
//快慢指针
 public int[] exchange(int[] nums) {
        int fast = 0;
        int slow = 0;
        while(fast <= nums.length-1){
              if((nums[fast]&1) == 1) {
                  int temp = nums[slow];
                  nums[slow] = nums[fast];
                  nums[fast] = temp;
                  slow++;
              } 
            fast++;               
       }   
        return nums; 
     }
}