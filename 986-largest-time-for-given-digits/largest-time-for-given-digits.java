class Solution {
    public String largestTimeFromDigits(int[] arr) {
        List<String> ll=new ArrayList<>();
        helper(arr,0,ll,"");
        if(ll.size()==0){
            return "";
        }
        Collections.sort(ll);
        String ss=ll.get(ll.size()-1);
        return ss.substring(0,2)+":"+ss.substring(2);
    }
    public void helper(int[] arr,int val,List<String> ll,String s){
        if(s.compareTo("2359")>0){
            return;
        }
        if(s.length()==3 && s.charAt(2)>'5'){
            return;
        }
        if(val==arr.length){
            ll.add(s);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=-1){
                int x=arr[i];
                arr[i]=-1;
                helper(arr,val+1,ll,s+x);
                arr[i]=x;
            }
        }
    }
}