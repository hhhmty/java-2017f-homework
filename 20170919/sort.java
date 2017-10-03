public class sort {
void bubble(int[] seat,huluwa[] man){
    for (int i=0;i<seat.length-1;i++){
        for (int j=0;j<seat.length-1-i;j++){
            if(seat[j] >seat[j + 1]){
                man[seat[j]-1].swapbyname(j+2);
                man[seat[j+1]-1].swapbyname(j+1);
                int temp = seat[j];
                seat[j] = seat[j + 1];
                seat[j + 1] = temp;
            }
        }
    }
}
void dichotomy(int[] seat,huluwa[] man) {
    int low, high, mid, temp;
    for (int i = 1; i < seat.length; i++) {
        temp = seat[i];
        low = 0;
        high = i - 1;
        while (low <= high) {
            mid = (low + high) / 2;
            if (seat[mid] > temp)
                high = mid - 1;
            else
                low = mid + 1;
        }
        for (int j = i - 1; j >= low; j--) {
            man[seat[j]-1].swapbycolor(j+2);
            seat[j+1] = seat[j];
        }
           seat[high + 1] = temp;
        if(i!=high+1)
        {man[temp-1].swapbycolor(high+2);}
    }
}}
