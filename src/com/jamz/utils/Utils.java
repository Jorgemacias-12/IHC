/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jamz.utils;

import java.awt.Panel;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author Jorge
 */
public class Utils {
    
    private final static String IMAGE_EXTENSION = ".jpg";
    
    public static BufferedImage matToBufferedImage(Mat matrix) {
        MatOfByte mob = new MatOfByte();
        
        Imgcodecs.imencode(IMAGE_EXTENSION, matrix, mob);
        
        byte[] data = mob.toArray();
        
        BufferedImage buff = null;
        
        try {
            InputStream in = new ByteArrayInputStream(data);
            
            buff = ImageIO.read(in);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return buff;
    }
    
    public static Panel createPersonComponent(ImageIcon icon) {
        Panel pnl = new Panel();
        JLabel lbl = new JLabel();
       
        lbl.setIcon(icon);
        
        pnl.add(lbl);
        
        return pnl;
    }
}
