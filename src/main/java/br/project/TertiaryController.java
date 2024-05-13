package br.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import br.project.classes.CreateElements;
import br.project.interfaces.Ler;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import javafx.scene.layout.VBox;

import java.net.URL;

public class TertiaryController extends CreateElements implements Ler, Initializable  {
    public TertiaryController(){
        super("", "");
    }
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private VBox idVbox;
   
    @FXML
    private Label labelNome;

    @FXML
    private Label labelSobrenome;

    @FXML
    private Label labelTelefone;

    @FXML
    private Label labelEmail;


    @FXML
    private Button tertiaryButton;
    
    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
     
    }
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Este código será executado quando o controlador for inicializado
        System.out.println("Controlador inicializado!");
        LerArquivos();
        // Coloque aqui o código que você quer executar quando entrar na nova tela
    }

    @Override
    public void LerArquivos(){
        String nomeArquivo = "dados.txt";

        ArrayList<String> nomes = new ArrayList<>();
        ArrayList<String> sobrenomes = new ArrayList<>();
        ArrayList<String> telefones = new ArrayList<>();
        ArrayList<String> emails = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                System.out.println(linha);
                String[] partes = linha.split(" "); 

                nomes.add(partes[0]);
                sobrenomes.add(partes[1]);
                telefones.add(partes[2]);
                emails.add(partes[3]);

            }
            for(int i= 0; i<nomes.size(); i++){
                CreateElements createElements = new CreateElements(nomes.get(i), sobrenomes.get(i));
                
                labelNome.setText("Nome: " + nomes.get(i));
                labelSobrenome.setText("Sobrenome: " + sobrenomes.get(i));
                labelTelefone.setText("Telefone: " + telefones.get(i));
                labelEmail.setText("Email: " + emails.get(i));

                createLabel();
            }
            idVbox.getChildren().add(createVBox());
            
            
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao ler o arquivo: " + e.getMessage());
        }
    }

   
    
   
    
    
}