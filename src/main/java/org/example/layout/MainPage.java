package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class MainPage {
    private JPanel mainPage;

    public MainPage() {
        this.mainPage = new JPanel();
        BoxLayout boxLayout = new BoxLayout(mainPage,BoxLayout.Y_AXIS);
        mainPage.setLayout(boxLayout);
        FormPanel formPanel = new FormPanel();
        mainPage.add(formPanel.getFormPanel());

        ButtonPanel buttonPanel = new ButtonPanel(formPanel);
        TablePanel tablePanel = new TablePanel(formPanel,buttonPanel);
        buttonPanel.setTablePanel(tablePanel);

        mainPage.add(buttonPanel.getButtonPanel());
        mainPage.add(tablePanel.getTablePanel());

        mainPage.setVisible(true);
    }
}
