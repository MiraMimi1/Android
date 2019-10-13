package com.w12.thslm.historica;


public class Livres {
    private String Titre;
    private  String Description;             /**  Pages **/
    private String Auteur;
    private  String imgURL;
    private  String bgImage;
   private String [] Contenu;



    public Livres(String auteur, String titre, String description, String imgurl,String bgimage,String[] contenu) {
        Titre = titre;
        Auteur=auteur;
        Description = description;
        imgURL=imgurl;
        bgImage=bgimage;
        Contenu=contenu;
    }

    public String getBgImage() {return bgImage;}
    public void setBgImage(String bgImage) {this.bgImage = bgImage;}
    public String[] getContenu() {return Contenu;}
    public void setContenu(String[] contenu) {this.Contenu = contenu;}

    public String getImgURL() {return imgURL;}

    public void setImgURL(String imgURL) {this.imgURL = imgURL;}
    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getAuteur() {
        return Auteur;
    }

    public void setAuteur(String auteur) {
        Auteur = auteur;
    }
}