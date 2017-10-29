public class position {
    private creature holder;
    private int x,y;
    public void setholder(creature holder) {
        this.holder = holder;
        holder.setLocation(this);
    }
    public creature getholder(){
        if (this.holder==null)
            return null;
else
        return this.holder;

    }
    public void printname(){
        if (this.holder==null)
            System.out.print("    ");
        else
        System.out.print(this.holder.getname());
    }
    public void freeholder(){this.holder=null;}
}
