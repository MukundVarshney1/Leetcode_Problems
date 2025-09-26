class Solution {
    public int totalFruit(int[] fruits) {
        int[] arr=new int[2];
        arr[0]=-1;
        arr[1]=-1;
        int count_a=0;
        int count_b=0;
        int max_count=0;
        int si=0;
        int ei=0;
    while(si<=ei && ei<fruits.length){
        if(arr[0]==-1 || fruits[ei]==arr[0]){
            arr[0]=fruits[ei];
            count_a++;
        }
        else if(arr[1]==-1 || fruits[ei]==arr[1]){
            arr[1]=fruits[ei];
            count_b++;
        }
        else{
            max_count=Math.max(count_a+count_b,max_count);
            while(si<=ei && count_a>0 && count_b>0){
                if(fruits[si]==arr[0]){
                    count_a--;
                }
                else{
                    count_b--;
                }
                si++;
            }
            if(count_a==0){
                arr[0]=fruits[ei];
                count_a++;
            }
            else{
                arr[1]=fruits[ei];
                count_b++;
            }
        }
        ei++;
    }
    max_count=Math.max(count_a+count_b,max_count);
    return max_count;
    }
}