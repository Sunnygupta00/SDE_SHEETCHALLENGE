
ALGORITHM FOR GREEDY

GREEDY( ARR, N){
  X->SELECT(ARR)
  ANS->0
  FOR(I: 0->N){
   IF (FEASIBLE(X)){
    ANS+=X;
    }
    RETURN ANS;
  }
 } 
