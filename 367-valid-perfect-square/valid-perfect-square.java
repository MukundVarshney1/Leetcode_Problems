class Solution {
    public boolean isPerfectSquare(int num) {
        return Checker(num);
    }
    	public static boolean Checker(int n) {
		long lo=0;
		long hi=n;
		while(lo<=hi) {
			long mid=lo+(hi-lo)/2;
			if(mid*mid==n) {
				return true;
			}
			else if(mid*mid>n){
				hi=mid-1;
			}
			else {
				lo=mid+1;
			}
		}
		return false;
	}
}