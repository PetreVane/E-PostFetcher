package com.orbSec.controller;

import com.orbSec.EmailManager;
import com.orbSec.constants.ColorThemes;
import com.orbSec.constants.FontSize;
import com.orbSec.view.Coordinator;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Slider;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class OptionsWindowController extends BaseController implements Initializable {

    public OptionsWindowController(EmailManager emailManager, Coordinator coordinator, String fxmlName) {
        super(emailManager, coordinator, fxmlName);
    }

    @FXML
    private Slider fontSizeSlider;

    @FXML
    private ChoiceBox<ColorThemes> themePicker;

    @FXML
    void applyChangesPressed() {
        System.out.println("apply changes pressed");
        coordinator.dismissOptionsScreen();

    }

    @FXML
    void cancelButtonPressed() {
        System.out.println("Cancel button pressed");
        coordinator.dismissOptionsScreen();

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        configureThemePicker();
        configureFontSizeSlider();
    }

    private void configureFontSizeSlider() {
        fontSizeSlider.setMin(0);
        fontSizeSlider.setMax(FontSize.values().length -1);
        fontSizeSlider.setValue(coordinator.getFontSize().ordinal());
        fontSizeSlider.setMajorTickUnit(1);
        fontSizeSlider.setMinorTickCount(0);
        fontSizeSlider.setBlockIncrement(1);
        fontSizeSlider.setSnapToTicks(true);
        fontSizeSlider.setShowTickLabels(true);
        fontSizeSlider.setShowTickMarks(true);
        fontSizeSlider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double object) {
                int i = object.intValue();
                return FontSize.values()[i].toString();
            };

            @Override
            public Double fromString(String string) {
                return null;
            }
        });

        fontSizeSlider.valueProperty().addListener((listener, oldValue, newValue) -> {
            fontSizeSlider.setValue(newValue.intValue());
        });

    }

    private void configureThemePicker() {
        themePicker.setItems(FXCollections.observableArrayList(ColorThemes.values()));
        themePicker.setValue(coordinator.getColorTheme());
    }
}
