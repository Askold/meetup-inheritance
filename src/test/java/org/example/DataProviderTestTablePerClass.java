package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.api.DataProvider;
import org.example.api.IDataProvider;
import org.example.model.table_per_class.ClientTablePerClass;
import org.example.model.table_per_class.TrainerTablePerClass;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Optional;

class DataProviderTablePerClassTest {

    private static final Logger logger = LogManager.getLogger(DataProviderTablePerClassTest.class);
    static IDataProvider provider = new DataProvider();
    static ClientTablePerClass client= new ClientTablePerClass(
            1L, "customName", "customSurname","login", "password", 12, 12);
    static TrainerTablePerClass trainer = new TrainerTablePerClass(
            2L, "customName", "customSurname","login", "password", 1, 2);

    @Test
    void a() {
        provider.insert(client);
        provider.insert(trainer);
    }

    @Test
    void selectAll(){
        provider.selectAllPerClass();
    }

}