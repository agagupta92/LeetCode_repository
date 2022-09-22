class Solution {
    public String reverseWords(String str) {
        char[] ch = str.toCharArray();
        int j = 0;
        int i = 0;
        for(;i < ch.length ;i++){
            if(ch[i]==' '){
                revers(ch,j,i-1);
                    j=i+1;
            }
        }  
        revers(ch,j,ch.length-1);
        return new String(ch);
    }
        static void revers(char[] str,int i,int j){
       
        while(i<j){
            char tem=str[i];
            str[i]=str[j];
            str[j]=tem;
            i++;
            j--;
        }        
        
    }
}