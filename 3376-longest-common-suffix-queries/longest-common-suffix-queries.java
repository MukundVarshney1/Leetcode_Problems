class Solution {
    public class Node{
		char ch;
		boolean isterminal;
        int idx;
        int size;
		Map<Character,Node> child;
		public Node(char ch,int idx,int size) {
			this.ch=ch;
			child=new HashMap<>();
            this.size=size;
            this.idx=idx;
		}
	}
    private Node root=new Node('*',-1,-1);
    public void insert(String word,int idx) {
        Node curr=root;
        for(int i=word.length()-1;i>=0;i--) {
        		char ch=word.charAt(i);
        		if(curr.child.containsKey(ch)) {
        			curr=curr.child.get(ch);
                    if(curr.size>word.length()){
                        curr.size=word.length();
                        curr.idx=idx;
                    }
        		}
        		else {
        			Node nn=new Node(ch,idx,word.length());
        			curr.child.put(ch, nn);
        			curr=nn;
        		}
        }
        curr.isterminal=true;
    }
    public int startsWith(String prefix) {
		Node curr=root;
		for(int i=prefix.length()-1;i>=0;i--) {
			char ch=prefix.charAt(i);
			if(!curr.child.containsKey(ch)) {
				return curr.idx;
			}
			curr=curr.child.get(ch);
		}
		return curr.idx;
    }
    public int[] stringIndices(String[] s, String[] w) {
        int[] ans=new int[w.length];
        int c=s[0].length();
        int idx=0;
        for(int i=0;i<s.length;i++){
            insert(s[i],i);
            if(s[i].length()<c){
                c=s[i].length();
                idx=i;
            }
        }
        for(int i=0;i<w.length;i++){
            int a=startsWith(w[i]);
            ans[i]=a==-1?idx:a;
        }
        return ans;
    }
}