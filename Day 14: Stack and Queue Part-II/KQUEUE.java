
public class Main
{
	public static void main(String[] args) {
	  kQueue q=new kQueue(3,6);
	  q.offer(1,1);
	  q.offer(2,1);
	  q.offer(3,1);
	  q.offer(4,1);
	  q.offer(5,1);
	  q.offer(6,1);
	  
	  System.out.println(q.poll(1));System.out.println(q.poll(1));
	  System.out.println(q.poll(1));System.out.println(q.poll(1));
	  System.out.println(q.poll(1));System.out.println(q.poll(1));
	  
	    
	}
}
class kQueue{
    int arr[];
    int next[];
    int front[];
    int rear[];
    int freeSlot;
    public kQueue(int k,int n){
        arr=new int[n];
        next=new int[n];
        for(int i=0;i<n;i++){
            next[i]=i+1;
        }
        next[n-1]=-1;
        front=new int[k];
        rear=new int[k];
        for(int i=0;i<k;i++){
            front[i]=-1;
            rear[i]=-1;
        }
        freeSlot=0; // INITAIALLY
    }
    public void offer(int item , int k){
        // base case
        if(freeSlot==-1){
            System.out.println("FULL"); return;
        }
        int i=freeSlot;
        freeSlot=next[i];// update 
        if(front[k-1]==-1){// first element;
            front[k-1]=i;
        }else{
            next[rear[k-1]]=i; // else link with prev element
        }
        next[i]=-1; // prev ko -1 kyu ki ye ab occupied hai
        rear[k-1]=i;// jaha push krne wale hai
        arr[i]=item;  /// push kiya :)
    }
    public int poll(int k){
        if(front[k-1]==-1)return-1;
        int index=front[k-1];// poping first element;
        front[k-1]=next[index];
        next[index]=freeSlot;
        freeSlot=index;// is jagha ko bhar do
        return arr[index];
    }
    
}

