=================================================================================================
=================================== USING ONE STACK O(1) MINIMUM ELEMENT  =================================>>
=================================================================================================
  ArrayDeque<Node>stack=new ArrayDeque<>();
    class Node{
        int val;
        int min;
        Node(int x,int y){
            val=x;
            min=y; // we are just maintaining the minimum element for each value
        }
    }
    public MinStack() {
        
    }
    
    public void push(int val) {
       if(stack.isEmpty()){
           stack.push(new Node(val,val));
       }else{
           stack.push(new Node(val,Math.min(stack.peek().min,val)));// taking minimum from peek and current;
       }    
    }
    
    public void pop() {
      if(stack.isEmpty()){
          return;
      }
        stack.pop();
    }
    
    public int top() {
        return stack.isEmpty() ? -1 : stack.peek().val;
    }
    
    public int getMin() {
       return stack.isEmpty() ? -1 : stack.peek().min;       
    }
}

=================================================================================================
============================= (BRUTE FORCE ) USING TWO STACK O(1) MINIMUM ELEMENT  =====================>>
=================================================================================================
  class MinStack {

    private Deque<Integer>stack=new ArrayDeque<>();
    private Deque<Integer>minStack=new ArrayDeque<>();
    public MinStack() {
        
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.size()==0 || val<=getMin()){ // COMPARING VALUE WITH MIN STACK
            minStack.push(val);
        }
    }
    
    public void pop() {
        if(minStack.size()>0 && getMin()==stack.peek()){      // IF BOTH PEEK ARE SAME THEN POP IT
            minStack.pop(); 
        }
        stack.pop();
    }
    
    public int top() {
       return stack.size()>0 ? stack.peek() : -1 ;
    }
    
    public int getMin() {
         return minStack.size()>0 ? minStack.peek() : -1 ;    
    }
}

