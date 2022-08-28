/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediaproject;

/**
 *
 * @author travi
 */
public class Movie extends Media
{
    private String genere;
    public Movie(String title, String genere){
         super(title);
         this.genere=genere;
    }
     public String getGenere(){
        return genere;
    }
    
    public void setGenere(String newGenere){
        genere=newGenere;
    }
     @Override
    public String toString(){
        return  "Genere:  " + genere +"\nTitle: "+title;
       // return  "Title:  " + title +"\nGenere: "+genere;
    }
}
