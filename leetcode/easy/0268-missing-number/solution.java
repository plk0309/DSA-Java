class Solution {
    public int missingNumber(int[] nums) {
        
            int n=nums.length;
            
           for(int i=0;i<=nums.length;i++){
            boolean f=false;
            for(int j=0;j<nums.length;j++){
                if(nums[j]==i){
                    f=true;
                    break;
                }
               

            }
            if(!f){
                return i;
            }
           }
           return -1;

    }
}