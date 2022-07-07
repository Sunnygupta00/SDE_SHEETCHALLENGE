========================================USING TWO STACK ====================================
  =====>>>>LOGIC: USING SECOND STACK FOR MAKING INSERTED ELEMENT AS LAST INSERTED ELEMENT IN STACK ONE 
class MyQueue {
   Stack<Integer>one=new Stack<>();
    Stack<Integer>two=new Stack<>();
    public MyQueue() {
        
    }
----------------------------------------------------------------------------------------------------------------------------------    
    public void push(int x) {
        while(one.size()>0){
            two.push(one.pop()); /// FIRST TRANSFERING ALL ELEMENT IN TWO
        }
        two.push(x);          // THEN ADD X ( ABHI X PEEK HAI TOH FIRST INSERTED ELEMENT KO PEEK BANANE KE LIYE FIRSE SHIFT KARNA PADEGA)
        while(two.size()>0){
            one.push(two.pop()); // transfer again to make element as last inserted element 
        }
    
    }
----------------------------------------------------------------------------------------------------------------------------------    
    public int pop() {
      return one.pop();    
    }
----------------------------------------------------------------------------------------------------------------------------------    
    public int peek() {
     return one.peek();    
    }
----------------------------------------------------------------------------------------------------------------------------------    
    public boolean empty() {
      return one.size()==0;    
    }
----------------------------------------------------------------------------------------------------------------------------------
}
========================================USING TWO STACK ====================================
========================================BUT BETTER TIME COMPLEXITY =========================
  class MyQueue {
   Stack<Integer>input=new Stack<>();
   Stack<Integer>output=new Stack<>();
    public MyQueue() {
        
    }
    
    public void push(int x) { //O(1) TO PUSH 
        input.push(x);
    }
    
    public int pop() {        /// WE ARE NOT ALWAYS SHIFTING THAT'S WHY IT WILL TAKE AMOTISED O(1) TIME COMPLEXITY 
       if(output.size()>0){
           return output.pop();
       }else{
           while(input.size()>0){
               output.push(input.pop());
           }
           return output.pop();           
       }    
    }
    
    public int peek() {  /// WE ARE NOT ALWAYS SHIFTING THAT'S WHY IT WILL TAKE AMOTISED O(1) TIME COMPLEXITY 
      if(output.size()>0){
           return output.peek();
       }else{
           while(input.size()>0){
               output.push(input.pop());
           }
           return output.peek();           
       }        
    }
    
    public boolean empty() {
      return input.size()==0 && output.size()==0;    
    }
}

=============================================================================================================
  
  
  
  
  
  
  
  

