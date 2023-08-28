package org.example.layout;

import lombok.Data;

import javax.swing.*;
import java.awt.*;

@Data
public class MainPage {
    private JPanel mainPage;

    public MainPage() {
        this.mainPage = new JPanel(new BorderLayout());
        FormPanel formPanel = new FormPanel();
        mainPage.add(formPanel.getFormPanel(),BorderLayout.CENTER);

        mainPage.setVisible(true);
    }
}
