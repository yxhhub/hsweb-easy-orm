package org.hswebframework.ezorm.core;

import lombok.Getter;
import lombok.Setter;
import org.hswebframework.ezorm.core.MethodReferenceConverter;
import org.junit.Assert;
import org.junit.Test;

import java.io.Serializable;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class StaticMethodReferenceColumnConvertTest {


    @Test
    public void testConvertLambdaColumn() {

        TestClass testClass = new TestClass();

        Assert.assertEquals(MethodReferenceConverter.convertToColumn(TestClass::setEnabled), "enabled");


        Assert.assertEquals(MethodReferenceConverter.convertToColumn(TestClass::getName), "name");

        Assert.assertEquals(MethodReferenceConverter.convertToColumn(TestClass::isEnabled), "enabled");

        Assert.assertEquals(MethodReferenceConverter.convertToColumn(testClass::getName), "name");

        Assert.assertEquals(MethodReferenceConverter.convertToColumn(testClass::isEnabled), "enabled");


    }

    @Getter
    @Setter

    public static class TestClass implements Serializable {
        private String name;

        private boolean enabled;
    }

}