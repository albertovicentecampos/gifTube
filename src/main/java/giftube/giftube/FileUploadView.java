/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Alberto
 */
@Named
@ViewScoped
public class FileUploadView implements Serializable{

    private UploadedFile file;
    private boolean archivoReady;
    
    private static final Logger logger = Logger.getLogger(FileUploadView.class.getName());

    public FileUploadView() {
        this.archivoReady = false;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public boolean isArchivoReady() {
        return archivoReady;
    }

    public void setArchivoReady(boolean archivoReady) {
        this.archivoReady = archivoReady;
    }



    public String upload() throws Exception {
        if (file != null) {
        FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, message);

        System.out.println("Uploaded file now: " + file.getFileName());

        String name = file.getFileName();

        InputStream inputStream = file.getInputstream();
        OutputStream outputStream = null;
        String path = "C:\\Users\\Alberto\\Desktop\\";

        File file = new File(path + name);

        outputStream = new FileOutputStream(file);

        int read = 0;
        byte[] bytes = new byte[1024];

        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }

        System.out.println("Done!");
        
    }
        if(archivoReady){
            return "main1.xhtml";
        }else{
            return "upload_gif.xhtml";
        }
        
    }


    public void handleFileUpload(FileUploadEvent event) throws Exception {
        logger.info("esta funcionado");
        archivoReady=true;
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        file=event.getFile();
    }
}
