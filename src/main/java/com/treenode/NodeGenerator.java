package com.treenode;

import java.util.*;

/**
 * Created on 3/7/17.
 */
 class NodeGenerator {
    private static Comparator<String>comparator= (t0, t1) -> t0.compareTo(t1);

    private static   Set<String> reparce(List<String> list) {
        Set<String> res = new HashSet<>();
        for (String s : list) {
            String[] subStrings = s.split(",");
            res.add(s);
            String tmp = "";
            for (int i=0;i<subStrings.length;i++) {
                if (i==0){
                    tmp=tmp+subStrings[i];
                    res.add(tmp);
                }
                if (i>0){
                    tmp=tmp+","+subStrings[i];
                    res.add(tmp);
                }

            }
        }
        return res;
    }

    public List<Node> generateNodes(List<String> data) {
        Set<String> strings=reparce(data);
        List<String>stringList=new ArrayList<>(strings);
        Collections.sort(stringList,NodeGenerator.comparator);

        Collections.sort(stringList, (o1, o2) -> o1.split(",").length-o2.split(",").length);

        List<Node> nodes = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {

            int length = stringList.get(i).split(",").length - 1; // -1 means.. without empty string
            for (int s = 0; s < length; s++) {
//                System.out.print("-- ");
            }
            if (i == 0) {
                Node node = new Node(stringList.get(i));
                nodes.add(node);
            }
            if (i > 0) {
                Node node = new Node(stringList.get(i));
                nodes.add(node);
            }

//            System.out.println(stringList.get(i));

        }
        return nodes;
    }

}
