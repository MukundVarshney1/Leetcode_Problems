class Solution {
    public String replaceWords(List<String> dict, String sentence) {
        Trie t=new Trie();
		for(String s:dict) {
			t.insert(s);
		}
		StringBuilder sb=new StringBuilder();
		String[] s=sentence.split(" ");
		for(int i=0;i<s.length;i++) {
			sb.append(t.search(s[i])+" ");
		}
		return sb.toString().trim();
    }
    static class Trie{
	public class Node{
		char ch;
		String isterminal;
		Map<Character,Node> child;
		Node(char ch){
			this.ch=ch;
			child=new HashMap<>();
		}
	}
	private Node root=new Node('*');
	public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++) {
        		char ch=word.charAt(i);
        		if(curr.child.containsKey(ch)) {
        			curr=curr.child.get(ch);
        		}
        		else {
        			Node nn=new Node(ch);
        			curr.child.put(ch, nn);
        			curr=nn;
        		}
        }
        curr.isterminal=word;
    }
	public String search(String word) {
		Node curr=root;
		for(int i=0;i<word.length();i++) {
			char ch=word.charAt(i);
			if(curr.child.containsKey(ch)) {
				curr=curr.child.get(ch);
				if(curr.isterminal!=null) {
					return curr.isterminal;
				}
			}
			else {
				return word;
			}
		}
		return word;
		}
	}
}