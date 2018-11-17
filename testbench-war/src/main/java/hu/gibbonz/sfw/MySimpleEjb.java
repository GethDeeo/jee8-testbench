package hu.gibbonz.sfw;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.StringReader;

@Stateless
@LocalBean
public class MySimpleEjb {
    public void simpleMethod() {
        final String result = "{\"name\":\"Falco\",\"age\":3,\"bitable\":false}";
        final JsonParser parser = Json.createParser(new StringReader(result));
        String key;
        String value;
        while (parser.hasNext()) {
            final JsonParser.Event event = parser.next();
            switch (event) {
                case KEY_NAME:
                    key = parser.getString();
                    System.out.println(key);
                    break;
                case VALUE_STRING:
                    value = parser.getString();
                    System.out.println(value);
                    break;
            }
        }
        parser.close();
    }
}
