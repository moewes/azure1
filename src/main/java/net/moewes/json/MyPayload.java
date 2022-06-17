package net.moewes.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class MyPayload {

    @JsonProperty("_version")
    private String version;
    @JsonProperty("sap.title")
    private String title;
    private List<MyRoute> routes;
}
