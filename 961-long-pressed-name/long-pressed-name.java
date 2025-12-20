class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int k=0;
        for(int i=0;i<name.length();i++){
            int c=0;
            for(int j=i;j<name.length();j++){
                if(name.charAt(i)!=name.charAt(j)){
                    i=j-1;
                    break;
                }
                c++;
            }
            int cc=0;
            for(int j=k;j<typed.length();j++){
                if(name.charAt(i)!=typed.charAt(k)){
                    return false;
                }
                if(typed.charAt(k)!=typed.charAt(j)){
                    k=j;
                    break;
                }
                cc++;
            }
            if(cc<c){
                return false;
            }
        }
        return name.charAt(name.length()-1)==typed.charAt(k);
    }
}