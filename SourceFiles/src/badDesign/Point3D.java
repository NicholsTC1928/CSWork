package badDesign;

import java.awt.*;

public class Point3D extends Point{
    int z;

    public Point3D(int x,int y,int z){
        super(x,y);
        this.z = z;
    }

    //Returns the z-coordinate of the Point3D object
    public int getZ(){
        return z;
    }

    public boolean equals(Object o){
        if(o instanceof Point3D){
            Point3D p = (Point3D) o;
            return (p.getX() == this.getX() && p.getY() == this.getY() && p.getZ() == this.getZ());
        }
        else return false;
    }
}
