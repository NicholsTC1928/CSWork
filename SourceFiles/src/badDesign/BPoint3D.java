package badDesign;

import java.awt.*;

public class BPoint3D {
    private Point xAndY;
    private int z;

    public BPoint3D(int x,int y,int z){
        xAndY = new Point(x,y);
        this.z = z;
    }

    public int getX(){
        return xAndY.x;
    }

    public int getY(){
        return xAndY.y;
    }

    public int getZ(){
        return this.z;
    }

    public boolean equals(Object o){
        if(o instanceof Point3D){
            Point3D p = (Point3D) o;
            return (p.getX() == this.getX() && p.getY() == this.getY() && p.getZ() == this.getZ());
        }
        else return false;
    }
}
