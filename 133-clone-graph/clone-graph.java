/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return null;
        }
        Map<Node,Node> map=new HashMap<>();
        Node clone=new Node(node.val);
        map.put(node,clone);
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node x=q.poll();
            for(Node nbrs:x.neighbors){
                if(map.get(nbrs)==null){
                    Node clone1=new Node(nbrs.val);
                    q.add(nbrs);
                    map.put(nbrs,clone1);
                    map.get(x).neighbors.add(clone1);
                }
                else{
                    map.get(x).neighbors.add(map.get(nbrs));
                }
            }
        }
        return clone;
    }
}