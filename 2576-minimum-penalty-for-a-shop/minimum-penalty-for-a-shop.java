class Solution {
    public int bestClosingTime(String customers) {
        int noofyes=0;
        for(int i=0;i<customers.length();i++){
            if(customers.charAt(i)=='Y'){
                noofyes++;
            }
        }
        int ans=0;
        int cmin=noofyes;
        int noofno=0;
        for(int i=0;i<customers.length();i++){
            if(noofyes+noofno<cmin){
                ans=i;
                cmin=noofyes+noofno;
            }
            if(customers.charAt(i)=='Y'){
                noofyes--;
            }
            else{
                noofno++;
            }
        }
        return noofyes+noofno<cmin?customers.length():ans;
    }
}