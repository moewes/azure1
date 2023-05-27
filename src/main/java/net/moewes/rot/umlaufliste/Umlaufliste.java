package net.moewes.rot.umlaufliste;

import com.microsoft.azure.storage.table.TableServiceEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@NoArgsConstructor
public class Umlaufliste extends TableServiceEntity {

    private String title;
    private String description;
    private LocalDate datum;
    private LocalTime beginn;
    private LocalTime ende;
}
