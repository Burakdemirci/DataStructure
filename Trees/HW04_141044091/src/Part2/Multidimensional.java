package Part2;


import java.security.InvalidParameterException;
import java.util.Scanner;

public class Multidimensional implements Comparable<Multidimensional> {

    private int x;
    private int y;
    private int z;

    /**
     * The Coordinate constructor
     * @param count the dimension count
     */
    public Multidimensional(int count) {

        if(count<=0||count>3)
            throw new InvalidParameterException("The count should be in ( 0< count <4 ) this range");
        if(count==1){
           this.y=0;
           this.z=0;
        }
        if(count==2){
            this.z=0;
        }
    }

    /**
     * The Multidimensional constructor get 3 dimension
     * @param x the x axis
     * @param y the y axis
     * @param z the z axis
     */
    public Multidimensional(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    /**
     * Compare x axis
     * @param c the Multidimensional object
     * @return integer
     */
    public int compareToX(Multidimensional c){
        return this.x - c.getX();
    }

    /**
     * Compare y axis
     * @param c the Multidimensional object
     * @return integer
     */
    public int compareToY(Multidimensional c){
        return this.y - c.getY();
    }

    /**
     * Compare z axis
     * @param c the Multidimensional object
     * @return integer
     */
    public int compareToZ(Multidimensional c){
        return this.z - c.getZ();
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * get x axis
     * @return integer
     */
    public int getX() {
        return x;
    }

    /**
     * set x axis
     * @param x the new x axis
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * get y axis
     * @return integer
     */
    public int getY() {
        return y;
    }

    /**
     * set y axis
     * @param y the new y axis
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * get z axis
     * @return integer
     */
    public int getZ() {
        return z;
    }

    /**
     * set z axis
     * @param z the new z axis
     */
    public void setZ(int z) {
        this.z = z;
    }

    @Override
    public String toString(){
        String str ="";
        str = str.concat( "(" +x+ "," +y+ ","+z+")" );
        return str;
    }

    /**
     * Compare the two Multidimensional value distance from (0,0,0)
     * @param o the Multidimensional object
     * @return integer
     */
    @Override
    public int compareTo(Multidimensional o) {

        int x1,y1,z1,x2,y2,z2;
        x1=this.x*this.x;
        y1=this.y*this.y;
        z1=this.z*this.z;

        x2=o.getX()*o.getX();
        y2=o.getY()*o.getY();
        z2=o.getZ()*o.getZ();
        return (int) (Math.sqrt(x1+y1+z1)- Math.sqrt(x2+y2+z2));
    }

    /**
     *  if the given object equal or not this object
     * @param o the object (Multidimensional)
     * @return true or false
     */
    @Override
    public boolean equals(Object o){
        if(o==null)
            return false;
        Multidimensional m = (Multidimensional)o;
        if(this.x==m.getX() && this.y==m.getY() && this.z == m.getZ())
            return true;
        return false;
    }


}
