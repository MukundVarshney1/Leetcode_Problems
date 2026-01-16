class Solution {
    //	optimal O(log(min(m,n)))
	public static double findMedianSortedArrays(int[] nums1,int[] nums2) {
		int n=nums1.length;
		int m=nums2.length;
		if(n>m) {
			return findMedianSortedArrays(nums2,nums1);
		}
		int lo=0;
		int hi=n;
		while(lo<=hi) {
			int mid=(lo+hi)/2; // partition in nums1
			int ypartition=(n+m+1)/2-mid;
			int xmin=mid==0?Integer.MIN_VALUE:nums1[mid-1];// the smaller element in x partition
			int xmax=mid>n-1?Integer.MAX_VALUE:nums1[mid]; // the bigger value in x partition
			
			
			int ymin=ypartition==0?Integer.MIN_VALUE:nums2[ypartition-1];// the smaller element in y partition
			int ymax=ypartition>m-1?Integer.MAX_VALUE:nums2[ypartition];// the bigger value in y partition
			if(xmin<=ymax && ymin<=xmax) { // if we partition x than  the largest in left of x must be less than the smaller in y partition in right and viceverse
				if((n+m)%2==0) {
					return (double)(Math.max(xmin, ymin)+Math.min(xmax,ymax))/2;
				}
				else {
					return (double)Math.max(xmin, ymin);
				}
			}
			else if(xmin>ymax) {
				hi=mid-1;
			}
			else {
				lo=mid+1;
			}
		}
		return -1;
	}
}