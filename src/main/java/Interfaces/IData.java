package Interfaces;

import java.util.Optional;

public interface IData <Entity, IdType> {
    Optional<Entity> add(Entity entity);
    int delete(IdType idType);

}
