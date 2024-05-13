module br.project {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.project to javafx.fxml;
    exports br.project;
}
