package com.treenode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created on 3/7/17.
 */
public class Test {
    public static void main(String[] args) throws JsonProcessingException {
        NodeTreeReparser nodeTreeReparser = new NodeTreeReparser();
        ObjectMapper mapper = new ObjectMapper();

        System.out.println(mapper.writeValueAsString(nodeTreeReparser.getTestFinal(testData())));
    }

    private static List<TestEntity> testData() {
        return new ArrayList<>(Arrays.asList(new TestEntity(1, "test,test2,test3,test41"),
                new TestEntity(2, "test,test2,test3,test44"),
                new TestEntity(3, "test,test2,test4"),
                new TestEntity(4, "test2,test3,test4"),
                new TestEntity(6, "test,test2,test4,test5,test8"),
                new TestEntity(10, "test,test2,test4,test6,test7"),
                new TestEntity(11, "test,test2,test4,test6,test10"),
                new TestEntity(7, "test2,test3,test5"),
                new TestEntity(8, "test2,test3,test5,test6")));
    }
}
