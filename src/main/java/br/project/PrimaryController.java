package br.project;
import java.io.IOException;

import javafx.fxml.FXML;

public class PrimaryController  {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
        System.out.println("Entrei na segunda tela");
    }

    @FXML
    private void switchTotertiary() throws IOException {
        App.setRoot("tertiary");
      
        
    }

   


}
