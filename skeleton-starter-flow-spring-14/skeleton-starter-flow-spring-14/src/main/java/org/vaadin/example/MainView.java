package org.vaadin.example;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URISyntaxException;

/**
 * A sample Vaadin view class.
 * <p>
 * To implement a Vaadin view just extend any Vaadin component and
 * use @Route annotation to announce it in a URL as a Spring managed
 * bean.
 * Use the @PWA annotation make the application installable on phones,
 * tablets and some desktop browsers.
 * <p>
 * A new instance of this class is created for every new user and every
 * browser tab/window.
 */
@Route
@PWA(name = "Vaadin Application",
        shortName = "Vaadin App",
        description = "This is an example Vaadin application.",
        enableInstallPrompt = false)
@CssImport("./styles/shared-styles.css")
@CssImport(value = "./styles/vaadin-text-field-styles.css", themeFor = "vaadin-text-field")
public class MainView extends VerticalLayout {

    /**
     * Construct a new Vaadin view.
     * <p>
     * Build the initial UI state for the user accessing the application.
     *
     * @param service The message service. Automatically injected Spring managed bean.
     */
    public MainView(@Autowired GreetService service) throws URISyntaxException {
        Tab alta = new Tab("Alta");
        Tab listado = new Tab("Listados");

        Tabs tabs = new Tabs(alta, listado);
        NuevoTweet formulario = new NuevoTweet();
        formulario.vistaNuevoTweet();
        PestanhaListas pestanhaListas = new PestanhaListas();

        formulario.setVisible(true);
        pestanhaListas.setVisible(false);
        tabs.setSelectedTab(alta);
        tabs.addSelectedChangeListener(event -> {
            if (event.getSelectedTab().equals(alta)) {
                formulario.setVisible(true);
                try {
                    formulario.vistaNuevoTweet();
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                pestanhaListas.setVisible(false);
            } else {
                pestanhaListas.setVisible(true);
                try {
                    pestanhaListas.vistaPestanhas();
                } catch (URISyntaxException e) {
                    throw new RuntimeException(e);
                }
                formulario.setVisible(false);
            }
        });
        this.add(tabs, formulario, pestanhaListas);
        this.setAlignItems(Alignment.CENTER);
    }

}
