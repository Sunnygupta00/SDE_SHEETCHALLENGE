static int findPlatform(int arr[], int dep[], int n)
    {
  
  
  
     //Making a track record that which train is comming and going 
     // if any train comes then we need +1 platform
     // if any train going then we remove the platform--;
     // during this calculate the ans max
        Arrays.sort(arr);
        Arrays.sort(dep);
        int plat=1;
        int ans=1;
        int i=1,j=0;
        while(i<n && j<n){
            if(dep[j]>=arr[i]){
                plat++;
                i++;
            }else{
                plat--; // now we don't need plat form
                j++;
            }
            ans=Math.max(plat,ans);
        }
        return ans;
    }
