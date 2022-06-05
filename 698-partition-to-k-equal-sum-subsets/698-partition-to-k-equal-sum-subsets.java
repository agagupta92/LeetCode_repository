class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum =0;
        int n = nums.length;
        for(int i=0;i <nums.length;i++){
            sum+=nums[i];
        }
        if(sum %k != 0) return false;
        int target = sum/k;
        
        return canPartitionKSubsets(nums,sum/k,nums.length-1,new int[k]);
    }
    
    public boolean canPartitionKSubsets(int a[],int target,int i,int bucket[]){
        
        //we have taken all the elements
        if(i==-1)
            return true;
        
        //start filling the buckets
        for(int j=0;j<bucket.length;j++){
            
            //can we take this ith element
            if(bucket[j]+a[i]<=target){
            
                //if we take this element
                bucket[j]+=a[i];
                
                //go to next element (in our case go to smallest ele bcz we sorted)
                //if we can fill all buckets then return true
                if(canPartitionKSubsets(a,target,i-1,bucket))
                    return true;
                
                //means we can't fill other buckets if we take ith element so leave this element
                bucket[j]-=a[i];
            
            }
            
            //if our bucket is empty means we have not taken any elements in the buckets
            if(bucket[j]==0)
                break;
        
        }
        
        //all buckets are full but i is pointing to some element (elements still left)
        //or our bucket is empty means we haven't take any element (not valid)
        return false;
    
    }
}