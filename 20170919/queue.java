public class queue {
    int[] que = new int[7];
   queue(){
       for (int i=0;i<7;i++)
           que[i]=0 ;
   }
   void take(int k,int j){que[k-1]=j;}
}
