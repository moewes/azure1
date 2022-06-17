package net.moewes.rot.umlaufliste;

import org.mapstruct.Mapper;

@Mapper(componentModel = "cdi")
public interface UmlaufMapper {

    OdataUmlauf toOdata(UmlaufMapper entity);

    Umlaufliste toEntity(OdataUmlauf data);
}
