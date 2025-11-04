class Solution {
    public static class pair{
        int val;
        int c;
    }
    public int[] findXSum(int[] nums, int k, int x) {
        int[] arr=new int[nums.length-k+1];
        int si=0;
        int[] f=new int[50];
        for(int i=0;i<k;i++){
            f[nums[i]-1]++;
        }
        int ei=k;
        arr[0]=helper(f,x);
        while(si<=ei && ei<nums.length){
            f[nums[si]-1]--;
            f[nums[ei]-1]++;
            si++;
            ei++;
            arr[si]=helper(f,x);
        }
        return arr;
    }
    public static int helper(int[] arr,int x){
        PriorityQueue<pair> pq=new PriorityQueue<>((a,b)->b.val-a.val!=0?b.val-a.val:b.c-a.c);
        for(int i=0;i<arr.length;i++){
            pair p=new pair();
            p.val=arr[i];
            p.c=i+1;
            pq.add(p);
        }
        int sum=0;
        for(int i=0;i<x;i++){
            pair item=pq.poll();
            sum+=(item.val*item.c);
        }
        return sum;
    }
}