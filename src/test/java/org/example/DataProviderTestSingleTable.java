package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.api.DataProvider;
import org.example.api.IDataProvider;
import org.example.model.single_table.ClientSingleTable;
import org.example.model.single_table.TrainerSingleTable;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class DataProviderSingleTableTest {

    private static final Logger logger = LogManager.getLogger(DataProviderSingleTableTest.class);
    static IDataProvider provider = new DataProvider();
    static ClientSingleTable client= new ClientSingleTable(
            1L, "customName", "customSurname", "login", "password",12, 12);
    static TrainerSingleTable trainer = new TrainerSingleTable(
            2L, "customName", "customSurname","login", "password", 1, 2);

    @Test
    void setUp() {
        provider.insert(client);
        provider.insert(trainer);
    }

    @Test
    void selectAll(){
        provider.selectAllSingleTable();
    }

}