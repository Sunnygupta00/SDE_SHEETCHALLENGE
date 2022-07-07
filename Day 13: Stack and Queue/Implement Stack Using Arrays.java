=========================================================================================================================
        USING EXCEPTIONS : https://github.com/kunal-kushwaha/DSA-Bootcamp-Java/blob/main/lectures/19-stacks-n-queues/code/src/com/kunal/CustomStack.java
=========================================================================================================================
public class Main
{
	public static void main(String[] args) {
		myStack stack=new myStack(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(3);
		stack.push(3);
		stack.push(3);
		stack.peek();
		stack.print();
		
	}
}
=============================================== STACK USING ARRAY ======================================================
class myStack{
    protected int arr[];   // for storing values
    private int size;      // for capacity
    protected int index;  // to maintain top() and insertion
    public myStack(int size){
        arr=new int[size];
        this.size=size;
        index=-1;
    }
------------------------------------------------------------------------------------------------------------------------------	
    public void push(int x){
        if(index==size-1){
            System.out.println("full hai!");
            return ;
        }
        arr[++index]=x;
    }
------------------------------------------------------------------------------------------------------------------------------	
    public int pop(){
        if(index==-1)return -1; // MEANS EMPTY HAI
        return arr[index--];
    }
------------------------------------------------------------------------------------------------------------------------------	
    public int peek(){
        if(index==-1)return -1;// MEANS EMPTY HAI
        System.out.println(arr[index]);
        return arr[index];
    }
------------------------------------------------------------------------------------------------------------------------------	
    public void print(){
        for(int i=0;i<index;i++){
            System.out.print(i+"->");
        }
        System.out.println();
    }
    
}
------------------------------------------------------------------------------------------------------------------------------
