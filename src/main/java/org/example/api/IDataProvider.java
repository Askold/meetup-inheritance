package org.example.api;

import org.example.model.joined_table.UserJoinedTable;
import org.example.model.mapped_superclass.UserMappedSuperClass;
import org.example.model.single_table.UserSingleTable;
import org.example.model.table_per_class.UserTablePerClass;

import java.util.List;
import java.util.Optional;

public interface IDataProvider {
    <T> boolean insert(T object);
    <T> Optional<T> getById(Class<T> tClass, long id);
    <T> boolean update(T object);
    <T> boolean delete(T object);
    List<UserTablePerClass> selectAllPerClass();
    List<UserSingleTable> selectAllSingleTable();
    List<UserJoinedTable> selectAllJoinedTable();
}
