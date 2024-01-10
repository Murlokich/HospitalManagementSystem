package GUI;

import javax.swing.*;

public class MainWindow extends JFrame {
    public MainWindow() {
        setMainWindowSettings();
//        createToolBar();
    }

//    private void createToolBar() {
//        JToolBar toolBar = new JToolBar("Options", SwingConstants.HORIZONTAL);
//        toolBar.add(new JButton("Rooms"));
//    }

    private void setMainWindowSettings() {
        setTitle("Hospital Management System (HMS)");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1280, 720);  // Defining the size of the window after resizing
        setExtendedState(MAXIMIZED_BOTH);  // Maximizing the size of the window
        setResizable(true);
        setVisible(true);
    }

    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
    }
}
