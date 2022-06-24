https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1#

class Meet{ 
    int start;
    int end;
    int pos;
    Meet(int x,int y,int z){
        start=x;
        end=y;
        pos=z;
    }
}
// COMPARATOR IS USED TO COMPARE MULTIPLE OBJECTS
class CompareMeet implements Comparator<Meet>{
    @Override
    public int compare(Meet m1, Meet m2){
        if(m1.end<m2.end){         /// COMPARING BOTH ENDS  IF -1 MEANS SMALL
            return -1; 
        }else if (m1.end>m2.end){  // COMPARING BOTH ENDS  IF 1 MEANS GREATER
            return 1;
        }else if(m1.pos<m2.pos){    // IF BOTH ENDS ARE EQUAL WE WILL COMPARE THEM ACCORDING TO THEIR POSITION
            return -1;
        }else {
            return 1;
        }
    }
    
}
class Solution 
{
    
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<Meet>arr=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr.add(new Meet(start[i],end[i],i+1));
        }
        Collections.sort(arr,new CompareMeet()); // SORTED ACCORING TO END PTR
        int ans=1;
        int timeLIMIT=arr.get(0).end;                 // TIME LIMIT
        for(int i=1;i<n;i++){
            if(arr.get(i).start>timeLIMIT){
                ans++;
                timeLIMIT=arr.get(i).end;
            }
        }
        return ans;
    }
}
