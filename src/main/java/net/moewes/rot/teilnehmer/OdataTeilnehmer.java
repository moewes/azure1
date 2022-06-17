package net.moewes.rot.teilnehmer;

import lombok.Data;
import net.moewes.quarkus.odata.annotations.EntityKey;
import net.moewes.quarkus.odata.annotations.ODataEntity;

@ODataEntity("Todo")
@Data
public class OdataTeilnehmer {

    @EntityKey
    private String email;

    private String name;
}
