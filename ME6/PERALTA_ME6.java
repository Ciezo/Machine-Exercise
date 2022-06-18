/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.script.Invocable;
import javax.swing.*;
import java.util.Scanner;
import java.awt.*;
import java.io.*;
import java.nio.file.*;
import java.util.List;

/**
 *
 * @author Jan Carlo
 */
public class PERALTA_ME6 {
    String filename = "PERALTA_BM5.txt";
    Path dir;

    WatchService watcher;
    WatchKey key;

    JFrame frame = new JFrame("PERALTA_BM5");

    JEditorPane fileText = new JEditorPane();
    JScrollPane fileTextScrollPane = new JScrollPane(fileText);

    JTextArea typingArea = new JTextArea();
    JScrollPane typingAreaScrollPane = new JScrollPane(typingArea);

    JPanel infoPanel = new JPanel();
    JLabel errLabel = new JLabel("Errors: ");
    int errNum = 0;
    JLabel errValue = new JLabel("" + errNum);

    String fileContent = "";
    char[] Filech = fileContent.toCharArray();
    String editorContent = "";
    char[] EditCh = editorContent.toCharArray();

    ErrorChecker errCheck;

    Timer timer;

    public PERALTA_ME6() {
        dir = Paths.get("."); // monitor current directory

        try {
            watcher = FileSystems.getDefault().newWatchService();
            dir.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
        } catch (IOException e) {
            System.err.println("Error " + e.getCause());
        }
    }

    public void processEvents() throws Exception {
        while (true) {
            // TODO: ITEM 2
            RandomAccessFile rna = new RandomAccessFile("PERALTA_BM5.txt", "r");
            String T;
            while (true) {
                if ((T = rna.readLine()) != null) {
                    // System.out.println(line);
                } else {
                    Thread.sleep(2000); // Sleep for 2 seconds before calling createAndShowGui
                    createAndShowGui();
                }

            }
        }
    }

    public void createAndShowGui() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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

    public static void main(String[] args) throws Exception {
        PERALTA_ME6 PERALTA_me6 = new PERALTA_ME6();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                PERALTA_me6.createAndShowGui();
            }
        });
        PERALTA_me6.processEvents();
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
            errValue.setText("" + errNum);
            frame.repaint();
        }
    }

    public ErrorNumber getNumErrors() {
        // TODO: ITEM 3, you can remove next line

        if (editorContent == "") {
            if (EditCh != Filech) {
                errNum += 1;
                return new ErrorNumber(errNum);
            } else {
                errNum -= 1;
                return new ErrorNumber(errNum);
            }

        }
        // return new geterrNum(0);
        return new ErrorNumber(errNum);
    }
}