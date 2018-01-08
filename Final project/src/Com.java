import java.util.ArrayList;

interface Compare{
    public void sort();}

public class Com implements Compare {
    public Pixel [] pixels=new Pixel[4];
   ArrayList<Pixel>pixels2=new ArrayList<>();
    public int [] array={10,10,10,10};

    public Com(Pixel a,Pixel b, Pixel c,Pixel d) {
      pixels2.add(a);pixels2.add(b);pixels2.add(c);pixels2.add(d);
        for (int i = 0; i <pixels2.size() ; i++) {
        if (!pixels2.get(i).canhold)
            pixels2.remove(i);
        }
        for (int i = 0; i <pixels2.size() ; i++) {
            pixels[i]=pixels2.get(i);
        }
        for (int i = 0; i <pixels2.size() ; i++) {
            array[i]=pixels[i].getHard();
        }
    }


    public void sort(){
        for(int i=0;i<array.length;i++)
        {
            for(int j=0;j<array.length-i-1;j++)
            if(array[j]>array[j+1])
            {int temp=array[j]; Pixel temp2=pixels[j];
                array[j]=array[j+1];pixels[j]=pixels[j+1];
                array[j+1]=temp;pixels[j+1]=temp2;}
        }
        for(int i=0;i<array.length;i++)
        {

        }

    }

    public Pixel getbynum(int a){

           return pixels[a];
    }



}
