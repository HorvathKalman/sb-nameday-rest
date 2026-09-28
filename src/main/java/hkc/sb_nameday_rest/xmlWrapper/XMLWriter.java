package hkc.sb_nameday_rest.xmlWrapper;

import hkc.sb_nameday_rest.model.NameDay;
import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.StringWriter;
import java.util.List;

public class XMLWriter {

    public  String writeNameDays(List<NameDay> nameDays) {

        try {

            Document doc = new Document();

            Element rootElement = new Element("nameDays");

            for (NameDay nameDay : nameDays) {

                Element nameDayElement = new Element("nameDay");

                Element nameElement = new Element("name");
                nameElement.setText(nameDay.getName());

                Element dateElement = new Element("date");
                dateElement.setText(nameDay.getDate());

                nameDayElement.addContent(nameElement);
                nameDayElement.addContent(dateElement);

                rootElement.addContent(nameDayElement);
            }

            doc.setRootElement(rootElement);

            StringWriter stringWriter = new StringWriter();

            XMLOutputter outputter =
                    new XMLOutputter(Format.getPrettyFormat());

            outputter.output(doc, stringWriter);

            return stringWriter.toString();

        } catch (Exception e) {


            e.printStackTrace();
            return null;
        }
    }
}
