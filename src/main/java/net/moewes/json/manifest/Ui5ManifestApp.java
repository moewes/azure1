package net.moewes.json.manifest;

import lombok.Data;

@Data
public class Ui5ManifestApp {

    private String id;
    private String type = "application";
    private String title;
    private String description;

    /*
    "i18n": "i18n/i18n.properties",
    "applicationVersion": {
      "version": "0.0.1"
    },
  
    "dataSources": {
			"default": {
				"uri": "http://localhost:8080/odata/",
				"type": "OData",
				"settings": {
					"odataVersion": "4.0"
				}
			}
     */
}
