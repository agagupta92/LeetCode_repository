class Solution {
    public void nextPermutation(int[] nums) {
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){   // here we get the peak point
                Arrays.sort(nums,i,nums.length); // we will sort all from peak point to end.
                for(int j=i;j<nums.length;j++){  //let us suppose input arr=[5,4,7,5,3,2] here peak point is 7. now we will sort from 7 to 2.
                    if(nums[j]>nums[i-1]){ // after sort arr=[5,4,2,3,5,7]. inside loop we check which is greater than before peak(i.e.4). here in above arr 5>4. so we replace 5with 4.
                        int temp=nums[j]; // result arr=[5,5,2,3,4,7]
                        nums[j]=nums[i-1];
                        nums[i-1]=temp;
                        break;
                    }
                }
                break;
            }else if(i==1){// arr=[4,3,2,1].here no peak point so we simplly sort complete arr. result arr=[1,2,3,4]
                Arrays.sort(nums);
            }
        }
    }
        
        
}