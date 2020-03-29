/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giftube.giftube;

import giftube.giftube.Gif.Tags;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Alberto
 */
@Named
@ViewScoped
public class FileUploadView implements Serializable {

    @Inject
    GifDAOjpa gifDAO;
    
    @Inject 
    private Preferencias prefer;

    private Gif gif;
    private UploadedFile file;
    private boolean archivoReady;
    private String usuario;
    
    private String titulo;
    private Tags tag;
    private String ubicacion;
    private int id;
    
    private List<Gif> lista_gifs;
    

    private static final Logger logger = Logger.getLogger(FileUploadView.class.getName());

    public FileUploadView() {
        lista_gifs=new ArrayList<>();
        this.archivoReady = false;
        usuario = "error";
    }

    @PostConstruct
    public void init() {
        gif = new Gif();
        //setUsuario(prefer.getActualUsuarioid());
        usuario=prefer.getActualUsuarioid();
        lista_gifs = gifDAO.todos();
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

    public Gif getGif() {
        return gif;
    }

    public String upload() throws Exception {
        if (file != null && archivoReady) {
            FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
            FacesContext.getCurrentInstance().addMessage(null, message);

            System.out.println("Uploaded file now: " + file.getFileName());
            
            gif.setUsuario_gif(usuario);
           
            String name = gif.getTitulo_gif() + ".gif";
            //gif.setId_gif(0);

            //gif = new Gif(usuario,0,titulo,tag,name);
            
            InputStream inputStream = file.getInputstream();
            OutputStream outputStream = null;
            String path = "C:\\Users\\Alberto\\Desktop\\GifTube.git\\src\\main\\webapp\\resources\\images\\";

            File file1 = new File(path + name);
            gif.setUbicacion_gif(name);

            System.out.println("hola");
            outputStream = new FileOutputStream(file1);

            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
            }

            if (gifDAO.subirGif(gif)) {
                System.out.println("Done!");
                return "gifs_propios.xhtml?faces-redirect=true";
            }

            System.out.println("Id:" + gif.getId_gif());
            System.out.println("Titulo:" + gif.getTitulo_gif());
            System.out.println("Tag:" + gif.getTag_gif());
            System.out.println("Ubicacion: " + gif.getUbicacion_gif());
            
        }
        
        return "";
    }

    public void handleFileUpload(FileUploadEvent event) throws Exception {
        logger.info("esta funcionado");
        archivoReady = true;
        FacesMessage msg = new FacesMessage("Successful", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        file = event.getFile();
    }

    public List<Gif> prueba(){
        lista_gifs = gifDAO.todos();
        return lista_gifs;
    }
    
    public List<Gif> devuelveTodos() {
        lista_gifs = gifDAO.gifBuscaUsuario(usuario);
        return lista_gifs;
    }

    public String borra(Gif g) {
        if (gifDAO.borrarGif(g)) {
            return "gifs_propios.xhtml?faces-redirect=true";
        }
        return "gifs_propios.xhtml?faces-redirect=true";
    }

    public String editar() {
        gifDAO.modificarTitulo(gif, gif.getTitulo_gif());
        gifDAO.modificarTag(gif, gif.getTag_gif());
        return "gifs_propios.xhtml?faces-redirect=true";
    }

    public void recupera() {
        
        lista_gifs = gifDAO.gifBuscaUsuario(usuario);
        gif = gifDAO.buscarGif(gif);
        
        titulo = gif.getTitulo_gif();
        id = gif.getId_gif();
        tag = gif.getTag_gif();
        ubicacion = gif.getUbicacion_gif();
        
        if (gif == null) {
            System.out.println("El cliente indicado no existe");
        }
    }

    public String getUsuario() {
        return usuario;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    
    

}
