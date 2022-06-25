//https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1#
double fractionalKnapsack(int W, Item arr[], int n) 
    {
        // Your code here
        Arrays.sort(arr,(a,b)->(b.value*a.weight)-(b.weight*a.value));
        double ans=0.0;
        for(Item i: arr){
           // System.out.println(i.value+" "+i.weight);
        }
        for(int i=0;i<n;i++){
            if(arr[i].weight<=W){
                W-=arr[i].weight;
                ans+=arr[i].value;
            }else{
               // System.out.println(W);
                double ratio=(double)W/(double)arr[i].weight;
               // System.out.println(ratio);
                W-=W;
                ans+=(ratio)*arr[i].value;
                break;
            }
        }
        return ans;
    }
