package project;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;


public class MouseHandler implements MouseListener, MouseMotionListener
{

    public void mouseClicked( MouseEvent e )
    {

        int x = e.getX();
        int y = e.getY();

        if ( x >= 1200 && x <= 1400 && y >= 165 && y <= 235 )
        {
            if ( Main.gh.getMoney() >= 100 )
            {
                Main.gh.setSelected( new Tower( new Location( x, y ) ) );
            }
        }
        else if ( x >= 1200 && x <= 1400 && y >= 235 && y <= 305 )
        {
            if ( Main.gh.getMoney() >= 200 )
            {
                Main.gh.setSelected(
                    new LongRangedTower( new Location( x, y ) ) );
            }
        }
        else if ( x >= 1200 && x <= 1400 && y >= 305 && y <= 375 )
        {
            if ( Main.gh.getMoney() >= 300 )
            {
                Main.gh.setSelected(
                    new SpeedTower( new Location( x, y ) ) );
            }
        }
        if ( Main.gh.isSelecting() )
        {
            if ( x >= 0 && x < 1200 && y >= 0 && y <= 780 )
            {
                Main.gh.addSelected();
            }
        }

    }


    public void mouseEntered( MouseEvent e )
    {

    }


    public void mouseExited( MouseEvent e )
    {

    }


    public void mousePressed( MouseEvent e )
    {

    }


    public void mouseReleased( MouseEvent e )
    {

    }


    public void mouseDragged( MouseEvent arg0 )
    {

    }


    public void mouseMoved( MouseEvent e )
    {
        int x = e.getX();
        int y = e.getY();
        Main.gh.mouseMoved( x, y );
    }

}
