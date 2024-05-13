package br.project;

import java.io.IOException;

import java.util.ArrayList;

import br.project.classes.Pessoa;
import br.project.interfaces.Salvar;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class SecondaryController extends Pessoa implements Salvar {   

    @FXML
    private Button buttonAddContato;

    @FXML
    private TextField inputEmail;

    @FXML
    private TextField inputNome;

    @FXML
    private TextField inputSobrenome;

    @FXML
    private TextField inputTelefone;

    @FXML
    private Button secondaryButton;
    
    public SecondaryController() {
        super("", "", "", ""); // Chama o construtor da classe Pessoa com valores vazios
    }

    @FXML
    void addContato(ActionEvent event) {
        exibirDetalhes();
    }
    
    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
     
    }
    
    @Override
    public void exibirDetalhes() {
        String nome = inputNome.getText();
        String sobrenome = inputSobrenome.getText();
        String telefone = inputTelefone.getText();
        String email = inputEmail.getText();

        this.setNome(nome);
        this.setSobrenome(sobrenome);
        this.setTelefone(telefone);
        this.setEmail(email);

        ArrayList<String> pessoa = new ArrayList<>();
        // ArrayList<String> nomes = new ArrayList<>();
        // ArrayList<String> sobrenomes = new ArrayList<>();
        // ArrayList<String> telefones = new ArrayList<>();
        // ArrayList<String> emails = new ArrayList<>();
        pessoa.add(this.getNome() + " " + this.getSobrenome() + " " + this.getTelefone() + " " + this.getEmail()+ " ");
        System.out.println("Contato adicionado: " + pessoa);
        SalvarArquivos(pessoa);
    }

    @Override
    public void SalvarArquivos(ArrayList<String>pessoa){
       
        
        try {
            FileWriter fileWriter = new FileWriter("dados.txt",true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            for (String elemento : pessoa) {
                writer.write(elemento);
                writer.newLine();
            }
            writer.close();

            System.out.println("Os dados foram salvos no arquivo com sucesso!");

        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao salvar os dados no arquivo.");
            e.printStackTrace();
            
        }
    }

  
}