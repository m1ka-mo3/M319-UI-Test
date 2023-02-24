import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.AudioInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Main extends JFrame {
    private JButton playButton;
    private JLabel imageLabel;

    public Main() {
        super("I am a gay cat");

        // Set up the play button
        playButton = new JButton("Turn gay");
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                playBruhSound();
            }
        });

        // Set up the image label
        ImageIcon icon = new ImageIcon("src/uwu.jpg");
        imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        // Add the button and image to the panel
        JPanel panel = new JPanel(new BorderLayout());
        panel.add(playButton, BorderLayout.NORTH);
        panel.add(imageLabel, BorderLayout.CENTER);

        // Add the panel to the frame
        getContentPane().add(panel);

        // Set up the frame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setVisible(true);
    }

    private void playBruhSound() {
        try {
            File file = new File("src/bruh.wav");
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
