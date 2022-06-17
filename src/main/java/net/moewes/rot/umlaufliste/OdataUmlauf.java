package net.moewes.rot.umlaufliste;

import lombok.Data;
import net.moewes.quarkus.odata.annotations.EntityKey;
import net.moewes.quarkus.odata.annotations.ODataEntity;

@ODataEntity("Umlaufliste")
@Data
public class OdataUmlauf {

    @EntityKey
    private String id;
    private String title;
    private String description;
}
