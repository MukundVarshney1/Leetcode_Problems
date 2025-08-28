/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,List<pair>> map =new TreeMap<>();
		Queue<pair> q=new LinkedList<>();
		q.add(new pair(root,0,0));
		while(!q.isEmpty()) {
			pair vp=q.poll();
			if(!map.containsKey(vp.v)){
				map.put(vp.v, new ArrayList<>());
			}
			map.get(vp.v).add(vp);
			if(vp.node.left!=null) {
				q.add(new pair(vp.node.left,vp.l+1,vp.v-1));
			}
			if(vp.node.right!=null) {
				q.add(new pair(vp.node.right,vp.l+1,vp.v+1));
			}
		}
		List<List<Integer>> ans=new ArrayList<>();
		for(int key:map.keySet()) {
			List<pair> ll=map.get(key);
			Collections.sort(ll,new Comparator<pair>() {
				@Override
				public int compare(pair o1,pair o2) {
					if(o1.l==o2.l) {
						return o1.node.val-o2.node.val;
					}
					return 0;
				}
			});
			List<Integer> list = new ArrayList<>();
			for(pair item:ll) {
				list.add(item.node.val);
			}
			ans.add(list);
		}
        return ans;
    }
    static class pair{
		TreeNode node;
		int l;  //row
		int v;  //col
		public pair(TreeNode node,int lt,int vt) {
			this.node=node;
			this.l=lt;
			this.v=vt;
		}
	}
}