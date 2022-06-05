package fr.univ_amu.iut.contenu.accueil;

import fr.univ_amu.iut.JPAActeur;
import fr.univ_amu.iut.JPAUsage;
import fr.univ_amu.iut.contenu.reseaux.ReseauxOnglet;
import fr.univ_amu.iut.contenu.thematiques.ThematiquesOnglet;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import java.io.IOException;

public class AccueilContenuControl extends BorderPane {

    private Tab parentTab;
    private ThematiquesOnglet thematiquesOnglet = new ThematiquesOnglet();
    private ReseauxOnglet reseauxOnglet = new ReseauxOnglet();
    private JPAActeur jpaActeur = new JPAActeur();
    private JPAUsage jpaUsage = new JPAUsage();

    public AccueilContenuControl(Tab parentTab) {
        this.parentTab = parentTab;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AccueilContenuView.fxml"));
        fxmlLoader.setRoot(this);
        fxmlLoader.setController(this);
        try {
            fxmlLoader.load();
        } catch (IOException exception) {
            throw new RuntimeException(exception);
        }
    }

    @FXML
    public void startupTabs(ActionEvent actionEvent) {
        TabPane tabPane = parentTab.getTabPane();
        tabPane.getTabs().add(thematiquesOnglet);
        tabPane.getTabs().add(reseauxOnglet);
        tabPane.getTabs().remove(parentTab);
    }

    @FXML
    public void startupAdmin(ActionEvent actionEvent){
        TabPane tabPane = parentTab.getTabPane();
        tabPane.getTabs().add(jpaActeur);
        tabPane.getTabs().add(jpaUsage);
        tabPane.getTabs().remove(parentTab);
    }

}
