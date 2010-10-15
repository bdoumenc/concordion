package test.concordion.extension;

import org.concordion.api.Element;
import org.concordion.api.listener.ExecuteEvent;
import org.concordion.api.listener.ExecuteListener;

public class ExecuteLogger implements ExecuteListener {
    public void executeCompleted(ExecuteEvent e) {
        Element element = e.getElement();
        if (element.getLocalName().equals("tr")) {
            StringBuilder sb = new StringBuilder();
            sb.append("Execute '");
            Element[] childElements = element.getChildElements();
            boolean firstChild = true;
            for (Element child : childElements) {
                if (firstChild) {
                    firstChild = false;
                } else {
                    sb.append(", ");
                }
                sb.append(child.getText());
            }
            sb.append("'");
            System.out.println(sb.toString());
        } else {
            System.out.println("Execute '" + element.getText() + "'");
        }
    }
}