package string;

import utilities.CodeRustUtils;
import utilities.TreeNode;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Stack;

public class XMLToTree {

    public static void main(String[] args) {
        String xml = "<html><body><div><h1>CodeRust</h1><a>http://coderust.com</a></div><div><h2>Chapter 1</h2>" +
                "</div><div><h3>Chapter 2</h3><h4>Chapter 2.1</h4></div></body></html>";
        try {
            TreeNode stringTreeNode = createXmlTree(xml);
            System.out.println(CodeRustUtils.toStringTree(stringTreeNode));
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static TreeNode createXmlTree(String xml) throws XMLStreamException {
        InputStream is = new ByteArrayInputStream(xml.getBytes());
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLStreamReader reader = factory.createXMLStreamReader(is);
        Stack<TreeNode> stack = new Stack<>();

        TreeNode last = null;

        while (reader.hasNext()) {
            if (reader.getEventType() == XMLStreamConstants.START_DOCUMENT ||
                    reader.getEventType() == XMLStreamConstants.SPACE ||
                    reader.getEventType() == XMLStreamConstants.END_DOCUMENT) {
                reader.next();
                continue;
            } else if (reader.getEventType() == XMLStreamConstants.END_ELEMENT) {
                if (!stack.empty()) {
                    last = stack.pop();
                }
                reader.next();
                continue;
            }
            if (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                TreeNode node = new TreeNode(reader.getLocalName());

                if (!stack.empty()) {
                    stack.peek().getChildren().add(node);
                }
                stack.push(node);
            } else if (reader.getEventType() == XMLStreamConstants.CHARACTERS) {
                TreeNode node = new TreeNode(reader.getText());

                if (!stack.empty()) {
                    stack.peek().getChildren().add(node);
                }
            }
            reader.next();
        }
        return last;
    }
}

