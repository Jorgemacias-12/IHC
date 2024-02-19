package com.jamz.models;

import java.awt.image.BufferedImage;

/**
 *
 * @author Jorge
 */
public class Person {
    private int hashCode;
    private String name;
    private BufferedImage faceImage;

    public int getHashCode() {
        return hashCode;
    }

    public void setHashCode(int hashCode) {
        this.hashCode = hashCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BufferedImage getFaceImage() {
        return faceImage;
    }

    public void setFaceImage(BufferedImage faceImage) {
        this.faceImage = faceImage;
    }

    public Person(int hashCode, String name, BufferedImage faceImage) {
        this.hashCode = hashCode;
        this.name = name;
        this.faceImage = faceImage;
    }
    
    
}
