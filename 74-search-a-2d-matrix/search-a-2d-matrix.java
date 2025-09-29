class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int lo=0;
        int hi=matrix.length-1;
        while(lo<=hi){
            int mid=(lo+hi)/2;
            if(matrix[mid][0]<=target && target<=matrix[mid][matrix[0].length-1]){
                int lo1=0;
                int hi1=matrix[0].length-1;
                while(lo1<=hi1){
                    int mid1=(lo1+hi1)/2;
                    if(matrix[mid][mid1]==target){
                        return true;
                    }
                    else if(matrix[mid][mid1]>target){
                        hi1=mid1-1;
                    }
                    else{
                        lo1=mid1+1;
                    } 
                }
                return false;
            }
            else if(matrix[mid][0]>target){
                hi=mid-1;
            }
            else{
                lo=mid+1;
            }
        }
        return false;
    }
}