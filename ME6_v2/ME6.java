import javax.script.Invocable;
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

public class ME6 {
    String filename = "test.txt";
    Path dir;

    WatchService watcher;
    WatchKey key;

    JFrame frame = new JFrame("Surname_ME6");

    JEditorPane fileText = new JEditorPane();
    JScrollPane fileTextScrollPane = new JScrollPane(fileText);

    JTextArea typingArea = new JTextArea();
    JScrollPane typingAreaScrollPane = new JScrollPane(typingArea);

    JPanel infoPanel = new JPanel();
    JLabel errLabel = new JLabel("Errors: ");
    int errNum = 0;
    JLabel errValue = new JLabel("" + errNum);

    String fileContent = "";
    String editorContent = "";

    ErrorChecker errCheck;

    Timer timer;

    public ME6() {
        dir = Paths.get("."); // monitor current directory

        try {
            watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException e) {
            System.err.println("Error " + e.getCause());
        }
    }

    public void processEvents() {
        while (true) {
            // TODO: ITEM 2

            // key.reset();
        }
    }

    public void createAndShowGui() {
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setFileContent();

        System.out.println(fileContent);
        frame.pack();
        frame.setVisible(true);

        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());

        fileText.setText(fileContent);
        fileText.setEditable(false);
        fileTextScrollPane.setPreferredSize(new Dimension(400, 200));
        fileTextScrollPane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("File text"),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        typingArea.setLineWrap(true);
        typingAreaScrollPane.setPreferredSize(new Dimension(400, 200));
        typingAreaScrollPane.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createTitledBorder("Type text here"), BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        infoPanel.setLayout(new FlowLayout());
        infoPanel.add(errLabel);
        infoPanel.add(errValue);

        pane.add(fileTextScrollPane, BorderLayout.PAGE_START);
        pane.add(typingAreaScrollPane, BorderLayout.CENTER);
        pane.add(infoPanel, BorderLayout.PAGE_END);

        frame.pack();
        frame.setVisible(true);

        (errCheck = new ErrorChecker()).execute();
    }

    public void setFileContent() {
        fileContent = new String("");
        try {
            File txtFile = new File(filename);

            Scanner s = new Scanner(txtFile);
            while (s.hasNextLine()) {
                // System.out.println(s.nextLine());
                fileContent = new String(fileContent + s.nextLine() + "\n");
            }
        } catch (FileNotFoundException e) {
        }
    }

    public static void main(String[] args) {
        ME6 ME6 = new ME6();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                ME6.createAndShowGui();
            }
        });
        ME6.processEvents();
    }

    class ErrorNumber {
        int errNum = 0;

        public ErrorNumber(int errNum) {
            this.errNum = errNum;
        }

        public int getErrNum() {
            return errNum;
        }
    }

    class ErrorChecker extends SwingWorker<Void, ErrorNumber> {
        @Override
        protected Void doInBackground() {
            while (!isCancelled()) {
                publish(getNumErrors());
            }
            return null;
        }

        @Override
        protected void process(List<ErrorNumber> intList) {
            // TODO: ITEM 4, you can remove next lines
            errValue.setText("");
            frame.repaint();
        }
    }

    public ErrorNumber getNumErrors() {
        // TODO: ITEM 3, you can remove next line
        return new ErrorNumber(0);
    }
}
