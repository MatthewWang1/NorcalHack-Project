package project;

import java.awt.Graphics;


public interface Sprite
{
    public void draw( Graphics g );


    public void update();


    public int getX();


    public int getY();


    public Location getLoc();
    
    public void setLoc(Location l);
}
