package org.vaadin.example;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;

public class NuevoTweet extends VerticalLayout {
    GreetService greetService = new GreetService();

    public void vistaNuevoTweet() throws URISyntaxException {
        removeAll();
        H1 h1 = new H1("Introduzca la peticion");
        ComboBox<Request> comboBox = new ComboBox<Request>("Peticion");
        comboBox.setItems(greetService.getTodasRequest());
        comboBox.setItemLabelGenerator(Request::getTipo);

        TextField id = new TextField("ID");
        Button aceptar = new Button("Aceptar");

        FormLayout formLayout = new FormLayout();
        formLayout.add(
                id
        );
        formLayout.setResponsiveSteps(
                // Use one column by default
                new FormLayout.ResponsiveStep("0", 1),
                // Use two columns, if layout's width exceeds 500px
                new FormLayout.ResponsiveStep("500px", 2)
        );
// Stretch the username field over 2 columns
        formLayout.setColspan(id, 2);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(comboBox, formLayout);
        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        horizontalLayout1.add(aceptar);

        aceptar.addClickListener(event -> {
            Request tweetNuevo = new Request();

            tweetNuevo.setId(Integer.parseInt(id.getValue()));
            tweetNuevo.setTipo(comboBox.getValue().getTipo());

            try {
                String respuesta = greetService.getPokemons(tweetNuevo).toString();
                TextArea textArea = new TextArea();
                textArea.setWidthFull();
                textArea.setLabel("Description");
                textArea.setValue(respuesta);
                removeAll();

                this.add(h1, horizontalLayout, horizontalLayout1, textArea);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        this.add(h1, horizontalLayout, horizontalLayout1);
    }
}
