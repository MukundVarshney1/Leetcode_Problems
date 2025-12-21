class Solution {
    public boolean isLongPressedName(String name, String typed) {
      if(name.length()>typed.length())return false;
      if(name.charAt(0)!=typed.charAt(0))return false;
      int a=1;
      int b=1;
      while(b<typed.length()){
        if(a<name.length()&&name.charAt(a)==typed.charAt(b)){
           a++;
           b++;  
        }
        else if(typed.charAt(b)==typed.charAt(b-1)){
            b++;
        }
        else{
            return false;
        }
      }
        return a==name.length();
    }
}