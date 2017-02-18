
package com.company;

import java.util.Map;

//一棵二叉树
public class BinaryTree {
    private Node root;

    private int size;

    public BinaryTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    /**
     * 往一棵二叉树塞一个值
     *
     * @param value
     * @return
     */

    public boolean put(String key, Object value) {
        MyEntry entry = new MyEntry(key, value);

        Node current = root;
        Node parent = null;
        if (null == root) {
            root = new Node(key.hashCode(), entry, null, null, null);
        } else {
            while (current != null) {
                parent = current;
                if (current.key < key.hashCode()) {
                    current = current.right;
                } else if (current.key == key.hashCode() && current.value.getKey().equals(key)) {
                    current.value.setValue(value);
                    return true;
                } else {
                    current = current.left;
                }
            }
            if (parent.key <= key.hashCode()) {
                parent.right = new Node(key.hashCode(), entry, parent, null, null);
            } else {
                parent.left = new Node(key.hashCode(), entry, parent, null, null);
            }

        }
        size++;
        return true;
    }

    /**
     * 获取值树中首次出现，若找不到返回null
     *
     * @param key
     * @return
     */

    public Object get(String key) {
        Node current = root;
        while (current != null) {
            if (current.key == key.hashCode() && current.value.getKey().equals(key))
                return current.value.getValue();
            else if (current.key < key.hashCode()) {
                current = current.right;
            } else if (current.key > key.hashCode()) {
                current = current.left;
            }
        }
        return null;
    }


    /**
     * 查询值是否在二叉树中
     *
     * @param key
     */

    public boolean Exist(String key) {
        return null != get(key);
    }

    /**
     * delete a value
     *
     * @param key
     */

    public void delete(String key) {
        Node current = root;
        while (current != null) {
            if (current.key == key.hashCode() && current.value.getKey().equals(key)) {
                if (current == root) {
                    deleteRoot();
                    break;
                } else {
                    deleteNode(current);
                    break;
                }
            } else if (key.hashCode() < current.key) {
                current = current.left;
            } else if (key.hashCode() > current.key) {
                current = current.right;
            }
        }
        size--;
        if (Exist(key)) {
            delete(key);
        }
    }

    private void deleteNode(Node node) {
        if (node.left == null && node.right == null) {
            if (node.equals(node.parent.left)) {
                node.parent.left = null;
            } else {
                node.parent.right = null;
            }
        } else if (node.left == null) {
            if (node.equals(node.parent.left)) {
                node.parent.left = node.right;
            } else {
                node.parent.right = node.right;
            }
        } else if (node.right == null) {
            if (node.equals(node.parent.right)) {
                node.parent.left = node.left;
            } else {
                node.parent.right = node.left;
            }
        }

    }

    private void deleteRoot() {
        Node left = root.left;
        root = root.right;
        root.parent = null;
        Node current = root;
        while (current.left != null) {
            current = current.left;
        }
        current.left = left;
    }

    private static class Node {
        int key;
        Map.Entry value;
        Node parent;
        Node left;
        Node right;

        public Node(int key, Map.Entry value, Node parent, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }
    }

    private static class MyEntry implements Map.Entry {
        private String key;
        private Object value;

        public MyEntry(String key, Object value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public Object getKey() {
            return key;
        }

        @Override
        public Object getValue() {
            return value;
        }

        @Override
        public Object setValue(Object value) {
            this.value = value;
            return this.value;
        }
    }
}
