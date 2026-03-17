class NumArray {
    int[] st;
    int base;
    public NumArray(int[] nums) {
        st=new int[nums.length*4];
        base=nums.length;
        helper(nums,0,0,nums.length-1);
    }
    
    public void update(int index, int val) {
        up(index,0,val,0,base-1);
    }
    
    public int sumRange(int left, int right) {
        return sum(left,right,0,base-1,0);
    }
    public void helper(int[] nums,int i,int l,int r){
        if(l==r){
            st[i]=nums[l];
            return;
        }
        int mid=l+(r-l)/2;
        helper(nums,2*i+1,l,mid);
        helper(nums,2*i+2,mid+1,r);
        st[i]=st[2*i+1]+st[2*i+2];
    }
    public void up(int idx,int i,int val,int l,int r){
        if(l==r){
            st[i]=val;
            return;
        }
        int mid=l+(r-l)/2;
        if(idx<=mid){
            up(idx,2*i+1,val,l,mid);
        }
        else{
            up(idx,2*i+2,val,mid+1,r);
        }
        st[i]=st[2*i+1]+st[2*i+2];
    }
    public int sum(int left,int right,int l,int r,int i){
        if(r<left ||l>right){
            return 0;
        }
        else if(l>=left && r<=right){
            return st[i];
        }
        int mid=l+(r-l)/2;
        return sum(left,right,l,mid,2*i+1)+sum(left,right,mid+1,r,2*i+2);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */