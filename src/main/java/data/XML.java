package data;

import com.thoughtworks.xstream.XStream;

public class XML {
    private XStream mXMLStream;
    public XML() {
        this.mXMLStream = new XStream();
    }

    public String ObjectToXML(Object object) {
        return this.mXMLStream.toXML(object);
    }

    public Object XMLToObject(String XML) {
        return mXMLStream.fromXML(XML);
    }
}
