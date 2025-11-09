class Solution {
    public int longestSubarray(int[] nums) {
        int ei=1;
        int si=1;
        int k=1;
        int c=1;
        int max=1;
        int[] temp=nums.clone();
        while(si<=ei && ei<nums.length){
            if(temp[ei]>=temp[ei-1]){
                c++;
            }
            else if(k>0){
                k--;
                temp[ei]=temp[ei-1];
                c++;
            }
            else{
                while(k!=1 && si<=ei){
                    if(nums[si]<nums[si-1]){
                        temp[si]=nums[si];
                        k++;
                    }
                    c--;
                    si++;
                }
                continue;
            }
            ei++;
            max=Math.max(c,max);
        }
        ei=nums.length-2;
        si=nums.length-2;
        c=1;
        int max2=1;
        k=1;
        temp=nums.clone();
        while(si>=ei && ei>=0){
            if(temp[ei]<=temp[ei+1]){
                c++;
            }
            else if(k>0){
                k--;
                temp[ei]=temp[ei+1];
                c++;
            }
            else{
                while(k!=1 && si>=ei){
                    if(nums[si]>nums[si+1]){
                        temp[si]=nums[si];
                        k++;
                    }
                    c--;
                    si--;
                }
                continue;
            }
            ei--;
            max2=Math.max(c,max2);
        }
        return max>max2?max:max2;
    }
}