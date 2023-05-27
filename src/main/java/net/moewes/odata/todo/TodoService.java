package net.moewes.odata.todo;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import com.microsoft.azure.storage.StorageException;
import jakarta.inject.Inject;
import lombok.SneakyThrows;
import net.moewes.Dao;
import net.moewes.app.todo.Todo;
import net.moewes.quarkus.odata.EntityCollectionProvider;
import net.moewes.quarkus.odata.EntityProvider;
import net.moewes.quarkus.odata.annotations.ODataEntitySet;

@ODataEntitySet(value = "Todos", entityType = "Todo")
public class TodoService implements EntityProvider<TodoOdataEntity>,
        EntityCollectionProvider<TodoOdataEntity> {

    @Inject
    Dao<Todo> dao;

    @Inject
    TodoMapper mapper;

    @SneakyThrows
    @Override
    public List<TodoOdataEntity> getCollection() {

        return dao.getAll().stream().map(item -> mapper.toOdata(item)).collect(Collectors.toList());
    }

    @Override
    public Optional<TodoOdataEntity> find(Map<String, String> keys) {

        TodoOdataEntity odataEntity = null;
        try {
            Todo todo = dao.get(keys.get("PartitionKey"), keys.get("RowKey"));
            odataEntity = mapper.toOdata(todo);
        } catch (URISyntaxException e) {
            e.printStackTrace(); // FIXME
        } catch (StorageException e) {
            e.printStackTrace(); // FIXME
        }
        return Optional.ofNullable(odataEntity);
    }

    @Override
    public TodoOdataEntity create(Object odataEntity) {

        Todo entity = mapper.toEntity((TodoOdataEntity) odataEntity);
        if (entity.getPartitionKey() == null) {
            entity.setPartitionKey(UUID.randomUUID().toString());
            entity.setRowKey(UUID.randomUUID().toString());
        }
        try {
            dao.save(entity);
            entity = dao.get(entity.getPartitionKey(), entity.getRowKey());
            return mapper.toOdata(entity);
        } catch (URISyntaxException e) { // FIXME
            e.printStackTrace();
        } catch (StorageException e) { // FIXME
            e.printStackTrace();
        }
        return null;
    }

    @SneakyThrows
    @Override
    public void update(Map<String, String> keys, Object odataEntity) {

        Todo entity = mapper.toEntity((TodoOdataEntity) odataEntity);
        entity.setRowKey(keys.get("RowKey"));
        entity.setPartitionKey(keys.get("PartitionKey"));
        dao.save(entity);
    }

    @SneakyThrows
    @Override
    public void delete(Map<String, String> keys) {

        Todo todo = dao.get(keys.get("PartitionKey"), keys.get("RowKey"));
        if (todo != null) {
            dao.delete(todo);
        } else {
            // TODO error?
        }
    }
}
