package com.treenode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TreeNode<T> implements Iterable<TreeNode<T>> {
   @JsonIgnore
   public T data;
   private String viewName;
   public TreeNode<T> parent;
   public List<TreeNode<T>> children;
   private Object idObject;
   @JsonIgnore
   public boolean isRoot() {
       return parent == null;
   }
   @JsonIgnore
   public boolean isLeaf() {
       return children.size() == 0;
   }

   private List<TreeNode<T>> elementsIndex;

   public TreeNode(T data) {
       this.data = data;
       this.children = new LinkedList<TreeNode<T>>();
       this.elementsIndex = new LinkedList<TreeNode<T>>();
       this.elementsIndex.add(this);
   }

   @JsonIgnore
   public TreeNode<T> addChild(T child) {
       TreeNode<T> childNode = new TreeNode<T>(child);
       childNode.parent = this;
       this.children.add(childNode);
       this.registerChildForSearch(childNode);
       return childNode;
   }

   @JsonIgnore
   public int getLevel() {
       if (this.isRoot())
           return 0;
       else
           return parent.getLevel() + 1;
   }

   private void registerChildForSearch(TreeNode<T> node) {
       elementsIndex.add(node);
       if (parent != null)
           parent.registerChildForSearch(node);
   }
   @JsonIgnore
   public TreeNode<T> findTreeNode(Comparable<T> cmp) {
       for (TreeNode<T> element : this.elementsIndex) {
           T elData = element.data;
           if (cmp.compareTo(elData) == 0)
               return element;
       }

       return null;
   }
   @JsonIgnore
   public TreeNode<T> getParent() {
       return parent;
   }

   public String getViewName(){
       String tmpS=(String)data;
       String[]tmp=tmpS.split(",");
       viewName= tmp[tmp.length-1];
       return viewName;
   }

   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public List<TreeNode<T>> getChildren() {
       return children;
   }

   @JsonInclude(JsonInclude.Include.NON_EMPTY)
   public Object getIdObject() {
       return idObject;
   }

   public void setIdObject(Object idObject) {
       this.idObject = idObject;
   }


   @JsonIgnore
   @Override
   public String toString() {
       return data != null ? data.toString() : "[data null]";
   }

   @Override
   public Iterator<TreeNode<T>> iterator() {
       TreeNodeIter<T> iter = new TreeNodeIter<T>(this);
       return iter;
   }



}
