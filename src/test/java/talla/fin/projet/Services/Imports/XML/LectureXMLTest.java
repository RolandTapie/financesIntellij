package talla.fin.projet.Services.Imports.XML;

import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class LectureXMLTest {

    @Test
    void TestExecution() throws IOException, SAXException {
        System.out.println("test Import XML ");
        assertEquals("Import OK",LectureXML.Execution());
    }
}