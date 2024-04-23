import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a simple movie theater GUI application.
 */
public class MovieTheater implements ActionListener {

    private JButton nowPlayingB;
    private JButton mediaB;
    private JButton libraryB;
    private JButton helpB;
    private JTextArea center;
    private JButton oneB;
    private JButton twoB;
    private JButton threeB;
    private JButton fourB;
    private JButton ok;

    /**
     * @author Aniruddha Biswas Atanu
     * Constructs the movie theater GUI.
     */
    public MovieTheater() {
        // Initialize buttons and set their action listeners
        nowPlayingB = new JButton("Now Playing");
        nowPlayingB.addActionListener(this);
        mediaB = new JButton("Media Guide");
        mediaB.addActionListener(this);
        libraryB = new JButton("Library");
        libraryB.addActionListener(this);
        helpB = new JButton("Help & Info");
        helpB.addActionListener(this);

        // Create panel for buttons on the left side
        JPanel westPan = new JPanel();
        westPan.add(nowPlayingB);
        westPan.add(mediaB);
        westPan.add(libraryB);
        westPan.add(helpB);
        westPan.setLayout(new GridLayout(4, 0));

        // Create JTextArea for displaying text
        center = new JTextArea();
        JScrollPane centerScroll = new JScrollPane(center);

        // Create panel for labels on the bottom
        JPanel southPan = new JPanel();
        JLabel movie = new JLabel("Movie");
        movie.setSize(50, 20);
        JLabel music = new JLabel("Music");
        music.setSize(50, 20);
        JLabel video = new JLabel("Video");
        video.setSize(50, 20);
        JLabel dvd = new JLabel("DVD");
        dvd.setSize(50, 20);
        JLabel webPages = new JLabel("Web Pages");
        webPages.setSize(50, 20);
        southPan.setLayout(new FlowLayout());
        southPan.add(movie);
        southPan.add(music);
        southPan.add(video);
        southPan.add(dvd);
        southPan.add(webPages);

        // Create panel for buttons on the right side
        JPanel eastPan = new JPanel();
        eastPan.setLayout(new GridLayout(3, 1));
        oneB = new JButton("1");
        oneB.addActionListener(this);
        twoB = new JButton("2");
        twoB.addActionListener(this);
        threeB = new JButton("3");
        threeB.addActionListener(this);
        fourB = new JButton("4");
        fourB.addActionListener(this);
        ok = new JButton("ok");
        ok.addActionListener(this);
        JPanel row1 = new JPanel();
        JPanel row2 = new JPanel();
        JPanel row3 = new JPanel();
        row1.add(oneB);
        row1.add(twoB);
        row2.add(threeB);
        row2.add(fourB);
        row3.add(ok);
        eastPan.add(row1);
        eastPan.add(row2);
        eastPan.add(row3);

        // Create main frame
        JFrame frame = new JFrame("Movies on Thursday");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 400);
        frame.add(westPan, BorderLayout.WEST);
        frame.add(centerScroll, BorderLayout.CENTER);
        frame.add(southPan, BorderLayout.SOUTH);
        frame.add(eastPan, BorderLayout.EAST);
        frame.setVisible(true);
    }

    /**
     * Handles button click events.
     *
     * @param e The ActionEvent object representing the button click event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the current text of the JTextArea
        String currentText = center.getText();
        // Call method to handle button press
        handlePress((JButton) e.getSource(), currentText, center);
    }

    /**
     * Appends button text to the JTextArea.
     *
     * @param button The button that was pressed.
     * @param curr   The current text in the JTextArea.
     * @param center The JTextArea component.
     */
    public static void handlePress(JButton button, String curr, JTextArea center) {
        // Append button text followed by a newline character
        curr += button.getText() + "\n";
        // Set the updated text in the JTextArea
        center.setText(curr);
    }

    /**
     * Main method to create and run the movie theater GUI.
     *
     * @param args The command-line arguments (not used).
     */
    public static void main(String[] args) {
        MovieTheater theater = new MovieTheater();
    }
}
