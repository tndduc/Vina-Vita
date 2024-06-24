/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ductn.VinaVita.components.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.ductn.VinaVita.configs.cloudinary.CloudinaryConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Administrator
 */
@Component
public class CloudinaryComponent {
    @Autowired
    private CloudinaryConfig cloudinary;

    public Map Cloudinary(MultipartFile file) {
        try {
            Map res = this.cloudinary.cloudinary().uploader().upload(file.getBytes(),
                    ObjectUtils.asMap("resource_type", "auto"));
            return res;

        } catch (IOException ex) {
            Logger.getLogger(Cloudinary.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Map CloudinaryPDF(byte[] pdfBytes) {
        try {
            Map res = this.cloudinary.cloudinary().uploader().upload(pdfBytes,
                    ObjectUtils.asMap("resource_type", "auto", "access_mode",
                            "public"));
            return res;

        } catch (IOException ex) {
            Logger.getLogger(Cloudinary.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
