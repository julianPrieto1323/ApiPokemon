package org.vaadin.example;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.contextmenu.GridContextMenu;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class PestanhaListas extends VerticalLayout {
    GreetService greetService = new GreetService();
    public void vistaPestanhas() throws URISyntaxException {
        removeAll();

        ComboBox<Request> comboBox = new ComboBox<Request>("Peticion");
        ArrayList<Request> listaTipoRequest = new ArrayList<Request>();
        listaTipoRequest = greetService.getTodasRequest();
        listaTipoRequest.add(new Request("request", 0));
        comboBox.setItems(listaTipoRequest);
        comboBox.setItemLabelGenerator(Request::getTipo);

        Button buscar = new Button("Buscar");

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(comboBox);

        this.add(horizontalLayout, buscar);



        buscar.addClickListener(event ->{
            switch (comboBox.getValue().getTipo()){
                //poner casos
                case "request":
                    ArrayList<Request> listaRequests = null;
                    try {
                        listaRequests = greetService.getRequest();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    Grid<Request> grid = new Grid();
                    grid.setAllRowsVisible(true);
                    grid.setItems(listaRequests);
                    GridContextMenu<Request> menu = grid.addContextMenu();
                    grid.addColumn(Request::getId).setHeader("ID");
                    grid.addColumn(Request::getTipo).setHeader("Nombre");
                    menu.setOpenOnClick(true);
                    menu.addItem("Delete", evento -> {
                        try {
                            greetService.eliminarPokemon(evento.getItem().get().getId());
                            Notification notification = Notification.show("Animal borrado con éxito!");
                            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (URISyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    removeAll();
                    this.add(horizontalLayout, buscar, grid, menu);
                    break;
                case "pokemon":
                    ArrayList<Pokemon> listaPokemon = new ArrayList<Pokemon>();

                    try {
                        listaPokemon = greetService.getPokemonRegistrados();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    Grid<Pokemon> gridPokemon = new Grid();
                    gridPokemon.setAllRowsVisible(true);
                    gridPokemon.setItems(listaPokemon);
                    GridContextMenu<Pokemon> menuPokemon = gridPokemon.addContextMenu();
                    gridPokemon.addColumn(Pokemon::getId).setHeader("ID");
                    gridPokemon.addColumn(Pokemon::getName).setHeader("Nombre");
                    menuPokemon.setOpenOnClick(true);
                    menuPokemon.addItem("Delete", evento -> {
                        try {
                            greetService.eliminarPokemon(evento.getItem().get().getId());
                            Notification notification = Notification.show("Pokemon borrado con éxito!");
                            notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        } catch (URISyntaxException e) {
                            throw new RuntimeException(e);
                        }
                    });
                    removeAll();
                    this.add(horizontalLayout, buscar, gridPokemon, menuPokemon);
                    break;
                case "berry":
                    ArrayList<Berry> listaBerry = new ArrayList<Berry>();

                    try {
                        listaBerry = greetService.getBerryRegistrados();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    Grid<Berry> gridBerry = new Grid();
                    gridBerry.setAllRowsVisible(true);
                    gridBerry.setItems(listaBerry);
                    GridContextMenu<Berry> menuBerry = gridBerry.addContextMenu();
                    gridBerry.addColumn(Berry::getId).setHeader("ID");
                    gridBerry.addColumn(Berry::getName).setHeader("Nombre");
                    gridBerry.addColumn(Berry::getSize).setHeader("Tamaño");
                    menuBerry.setOpenOnClick(true);
                    removeAll();
                    this.add(horizontalLayout, buscar, gridBerry, menuBerry);
                    break;
                case "move":
                    ArrayList<Moves> listaMoves = new ArrayList<Moves>();

                    try {
                        listaMoves = greetService.getMovesRegistrados();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    Grid<Moves> gridMoves = new Grid();
                    gridMoves.setAllRowsVisible(true);
                    gridMoves.setItems(listaMoves);
                    GridContextMenu<Moves> menuMoves = gridMoves.addContextMenu();
                    gridMoves.addColumn(Moves::getId).setHeader("ID");
                    gridMoves.addColumn(Moves::getName).setHeader("Nombre");
                    gridMoves.addColumn(Moves::getAccuracy).setHeader("Tamaño");
                    menuMoves.setOpenOnClick(true);
                    removeAll();
                    this.add(horizontalLayout, buscar, gridMoves, menuMoves);
                    break;
                case "generation":
                    ArrayList<Generations> listaGeneration = new ArrayList<Generations>();

                    try {
                        listaGeneration = greetService.getGenerationRegistrados();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    Grid<Generations> gridGeneration = new Grid();
                    gridGeneration.setAllRowsVisible(true);
                    gridGeneration.setItems(listaGeneration);
                    GridContextMenu<Generations> menuGeneration = gridGeneration.addContextMenu();
                    gridGeneration.addColumn(Generations::getId).setHeader("ID");
                    gridGeneration.addColumn(Generations::getName).setHeader("Nombre");
                    gridGeneration.addColumn(Generations::getPokemon_species).setHeader("Especies");
                    gridGeneration.addColumn(Generations::getMoves).setHeader("Movimientos");
                    menuGeneration.setOpenOnClick(true);
                    removeAll();
                    this.add(horizontalLayout, buscar, gridGeneration, menuGeneration);
                    break;
                case "ability":
                    ArrayList<Habilidad> listaAbility = new ArrayList<Habilidad>();

                    try {
                        listaAbility = greetService.getAbilitiesRegistrados();
                    } catch (URISyntaxException e) {
                        throw new RuntimeException(e);
                    }
                    Grid<Habilidad> gridAbilities = new Grid();
                    gridAbilities.setAllRowsVisible(true);
                    gridAbilities.setItems(listaAbility);
                    GridContextMenu<Habilidad> menuAbilities = gridAbilities.addContextMenu();
                    gridAbilities.addColumn(Habilidad::getId).setHeader("ID");
                    gridAbilities.addColumn(Habilidad::getName).setHeader("Nombre");
                    gridAbilities.addColumn(Habilidad::getPokemon).setHeader("Pokemon");
                    menuAbilities.setOpenOnClick(true);
                    removeAll();
                    this.add(horizontalLayout, buscar, gridAbilities, menuAbilities);
                    break;
            }
        });


        this.add(horizontalLayout, buscar);
    }

}
