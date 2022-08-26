/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mediaproject;

/**
 *
 * @author travi
 */
public class Media
{
    protected String title;
    public Media(String title){
        this.title=title;
    }
    
    public String getTitle(){
        return title;
    }
    
    public void setTitle(String newTitle){
        title=newTitle;
    }
    
}
