package net.moewes.json.repository;

import net.moewes.json.manifest.Ui5Manifest;
import net.moewes.json.manifest.Ui5ManifestApp;
import net.moewes.json.manifest.Ui5ManifestUi;
import net.moewes.json.manifest.Ui5ManifestUi5;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AppRepository {

    public Ui5Manifest getManifestForApp(String appname) {

        Ui5Manifest manifest = new Ui5Manifest();
        manifest.setVersion("1.12.0");

        Ui5ManifestApp app = new Ui5ManifestApp();
        manifest.setApp(app);

        Ui5ManifestUi ui = new Ui5ManifestUi();
        manifest.setUi(ui);

        Ui5ManifestUi5 ui5 = new Ui5ManifestUi5();
        manifest.setUi5(ui5);

        return manifest;
    }
}
