package tree;

import java.util.List;

/**
 * Created by Zephery on 2016/7/26.
 */
public class TreeParentTest {
    public static void main(String args[]) {
        TreeParent<String> tp = new TreeParent<String>("root");
        TreeParent.Node root = tp.root();
        System.out.println(root);
        tp.addNode("jiadian1", root);
        System.out.println("deep" + tp.deep());
        tp.addNode("jiedian2", root);
        List<TreeParent.Node<String>> nodes = tp.children(root);
        System.out.println("the first" + nodes.get(0));
        tp.addNode("jiedian3", nodes.get(0));
        System.out.println("deep:" + tp.deep());
    }
}
