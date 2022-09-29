class Solution {
     public int findClosestElementToX(int[] arr, int x) {
    
        int l = 0;
        int h = arr.length - 1;
        int mid = 0;
        
        while(l <= h){
            
            mid = l + (h - l) / 2;
            
            if(arr[mid] == x){
                break;
            }
            else if(arr[mid] > x){
                h = mid - 1;
            }
            else{
                l = mid + 1;
            }
            
        }
        
        return mid;
    }
    
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
         List<Integer> result = new ArrayList<>();
        
        // Step 1: Find closest element to x using binary search
        int closest = findClosestElementToX(arr, x);
        
        // Step 2: Our result will lie in (closest - k)th to (closest + k)th index
        // Reason: Either this number will be in result,
        // or it's left k elements or it's right k elements
        int left = ((closest - k) < 0) ? (0) : (closest - k);
        int right = ((closest + k) > arr.length - 1) ? (arr.length - 1) : (closest + k);
        
        // Step 3: Start comparing the absolute difference 
        // of (x - left) & (x - right) and move the left 
        // & right pointers
        while((right - left + 1) != k){
            
            int leftDiff = x - arr[left];
            int rightDiff = arr[right] - x;
            
            if(leftDiff <= rightDiff){
                right--;
            }
            else{
                left++;
            }
        }
        
        // Step 4: Store the eleemtnts in result
        while(left <= right){
            result.add(arr[left]);
            left++;
        }
        
        return result;
        
    }
}