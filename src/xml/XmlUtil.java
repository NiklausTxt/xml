package xml;

import java.io.File;
import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.*;

public class XmlUtil {

    public static void toXML(Object obj) {
        try {
            JAXBContext context = JAXBContext.newInstance(obj.getClass());

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "UTF-8");// //�����ʽ
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);// �Ƿ��ʽ�����ɵ�xml��
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, false);// �Ƿ�ʡ��xmͷ������Ϣ
//            StringWriter writer = new StringWriter();
            marshaller.marshal(obj, new File("user.xml"));
//            return writer.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T fromXML(String xml, Class<T> valueType) {
        try {
            JAXBContext context = JAXBContext.newInstance(valueType);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            return (T) unmarshaller.unmarshal(new StringReader(xml));
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
