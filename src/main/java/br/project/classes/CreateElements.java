package br.project.classes;

import java.util.ArrayList;


import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class CreateElements {
    String nome;
    String sobrenome;
    
    public CreateElements(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getSobrenome() {
        return sobrenome;
    }
    
    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    protected static VBox createVBox(){
        VBox vBox = new VBox();
       
        String  styles = 
        (
            "-fx-background-color:  #f5fffb;" +
            " -fx-background-radius:10;" +
            " -fx-border-radius: 10;" +
            " -fx-border-color:  #c0c0c0;" +
            " -fx-padding: 10px;"
        );
        vBox.setId("idVboxDados");
        vBox.setStyle(styles);
        vBox.getChildren().add(insertVbox());
       
        return vBox;
    }

  

    private static VBox insertVbox(){
        VBox vBox = new VBox();
        ArrayList<Label> labels = new ArrayList<>(); 
        labels = createLabel();
        for(int i = 0; i< labels.size(); i++){
            vBox.getChildren().add(labels.get(i)); 
            
        }
        return vBox;
    }


    protected static ArrayList<Label> createLabel(){
        Label labelNome = new Label("Eu sou uma label do tipo nome dentro do vbox");
        Label labelSobrenome = new Label("Eu sou uma label do tipo sobrenome dentro do vbox");
        Label labelEmail = new Label("Eu sou uma label do tipo telefone dentro do vbox");
        Label labelTelefone = new Label("Eu sou uma label do tipo email dentro do vbox");

        ArrayList<Label> labels = new ArrayList<>();


        labels.add(labelNome);
        labels.add(labelSobrenome);
        labels.add(labelEmail);
        labels.add(labelTelefone);
        return labels;
    }

    // protected static ArrayList<ArrayList> getDados(){
    //     ArrayList<ArrayList> dados = new ArrayList<>();



    //     return dados;
    // }
   
    
    
}