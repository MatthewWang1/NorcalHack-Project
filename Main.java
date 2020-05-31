package project;

import javax.swing.JFrame;


public class Main
{

    public final static int WIDTH = 1400;

    public final static int HEIGHT = 790;

    public final static GameHandler gh = new GameHandler();;


    public static void main( String[] args )
    {
        JFrame f = new JFrame( "Space Invaders" );
        f.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        f.setSize( WIDTH, HEIGHT );
        f.setBounds( 300, 0, WIDTH, HEIGHT );
        f.setResizable( false );
        f.setVisible( true );

        MouseHandler mh = new MouseHandler();

        f.add( gh );
        f.addMouseListener( mh );
        f.addMouseMotionListener( mh );

        gh.paintComponent( f.getGraphics() );
    }

}
