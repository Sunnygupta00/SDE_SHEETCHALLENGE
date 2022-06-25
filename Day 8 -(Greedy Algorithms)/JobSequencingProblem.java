  int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(a,b)->b.profit-a.profit);// sorting in descending order
        int maxDead=0;// counting no. of deadlines
        for(Job j: arr)maxDead=Math.max(maxDead,j.deadline);
        int res[]=new int [maxDead+1];// we will store maxdeadlines
        Arrays.fill(res,-1);// intially no job is selected;
        int profit=0;
        int countJobs=0;
        for(int i=0;i<n;++i){ 
            for(int j=arr[i].deadline; j>0;j--){ // we will finding vacant shedule 
                if(res[j]==-1){
                    res[j]=i;  
                    countJobs++;
                    profit+=arr[i].profit;
                    break;// once profit is added break and search for new profit
                }
            }
        }
        return new int[]{countJobs,profit};
    }
