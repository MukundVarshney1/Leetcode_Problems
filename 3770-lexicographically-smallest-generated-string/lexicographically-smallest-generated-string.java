class Solution {
    public static boolean checksame(char[] a,String s,int i){
        for(int j=0;j<s.length();j++){
            if(a[i+j]!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }
    public String generateString(String s1, String s2) {
        int n=s1.length();
        int m=s2.length();
        char[] ans=new char[n+m-1];
        Arrays.fill(ans,'0');
        boolean[] canchange=new boolean[n+m-1];
        for(int i=0;i<n;i++){
            if(s1.charAt(i)=='T'){
                for(int j=0;j<m;j++){
                    if(ans[i+j]=='0' || ans[i+j]==s2.charAt(j)){
                        ans[i+j]=s2.charAt(j);
                    }
                    else{
                        return "";
                    }
                }
            }
        }
        for(int i=0;i<n+m-1;i++){
            if(ans[i]=='0'){
                ans[i]='a';
                canchange[i]=true;
            }    
        }
        for(int i=0;i<n;i++){
            if(s1.charAt(i)=='F'){
                if(checksame(ans,s2,i)){
                    int flag=0;
                    for(int k=i+m-1;k>=i;k--){
                        if(canchange[k]==true){
                            flag=1;
                            ans[k]=(char)(ans[k]+1);
                            break;
                        }
                    }
                    if(flag==0){
                        return "";
                    }
                }
            }
        }
        return new String(ans);
    }
}