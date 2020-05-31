package project;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;


public class GameHandler extends JPanel implements ActionListener
{
    private final ArrayList<Location> trail = new ArrayList<Location>();

    private int width = Main.WIDTH - 200;

    private int height = Main.HEIGHT;

    public static final int SQUAREDIM = 40;

    private Timer timer = new Timer( 10, this );

    private Location mouse = new Location( 0, 0 );

    private int health = 100;

    private int money = 100;

    private EnemyManager em;

    private TowerManager tm;

    private CollisionsManager cm;

    private SidePanel sp;

    private Tower selected = null;

    private int gameState = 0;
    // 0: plating 1:dead


    public GameHandler()
    {
        setTrail();
        em = new EnemyManager();
        tm = new TowerManager();
        cm = new CollisionsManager( tm, em );
        sp = new SidePanel( width, height, this );
    }


    public void paintComponent( Graphics g )
    {
        super.paintComponent( g );

        if ( gameState == 0 )
        {
            // backdrop
            g.setColor( Color.WHITE );
            g.fillRect( 0, 0, width, height );

            // grid
            drawGrid( g );
            g.setColor( Color.BLACK );
            g.drawRect( mouse.getX() - 1,
                mouse.getY() - 1,
                SQUAREDIM,
                SQUAREDIM );
            g.drawRect( mouse.getX(), mouse.getY(), SQUAREDIM, SQUAREDIM );
            if ( selected != null )
            {
                selected.setLoc( new Location( mouse.getX(), mouse.getY() ) );
                selected.draw( g );
            }

            // things
            em.draw( g );
            cm.draw( g );
            tm.draw( g );
            sp.draw( g );
        }
        if ( gameState == 1 )
        {
            g.setColor( Color.black );
            g.fillRect( 0, 0, 10000, 10000 );
            Font font = new Font( "SansSerif", Font.PLAIN, 60 );

            g.setFont( font );
            g.setColor( Color.WHITE );
            g.drawString( "GAME OVER", width / 2 - 100, height / 2 );
        }
        timer.start();

    }


    public void actionPerformed( ActionEvent arg0 )
    {
        if ( health <= 0 )
        {
            gameState = 1;
        }
        if ( gameState == 0 )
        {
            em.update();
            tm.update();
            cm.update();
        }
        repaint();
    }


    public void mouseMoved( int x, int y )
    {
        if ( x < width - 9 && y < height - 9 )
        {
            int i = x / SQUAREDIM;
            double j = (double)y / (double)SQUAREDIM;
            int k = (int)( j - 0.5 );
            mouse.setX( i * SQUAREDIM );
            mouse.setY( k * SQUAREDIM );
            mouse.setRemoved( false );
            if ( selected != null )
            {
                selected.setLoc( new Location( x, y ) );
            }
        }
        else
        {
            mouse.setRemoved( true );
        }

    }


    private void drawGrid( Graphics g )
    {
        for ( int i = 0; i < width / SQUAREDIM; i++ )
        {
            for ( int j = 0; j < height / SQUAREDIM; j++ )
            {
                if ( trail.contains( new Location( true, i, j ) ) )
                {
                    g.setColor( new Color( 151, 111, 60 ) );
                }
                else
                {
                    g.setColor( new Color( 61, 183, 61 ) );
                }

                g.fillRect( ( i * SQUAREDIM ) + 1,
                    ( j * SQUAREDIM ) + 1,
                    SQUAREDIM - 2,
                    SQUAREDIM - 2 );
            }
        }
    }


    public void setSelected( Tower t )
    {
        selected = t;
    }


    public int getHealth()
    {
        return health;
    }


    public int getMoney()
    {
        return money;
    }


    private void setTrail()
    {
        trail.add( new Location( true, 0, 2 ) );
        trail.add( new Location( true, 1, 2 ) );
        trail.add( new Location( true, 1, 3 ) );

        for ( int i = 3; i < 15; i++ )
        {
            trail.add( new Location( true, 2, i ) );

        }

        trail.add( new Location( true, 3, 14 ) );
        trail.add( new Location( true, 3, 15 ) );
        trail.add( new Location( true, 4, 15 ) );
        trail.add( new Location( true, 5, 15 ) );
        trail.add( new Location( true, 6, 15 ) );
        trail.add( new Location( true, 6, 14 ) );

        for ( int i = 14; i > 1; i-- )
        {
            trail.add( new Location( true, 7, i ) );

        }

        trail.add( new Location( true, 8, 2 ) );
        trail.add( new Location( true, 8, 1 ) );
        trail.add( new Location( true, 9, 1 ) );
        trail.add( new Location( true, 10, 1 ) );
        trail.add( new Location( true, 11, 1 ) );
        trail.add( new Location( true, 11, 2 ) );

        for ( int i = 2; i < 17; i++ )
        {
            trail.add( new Location( true, 12, i ) );

        }

        trail.add( new Location( true, 13, 16 ) );

        for ( int i = 13; i < 27; i++ )
        {
            trail.add( new Location( true, i, 17 ) );
        }

        trail.add( new Location( true, 26, 16 ) );
        trail.add( new Location( true, 27, 16 ) );
        trail.add( new Location( true, 27, 15 ) );
        trail.add( new Location( true, 27, 14 ) );
        trail.add( new Location( true, 27, 13 ) );
        trail.add( new Location( true, 26, 13 ) );

        for ( int i = 26; i > 15; i-- )
        {
            trail.add( new Location( true, i, 12 ) );
        }

        trail.add( new Location( true, 16, 11 ) );
        trail.add( new Location( true, 15, 11 ) );
        trail.add( new Location( true, 15, 10 ) );
        trail.add( new Location( true, 15, 9 ) );
        trail.add( new Location( true, 15, 8 ) );
        trail.add( new Location( true, 16, 8 ) );
        trail.add( new Location( true, 16, 7 ) );
        trail.add( new Location( true, 17, 7 ) );
        trail.add( new Location( true, 17, 6 ) );
        trail.add( new Location( true, 18, 6 ) );
        trail.add( new Location( true, 19, 6 ) );
        trail.add( new Location( true, 19, 5 ) );
        trail.add( new Location( true, 20, 5 ) );
        trail.add( new Location( true, 21, 5 ) );
        trail.add( new Location( true, 22, 5 ) );
        trail.add( new Location( true, 23, 5 ) );
        trail.add( new Location( true, 23, 4 ) );
        trail.add( new Location( true, 24, 4 ) );
        trail.add( new Location( true, 25, 4 ) );
        trail.add( new Location( true, 26, 4 ) );
        trail.add( new Location( true, 26, 3 ) );
        trail.add( new Location( true, 27, 3 ) );
        trail.add( new Location( true, 28, 3 ) );
        trail.add( new Location( true, 29, 3 ) );

    }


    public void addSelected()
    {
        int index = trail.indexOf( selected.getLoc() );
        if ( index == -1 && money >= selected.getCost() )
        {
            tm.add( selected );
            selected = null;
        }
    }


    public Location nextMove( Location pos )
    {
        int index = trail.indexOf( pos );
        if ( index == trail.size() - 1 )
        {
            return null;
        }
        return trail.get( index + 1 );
    }


    public boolean isSelecting()
    {

        return selected != null;
    }


    public void addMoney( int amt )
    {
        money += amt;
    }


    public void loseLife( int amt )
    {
        health -= amt;
    }
}
