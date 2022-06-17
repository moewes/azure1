package net.moewes.json.manifest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ui5Manifest {

    @JsonProperty("_version")
    private String version;
    @JsonProperty("sap.app")
    private Ui5ManifestApp app;
    @JsonProperty("sap.ui")
    private Ui5ManifestUi ui;
    @JsonProperty("sap.ui5")
    private Ui5ManifestUi5 ui5;

}
