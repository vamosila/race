package com.example;

import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.StringConverter;

public class MainController {

    @FXML
    private CheckBox absoluteCheck;

    @FXML
    private TableColumn<Racer, Boolean> absoluteCol;

    @FXML
    private TableColumn<Racer, LocalDate> birthCol;

    @FXML
    private DatePicker birthPicker;

    @FXML
    private ToggleGroup category;

    @FXML
    private TableColumn<Racer, String> categoryCol;

    @FXML
    private TableColumn<Racer, Integer> idCol;

    @FXML
    private TextField idField;

    @FXML
    private TableColumn<Racer, String> nameCol;

    @FXML
    private TextField nameField;

    @FXML
    private TableView<Racer> racerTable;

    @FXML
    void initialize() {
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        birthCol.setCellValueFactory(new PropertyValueFactory<>("birth"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));
        absoluteCol.setCellValueFactory(new PropertyValueFactory<>("absolute"));
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate date) {
                if (date == null) {
                    return "";
                }
                return date.toString();
            }

            @Override
            public LocalDate fromString(String string) {
                if (string == null || string.trim().length() == 0) {
                    return null;
                }
                return LocalDate.parse(string);
            }
        };
        birthPicker.setConverter(converter);
    }

    @FXML
    void onClickAboutButton(ActionEvent event) {

    }

    @FXML
    void onClickAddButton(ActionEvent event) {
        Racer racer = new Racer();
        racer.setId(genereteId());
        racer.setName(nameField.getText());
        racer.setBirth(birthPicker.getValue());

        System.out.println(
            ((RadioButton)category.getSelectedToggle()).getId()
        );

        racer.setCategory(null);

        // racerTable.getItems().add();

    }

    private int genereteId() {
        int size = racerTable.getItems().size();
        if(size>0){
            return racerTable.getItems().get(size-1).getId()+1;
        }
        return 1;
    }

    @FXML
    void onClickDeleteButton(ActionEvent event) {

    }

    @FXML
    void onclickModifyButton(ActionEvent event) {

    }

}
