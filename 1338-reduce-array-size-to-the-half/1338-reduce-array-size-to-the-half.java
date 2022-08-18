class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++){
			map.put(arr[i],map.getOrDefault(arr[i],0)+1);
		}

		// Create a Freq Arr. Eg : [7,7,7,3,3,3] so freq[3] will store 2 , so I will make a freq arr where each index represents frequency to a no and freq[i] -> how many times that freq is encountered.
		int [] freqarr=new int[100001];
		for(int key: map.keySet()){
			freqarr[map.get(key)]++; 
		}
		int size=arr.length;int count=0;
		for(int i=freqarr.length-1;i>=0 && size>arr.length/2;){ // traverse array in rev order to greedily choose the max frequency
			if(freqarr[i]==0){
				i--;
			}else{ // keep reducing the size till freq[i]==0 -> use up all high freq elements
				while(freqarr[i]!=0 && size>arr.length/2){
					size-=i;
					freqarr[i]--; 
					count++;
				}
				if(size<=arr.length/2) return count;
				i--;
			}
		}
		return count;
	
    }
}