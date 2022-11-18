import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.util.ArrayList;

public class ExElice {

    public static void main(String[] args) {
        parse("input.xml");
    }

    public static void parse(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            ArrayList<String> parameters = new ArrayList<>();

            ArrayList<ArrayList<String>> data = new ArrayList<>();

            Document document = builder.parse(fileName);

            Element root = document.getDocumentElement();
            NodeList cnodes = root.getChildNodes();

            root.getAttribute("")
            System.out.println(cnodes);

            // 지시사항을 충족하는 코드를 작성하세요.

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}