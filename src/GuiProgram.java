import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuiProgram implements ActionListener {

    private JButton nowPlayingB;
    private JButton mediaB;
    private JButton libraryB;
    private JButton helpB;
    private JTextArea center;
    private JButton oneB;
    private JButton twoB;
    private JButton threeB;
    private JButton zeroB;
    private JButton ok;

    public GuiProgram() {
        // Initialize buttons and set their action listeners
        nowPlayingB = new JButton("Now Playing");
        nowPlayingB.addActionListener(this);
        mediaB = new JButton("Media Guide");
        mediaB.addActionListener(this);
        libraryB = new JButton("Library");
        libraryB.addActionListener(this);
        helpB = new JButton("Help & Info");
        helpB.addActionListener(this);

        // Set background color to white
        nowPlayingB.setBackground(Color.WHITE);
        mediaB.setBackground(Color.WHITE);
        libraryB.setBackground(Color.WHITE);
        helpB.setBackground(Color.WHITE);

        // Create panel for buttons on the left side
        JPanel westPan = new JPanel();
        westPan.setLayout(new FlowLayout());
        westPan.add(nowPlayingB);
        westPan.add(mediaB);
        westPan.add(libraryB);
        westPan.add(helpB);

        // Create JTextArea for displaying text
        center = new JTextArea(5, 20);
        JScrollPane centerScroll = new JScrollPane(center);

        // Create panel for labels on the bottom
        JPanel southPan = new JPanel();
        JLabel movie = new JLabel("Movie");
        JLabel music = new JLabel("Music");
        JLabel video = new JLabel("Video");
        JLabel dvd = new JLabel("DVD");
        JLabel webPages = new JLabel("Web Pages");
        southPan.setLayout(new FlowLayout());
        southPan.add(movie);
        southPan.add(music);
        southPan.add(video);
        southPan.add(dvd);
        southPan.add(webPages);

        // Create panel for buttons on the right side
        JPanel eastPan = new JPanel(new BorderLayout());

        // Create panels for each row of buttons
        JPanel row1 = new JPanel();
        row1.setLayout(new FlowLayout());
        JPanel row2 = new JPanel();
        row2.setLayout(new FlowLayout());

        // Create buttons
        oneB = new JButton("1");
        oneB.addActionListener(this);
        twoB = new JButton("2");
        twoB.addActionListener(this);
        threeB = new JButton("3");
        threeB.addActionListener(this);
        zeroB = new JButton("0");
        zeroB.addActionListener(this);
        ok = new JButton("ok");
        ok.addActionListener(this);

        // Set background color to white and set sizes
        zeroB.setBackground(Color.WHITE);
        zeroB.setPreferredSize(new Dimension(65,20));

        oneB.setBackground(Color.WHITE);
        oneB.setPreferredSize(new Dimension(65,20));

        twoB.setBackground(Color.WHITE);
        twoB.setPreferredSize(new Dimension(65,20));

        threeB.setBackground(Color.WHITE);
        threeB.setPreferredSize(new Dimension(65,20));

        ok.setBackground(Color.WHITE);

        // Add buttons to rows
        row1.add(zeroB);
        row1.add(oneB);
        row1.setPreferredSize(new Dimension(150,30));

        row2.add(twoB);
        row2.add(threeB);
        row2.setPreferredSize(new Dimension(150,30));

        ok.setPreferredSize(new Dimension(150,470));

        // Add rows to the main panel
        eastPan.add(row1, BorderLayout.NORTH);
        eastPan.add(row2, BorderLayout.CENTER);
        eastPan.add(ok, BorderLayout.SOUTH);

        westPan.setPreferredSize(new Dimension(107,600));
        eastPan.setPreferredSize(new Dimension(150,600));
        //center.setPreferredSize(new Dimension(100,400));

        // Create main frame
        JFrame frame = new JFrame("Movies on Thursday");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(450, 600));
        frame.add(westPan, BorderLayout.WEST);
        frame.add(centerScroll, BorderLayout.CENTER);
        frame.add(southPan, BorderLayout.SOUTH);
        frame.add(eastPan, BorderLayout.EAST);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the current text of the JTextArea
        String currentText = center.getText();
        // Call method to handle button press
        handlePress((JButton) e.getSource(), currentText, center);
    }

    public static void handlePress(JButton button, String curr, JTextArea center) {
        // Append button text followed by a newline character
        curr += button.getText() + "\n";
        // Set the updated text in the JTextArea
        center.setText(curr);
    }

    public static void main(String[] args) {
        GuiProgram theater = new GuiProgram();
    }
}
