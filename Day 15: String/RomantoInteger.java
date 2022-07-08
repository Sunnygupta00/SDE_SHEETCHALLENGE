class Solution {
    public int romanToInt(String s) {
        int n=s.length();
        int nums[]=new int[n];
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            switch(c){
                case 'I':
                    nums[i]=1;
                    break;
                case 'V':
                    nums[i]=5;
                    break;
                case 'X':
                    nums[i]=10;
                    break;
                case 'L':
                    nums[i]=50;
                    break;
                case 'C':
                    nums[i]=100;
                     break;
                case 'D':
                    nums[i]=500;
                     break;
                case 'M':
                    nums[i]=1000;
                     break;
            }
        }
        // AS QUESTION STATES THAT IF IT IS DECREASING MEANS SUBSTRACT ELSE ADD IT :)
        int sum=0;
        for(int i=0;i<n-1;i++){
            if(nums[i]<nums[i+1]){
                sum-=nums[i];
            }else{
                sum+=nums[i];
            }
        }
        return sum + nums[nums.length-1];   
    }
}
