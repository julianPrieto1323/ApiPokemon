package org.vaadin.example;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.Date;

public class NuevoTweet extends VerticalLayout {
    GreetService greetService = new GreetService();

    public void vistaNuevoTweet(){
        removeAll();
        TextField id = new TextField("ID");
        TextField tipo = new TextField("nombre");

        Button aceptar = new Button("Aceptar");

        FormLayout formLayout = new FormLayout();
        formLayout.add(
                id, tipo
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
        horizontalLayout.add(formLayout);
        HorizontalLayout horizontalLayout1 = new HorizontalLayout();
        horizontalLayout1.add(aceptar);

        aceptar.addClickListener(event -> {
            Request tweetNuevo = new Request();

            tweetNuevo.setId(Integer.parseInt(id.getValue()));
            tweetNuevo.setTipo(tipo.getValue());

            try {
                greetService.getPokemons(tweetNuevo);
                removeAll();
                PestanhaListas pestanhaListas = new PestanhaListas();
                pestanhaListas.vistaPestanhas();
                this.add(pestanhaListas);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        this.add(horizontalLayout, horizontalLayout1);
    }
}
