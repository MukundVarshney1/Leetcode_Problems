class Solution {
    public List<String> validateCoupons(String[] a, String[] b, boolean[] c) {
        List<Pair> ll=new ArrayList<>();
        for(int i=0;i<a.length;i++){
            if(helper1(a[i]) && helper2(b[i]) && helper3(c[i])){
                ll.add(new Pair(a[i],b[i]));
            }
        }
        Collections.sort(ll,(x,y)->x.b.compareTo(y.b)!=0?x.b.compareTo(y.b):x.a.compareTo(y.a));
        List<String> ans=new ArrayList<>();
        for(int i=0;i<ll.size();i++){
            ans.add(ll.get(i).a);
        }
        return ans;
    }
    public boolean helper1(String s){
        if(s.length()==0){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if((s.charAt(i)<=57 && s.charAt(i)>=48) || (s.charAt(i)<=90 && s.charAt(i)>=65) || (s.charAt(i)<=122 && s.charAt(i)>=97) || s.charAt(i)=='_'){
                continue;
            }
            return false;
        }
        return true;
    }
    public boolean helper2(String s){
        if(s.equals("electronics") || s.equals("grocery") || s.equals("pharmacy") || s.equals("restaurant")){
            return true;
        }
        return false;
    }
    public boolean helper3(boolean a){
        return a==true;
    }
    public class Pair{
        String a;
        String b;
        Pair(String a,String b){
            this.a=a;
            this.b=b;
        }
    }
}