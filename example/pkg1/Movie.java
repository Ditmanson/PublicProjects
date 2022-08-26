/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package example.pkg1;

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
       // System.out.printf("Title: %s \t Artist: %s\n",title,artist);
        return  "Title:  " + title +"\nGenere: "+genere;
    }
}
