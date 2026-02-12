class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Trie t=new Trie();
		int[] ans=new int[queries.length];
		Arrays.sort(nums);
		int[][] q=new int[queries.length][3];
		for(int i=0;i<q.length;i++) {
			q[i][0]=queries[i][0];
			q[i][1]=queries[i][1];
			q[i][2]=i;
		}
		Arrays.sort(q,(x,y)->x[1]-y[1]);
		int c=0;
		for(int i=0;i<q.length;i++) {
			while(c<nums.length && nums[c]<=q[i][1]) {
				t.add(nums[c++]);
			}
			if(c==0) {
				ans[q[i][2]]=-1;
				continue;
			}
			ans[q[i][2]]=t.getMaxZor(q[i][0]);
		}
        return ans;
    }
    static class Trie{
		class Node{
			Node zero;
			Node one;
		}
		private Node root=new Node();
		public void add(int val) {
			Node curr=root;
			for(int i=31;i>=0;i--) {
				int bit=val & (1<<i);
				if(bit==0) {
					if(curr.zero!=null) {
						curr=curr.zero;
					}
					else {
						Node nn=new Node();
						curr.zero=nn;
						curr=nn;
					}
				}
				else {
					if(curr.one!=null) {
						curr=curr.one;
					}
					else {
						Node nn=new Node();
						curr.one=nn;
						curr=nn;
					}
				}
			}
		}
		public int getMaxZor(int val) {
			int ans=0;
			Node curr=root;
			for(int i=31;i>=0;i--) {
				int bit=val &(1<<i);
				if(bit==0) {
					if(curr.one!=null) {
						ans=ans | (1<<i);
						curr=curr.one;
					}
					else {
						curr=curr.zero;
					}
				}
				else {
					if(curr.zero!=null) {
						ans=ans | (1<<i);
						curr=curr.zero;
					}
					else {
						curr=curr.one;
					}
				}
			}
			return ans;
		}
		
	}
}