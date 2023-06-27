package org.vaadin.example;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class PestanhaListas extends VerticalLayout {
    GreetService greetService = new GreetService();
    public void vistaPestanhas() throws URISyntaxException {
        removeAll();
        ArrayList<Request> listatweets = greetService.getRequest();
        Grid<Request> grid = new Grid();
        grid.setAllRowsVisible(true);
        grid.setItems(listatweets);
        GridContextMenu<Request> menu = grid.addContextMenu();

        grid.addColumn(Request::getId).setHeader("ID");
        grid.addColumn(Request::getTipo).setHeader("Nombre");

        menu.setOpenOnClick(true);
        menu.addItem("Delete", event -> {
            try {
                greetService.eliminarPokemon(event.getItem().get().getId());
                Notification notification = Notification.show("Animal borrado con éxito!");
                notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (URISyntaxException e) {
                throw new RuntimeException(e);
            }
        });
        grid.setAllRowsVisible(true);
        grid.setItems(listatweets);
        this.add(grid, menu);
    }

}
