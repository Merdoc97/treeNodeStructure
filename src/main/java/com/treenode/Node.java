package com.treenode;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created on 3/7/17.
 */
public class Node {
    private String parentName;
    private String value;
    private String name;
    public Node() {
    }

    public Node(String value) {
        this.value = value;
        String[]tmp=value.split(",");
        if (tmp.length>1) {
            this.parentName = value.split(tmp[tmp.length - 1])[0];
            this.parentName = parentName.substring(0, parentName.length() - 1);
            this.name=tmp[tmp.length-1];
        }

    }

    public Node(String value, String parent) {
        this.value = value;
        this.parentName=parent;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
    @JsonIgnore
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Node{" +
                "parentName='" + parentName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
