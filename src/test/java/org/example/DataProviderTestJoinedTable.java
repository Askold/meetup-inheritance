package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.api.DataProvider;
import org.example.api.IDataProvider;
import org.example.model.joined_table.ClientJoinedTable;
import org.example.model.joined_table.TrainerJoinedTable;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Optional;

class DataProviderJoinedTableTest {

    private static final Logger logger = LogManager.getLogger(DataProviderJoinedTableTest.class);
    static IDataProvider provider = new DataProvider();
    static ClientJoinedTable client= new ClientJoinedTable(
            1L, "customName", "customSurname", "login", "password", 12, 12);
    static TrainerJoinedTable trainer = new TrainerJoinedTable(
            2L, "customName", "customSurname", "login", "password", 1, 2);

    @Test
    void setUp() {
        provider.insert(client);
        provider.insert(trainer);
    }

    @Test
    void selectAll(){
        provider.selectAllJoinedTable();
    }
}