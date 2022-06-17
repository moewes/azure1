package net.moewes.rot.teilnehmer;

import com.microsoft.azure.storage.table.TableServiceEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Teilnehmer extends TableServiceEntity {

    private String email;
    private String name;
}
