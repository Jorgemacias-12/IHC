package com.jamz.faceRecogniztion;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;

/**
 * 
 * @author Jorge
 * Date: 16-02-2024
 */
public class faceRecognizer extends javax.swing.JFrame {
    
    private final int CAMERA_HARDWARE_ID = 0;
    
    private VideoCapture capture;
    private Mat image;
    
    
    public faceRecognizer() {
        initComponents();
        
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        
        frameConfiguration();
    }
    
    private void frameConfiguration() {
        setLocationRelativeTo(null);
    }
    
    protected void startCamera() {
        capture = new VideoCapture(CAMERA_HARDWARE_ID);
        image = new Mat();
        
        byte[] data;
        
        ImageIcon icon;
        
        while(true) {
            capture.read(image);
            
            MatOfByte buffer = new MatOfByte();
            
            Imgcodecs.imencode(".jpg", image, buffer);
            
            data = buffer.toArray();
            
            icon = new ImageIcon(data);
            
            Lbl_Camera.setIcon(icon);
        }
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Lbl_Title = new javax.swing.JLabel();
        Pnl_Camera = new javax.swing.JPanel();
        Lbl_Camera = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Lbl_Title.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        Lbl_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Lbl_Title.setText("Open CV - Face recognition");
        Lbl_Title.setVerifyInputWhenFocusTarget(false);

        Pnl_Camera.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(32, 32, 32), 5, true));

        javax.swing.GroupLayout Pnl_CameraLayout = new javax.swing.GroupLayout(Pnl_Camera);
        Pnl_Camera.setLayout(Pnl_CameraLayout);
        Pnl_CameraLayout.setHorizontalGroup(
            Pnl_CameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lbl_Camera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Pnl_CameraLayout.setVerticalGroup(
            Pnl_CameraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Lbl_Camera, javax.swing.GroupLayout.DEFAULT_SIZE, 417, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Lbl_Title, javax.swing.GroupLayout.DEFAULT_SIZE, 615, Short.MAX_VALUE)
                    .addComponent(Pnl_Camera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Lbl_Title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Pnl_Camera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (IllegalAccessException | 
               InstantiationException | 
               ClassNotFoundException |
               UnsupportedLookAndFeelException e) {
            System.err.print(e);
        }
        //</editor-fold>

        /* Create and display the form */
        EventQueue.invokeLater(() -> {
            faceRecognizer frame = new faceRecognizer();
            
            frame.setVisible(true);
            
            new Thread(frame::startCamera).start();
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Lbl_Camera;
    private javax.swing.JLabel Lbl_Title;
    private javax.swing.JPanel Pnl_Camera;
    // End of variables declaration//GEN-END:variables

}