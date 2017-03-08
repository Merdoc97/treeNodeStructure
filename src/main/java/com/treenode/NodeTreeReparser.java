package com.treenode;

import java.util.*;

/**
 * General class for reparser
 * this class is entry point for whole algorithm it gets List of entities and reparse it to tree view
 * currently it adopted to json structure
 * this parser can be adopted for any entity which has name in coma separated structure
 * example test1,test2,test3,test4,test5
 */
public class NodeTreeReparser {
    private final NodeGenerator nodeGenerator = new NodeGenerator();

    public List<TreeNode<String>> getTestFinal(List<TestEntity> data) {
        List<TreeNode<String>> result = new ArrayList<>();

        LinkedHashMap<String, List<TestEntity>> listLinkedHashMap = getGeneralParent(data);

        Map<String, TestEntity> tmpValues = getMapValues(listLinkedHashMap);

        listLinkedHashMap.forEach((s, testList) -> {
            List<String> tmp = new ArrayList<String>();
            testList.forEach(testEntity -> tmp.add(testEntity.getName()));
            TreeNode<String> treeNode = NodeTreeReparser.genearteTreeNode(nodeGenerator.generateNodes(tmp));
            tmpValues.forEach((tmpKey, testEntity) -> {
                TreeNode<String> node = treeNode.findTreeNode(findByCriteria(tmpKey));
                if (Objects.nonNull(node)) node.setIdObject(testEntity);
            });
            result.add(treeNode);

        });

        return result;

    }

    private static Map<String, TestEntity> getMapValues(LinkedHashMap<String, List<TestEntity>> map) {
        Map<String, TestEntity> res = new LinkedHashMap<>();
        map.forEach((s, testNodes) -> {
            testNodes.forEach(testEntity -> {
                res.put(testEntity.getName(), testEntity);
            });
        });
        return res;
    }

    private static LinkedHashMap<String, List<TestEntity>> getGeneralParent(List<TestEntity> testList) {
        LinkedHashMap<String, List<TestEntity>> map = new LinkedHashMap<>();
        while (testList.size() > 0) {
            List<TestEntity> resList = new ArrayList<>();
            String parentName = testList.get(0).getName().split(",")[0];
            testList.forEach(test -> {
                if (test.getName().split(",")[0].equalsIgnoreCase(parentName)) {
                    resList.add(test);
                }

            });
            testList.removeAll(resList);
            map.put(parentName, resList);
        }
        return map;
    }


    private static TreeNode<String> genearteTreeNode(List<Node> resList) {
        TreeNode<String> treeNode = new TreeNode<>(resList.get(0).getValue());
        for (int i = 1; i < resList.size(); i++) {
            TreeNode<String> node = treeNode.findTreeNode(findByCriteria(resList.get(i).getParentName()));
            node.addChild(resList.get(i).getValue());
        }
        return treeNode;
    }

    private static Comparable<String> findByCriteria(String searchCriteria) {
        Comparable<String> stringComparable = treeData -> {
            boolean nodeOk = treeData.equals(searchCriteria);
            return nodeOk ? 0 : 1;
        };
        return stringComparable;
    }
}
