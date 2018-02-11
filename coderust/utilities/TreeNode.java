package utilities;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    private List<TreeNode> children = new ArrayList<>();
    private String data;

    public TreeNode(String data) {
        this.data = data;
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public List<TreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<TreeNode> children) {
        this.children = children;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
