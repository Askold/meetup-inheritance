package org.example;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.example.api.DataProvider;
import org.example.api.IDataProvider;
import org.example.model.mapped_superclass.ClientMappedSuperClass;
import org.example.model.mapped_superclass.TrainerMappedSuperClass;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.Optional;

class DataProviderMappedSuperClassTest {
    static IDataProvider provider = new DataProvider();
    static ClientMappedSuperClass client= new ClientMappedSuperClass(
            1L, "customName", "customSurname", "login", "password",12, 12);
    static TrainerMappedSuperClass trainer = new TrainerMappedSuperClass(
            2L, "customName", "customSurname", "login", "password", 1, 2);

    @Test
    void setUp() {
        Assertions.assertTrue(provider.insert(client));
        Assertions.assertTrue(provider.insert(trainer));
    }

    @Test
    void select(){
       // provider.selectAllMapped();
    }

}