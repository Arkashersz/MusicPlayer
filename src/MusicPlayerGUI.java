import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class MusicPlayerGUI extends JFrame {

    public static final Color FRAME_COLOR = Color.BLACK;
    public static final Color TEXT_COLOR = Color.WHITE;

    public MusicPlayerGUI(){
        super("Music Player");
        setSize(400, 600);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setLayout(null);

        getContentPane().setBackground(FRAME_COLOR);

        addGuiComponents();
    }

    private void addGuiComponents(){
        addToolbar();

        JLabel songImage = new JLabel (loadImage("src/assets/record.png"));
        songImage.setBounds(0,50,getWidth() - 20, 225);
        add(songImage);


    }

    private void addToolbar(){
        JToolBar toolBar = new JToolBar();
        toolBar.setBounds(0,0,getWidth(), 20);

        toolBar.setFloatable(false);

        JMenuBar menuBar = new JMenuBar();
        toolBar.add(menuBar);

        JMenu songMenu = new JMenu("Música");
        menuBar.add(songMenu);

        JMenuItem loadSong = new JMenuItem("Carregar música");
        songMenu.add(loadSong);

        JMenuItem playlistMenu = new JMenu("Playlist");
        menuBar.add(playlistMenu);

        JMenuItem createPlaylist = new JMenuItem("Criar Playlist");
        playlistMenu.add(createPlaylist);

        JMenuItem loadPlaylist = new JMenuItem("Carregar Playlist");
        playlistMenu.add(loadPlaylist);

        add(toolBar);
    }

    private ImageIcon loadImage(String imagePath){
        try{
            BufferedImage image = ImageIO.read(new File(imagePath));

            return new ImageIcon(image);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
