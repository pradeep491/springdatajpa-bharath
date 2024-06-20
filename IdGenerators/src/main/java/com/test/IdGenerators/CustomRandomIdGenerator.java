package com.test.IdGenerators;

import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.util.Random;

public class CustomRandomIdGenerator implements IdentifierGenerator {


    @Override
    public Object generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) {
        Random r = new Random();
        int id = 0;
        id = r.nextInt(100000);
        return (long) id;
    }
}
