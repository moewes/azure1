package net.moewes.rot.umlaufliste;

import net.moewes.Dao;
import net.moewes.quarkus.odata.EntityCollectionProvider;
import net.moewes.quarkus.odata.EntityProvider;
import net.moewes.quarkus.odata.annotations.ODataService;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@ODataService(value = "Umlaufliste", entityType = "Umlaufliste")
public class UmlauflisteEditService implements EntityProvider<OdataUmlauf>,
        EntityCollectionProvider<OdataUmlauf> {

    @Inject
    Dao<Umlaufliste> dao;

    @Override
    public List<OdataUmlauf> getCollection() {
        return null;
    }

    @Override
    public Optional<OdataUmlauf> find(Map<String, String> keys) {

        String id = keys.get("Id");

        return Optional.empty();
    }

    @Override
    public OdataUmlauf create(Object entity) {
        return null;
    }

    @Override
    public void update(Map<String, String> keys, Object entity) {

    }

    @Override
    public void delete(Map<String, String> keys) {

    }
}
