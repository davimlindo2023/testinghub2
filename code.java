import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class TheFilesInTheComputer extends Application {

    // Classe para representar um arquivo fictício
    static class FileItem {
        String name;
        String content;

        FileItem(String name, String content) {
            this.name = name;
            this.content = content;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    private List<FileItem> files = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("The Files In The Computer");

        // Criar arquivos fictícios
        files.add(new FileItem("Nota do Sequestrador.txt", "Se você quer ver seu sobrinho vivo, siga as pistas..."));
        files.add(new FileItem("Foto suspeita.jpg", "[Imagem não disponível no protótipo]"));
        files.add(new FileItem("Registro de Acesso.log", "Usuário acessou a pasta secreta às 23:45."));

        // ListView para mostrar os nomes dos arquivos
        ListView<FileItem> listView = new ListView<>();
        listView.getItems().addAll(files);

        // Área de texto para mostrar o conteúdo do arquivo selecionado
        TextArea fileContent = new TextArea();
        fileContent.setEditable(false);

        // Quando o usuário selecionar um arquivo, mostrar o conteúdo
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                fileContent.setText(newVal.content);
            }
        });

        // Layout
        SplitPane splitPane = new SplitPane();
        splitPane.getItems().addAll(listView, fileContent);
        splitPane.setDividerPositions(0.3);

        Scene scene = new Scene(splitPane, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
