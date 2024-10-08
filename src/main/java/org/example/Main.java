package org.example;
//
//
////1. Allgemeine Einführung in XML-Parser (Seite 352):
////        XML-Parser sind Werkzeuge, die XML-Daten in einer Form einlesen und verarbeiten, die für Anwendungen nutzbar ist. Java bietet mehrere Methoden und Bibliotheken zur Verarbeitung von XML, darunter SAX, DOM, JDOM, Pull-Parser und JAXB.
////
////        2. SAX-Parser (Seite 355):
////        SAX (Simple API for XML) ist ein ereignisbasierter Parser.
////        Funktioniert durch sequentielles Lesen von XML-Dokumenten und löst Ereignisse aus, wenn bestimmte Tags gefunden werden.
////        Vorteil: Geringer Speicherverbrauch, da nicht das gesamte Dokument in den Speicher geladen wird.
////        Nachteil: Nur lesend, keine Möglichkeit, das Dokument direkt zu ändern.
////        Anwendungsfall: Ideal für große Dokumente, bei denen nur auf spezifische Daten zugegriffen werden soll.
//
////SAXParser parser:
//
//
//
//import org.xml.sax.Attributes;
//import org.xml.sax.SAXException;
//import org.xml.sax.helpers.DefaultHandler;
////  Eine Standardimplementierung des ContentHandler-Interfaces, die Ereignisse wie startElement und endElement definiert.
//
//import javax.xml.parsers.SAXParser;
//import javax.xml.parsers.SAXParserFactory;
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            // Initialisiere SAX Parser
//            SAXParserFactory factory = SAXParserFactory.newInstance();
//            // Erstellt eine Instanz der SAXParserFactory.
//            //SAXParserFactory ist eine Factory-Klasse, die Objekte des Typs SAXParser erzeugt.
//
//            SAXParser saxParser = factory.newSAXParser();
//            // Erstellt einen neuen SAXParser auf Grundlage der Factory.
//
//            // Hier wird ein anonymer DefaultHandler definiert, der die verschiedenen Ereignismethoden (startElement, endElement, characters) implementiert.
//            //Der Handler ist das Herzstück des SAX-Parsers, da er die Reaktionen auf die XML-Ereignisse definiert.
//            DefaultHandler handler = new DefaultHandler() {
//                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//                    System.out.println("Start Element: " + qName);
//                }// // parameter-:
//                //Diese Methode wird aufgerufen, wenn der Parser auf den Start eines XML-Elements trifft.
//                //Parameter:
//                //String uri: Der Namespace des Elements (normalerweise leer).
//                //String localName: Der lokale Name des Elements (ohne Präfix).
//                //String qName: Der vollständige Name des Elements (inklusive Präfix).
//                //Attributes attributes: Enthält die Attribute des Elements.
//
//                public void endElement(String uri, String localName, String qName) throws SAXException {
//                    System.out.println("End Element: " + qName);
//                }
//
//                public void characters(char[] ch, int start, int length) throws SAXException {
//                    System.out.println("Content: " + new String(ch, start, length));
//                }
//            };// Diese Methode wird aufgerufen, wenn der Parser auf den Inhalt eines Elements stößt (z.B. Text zwischen den Tags).
//            Parameter:
////            char[] ch: Ein Zeichen-Array, das den Inhalt des Elements enthält.
////            int start: Der Startindex im Array.
////            int length: Die Anzahl der Zeichen, die gelesen wurden.
//
//
//            // Parse XML-Datei, Hier wird die XML-Datei SAXParser.xml (aus dem Ordner src) eingelesen und der handler verwendet, um die Ereignisse zu verarbeiten.
//            //Der SAX-Parser durchläuft die gesamte Datei und ruft je nach Element die entsprechenden Ereignismethoden (startElement, endElement, characters) auf.
//            saxParser.parse("src/SAXParser.xml", handler);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//Zusammenfassung:
//Der SAX-Parser durchläuft das XML-Dokument und löst für jedes Element (<name>, <age>, <student>) ein Start- und ein End-Ereignis aus.
//Die characters-Methode wird aufgerufen, wenn zwischen den Tags Text gefunden wird.
//Der SAX-Parser ist nur lesend und eignet sich gut für große Dokumente, da er den Speicherbedarf minimiert.
//












//
//
//
//
////3. DOM-Parser (Seite 358):
////DOM (Document Object Model) lädt das gesamte XML-Dokument in einen Speicherbaum.
////Vorteil: Erlaubt das direkte Ändern und Navigieren im Dokument.
////Nachteil: Hoher Speicherverbrauch bei großen Dokumenten.
////        Anwendungsfall: Wenn der vollständige Zugriff auf das Dokument und Änderungen daran notwendig sind.
//
////Hier verwenden wir auch den SAXParser xmlDatei.
//
//
//import org.w3c.dom.*;
//import javax.xml.parsers.*;
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            // Initialisiere den DOM Parser
//            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();//Erstellt eine neue Instanz von DocumentBuilderFactory.DocumentBuilderFactory ist eine Factory-Klasse, die Objekte des Typs DocumentBuilder erzeugt.
//
//            DocumentBuilder builder = factory.newDocumentBuilder();
//            //Erstellt einen neuen DocumentBuilder auf Grundlage der Factory.
//            //Der DocumentBuilder wird verwendet, um das XML-Dokument in ein Document-Objekt zu parsen.
//
//            Document document = builder.parse("src/SAXParser.xml");
//            //Der DocumentBuilder parst die Datei SAXParser.xml und lädt die gesamte Struktur als Document-Objekt (document) in den Speicher.
//            //Dieses Document-Objekt stellt die Wurzel des XML-Baums dar.
//
//
//            // Hole alle Elemente mit dem Tag "student"
//            NodeList nodeList = document.getElementsByTagName("student");
//            //getElementsByTagName durchsucht den gesamten XML-Baum und gibt eine Liste (NodeList) aller student-Elemente zurück.
//            //Jeder Knoten in der NodeList repräsentiert ein student-Element.
//
//            for (int i = 0; i < nodeList.getLength(); i++) {
//                Node node = nodeList.item(i);
//                //Eine Schleife iteriert durch alle student-Knoten in der NodeList. item(i) gibt das i-te student-Element zurück.
//
//                if (node.getNodeType() == Node.ELEMENT_NODE) {
//                    Element element = (Element) node;
//                    System.out.println("Student ID: " + element.getAttribute("id"));//Liest das Attribut id des student-Elements aus.
//
//                    System.out.println("Name: " + element.getElementsByTagName("name").item(0).getTextContent());//Durchsucht das student-Element nach einem name-Unterelement.dann Gibt eine NodeList aller name-Elemente innerhalb des student-Elements zurück.item(0) holt das erste name-Element in der NodeList. und getTextContent() gibt den Textinhalt des name-Elements zurück.
//
//
//                    System.out.println("Age: " + element.getElementsByTagName("age").item(0).getTextContent());// Genauso wie name.
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}

// Zusammenfassung:
//Der DOM-Parser lädt die gesamte XML-Datei als Baumstruktur in den Speicher (Document).
//Die Elemente (student) werden gesucht und die Attributwerte (id), Unterelemente (name, age) extrahiert.
//Der DOM-Parser ist ideal, wenn man vollen Zugriff auf die Struktur des Dokuments benötigt, aber bei sehr großen Dateien sollte er aufgrund des hohen Speicherverbrauchs vermieden werden.














//
//
//
////5. Pull-Parser (Seite 361):
////Pull-Parser ermöglichen ein anderes XML-Parsing-Paradigma, bei dem der Entwickler die Kontrolle hat, welche Teile des XML-Dokuments als nächstes gelesen werden.
////        Vorteil: Kombination aus niedrigem Speicherverbrauch und selektivem Zugriff.
////        Anwendungsfall: Ideal, wenn nur bestimmte Teile eines großen XML-Dokuments benötigt werden.
//
//////4. Pull-Parser
//////Pull-Parser geben dem Entwickler mehr Kontrolle darüber, welche Teile des XML-Dokuments verarbeitet werden. Das ist ideal, wenn man bestimmte Teile gezielt verarbeiten möchte.
////
//
//
//import javax.xml.stream.*;
//import java.io.FileReader;
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            // Initialisiere den XMLInputFactory
//            XMLInputFactory factory = XMLInputFactory.newInstance();
//            // Erstellt eine Instanz der XMLInputFactory.
//            //XMLInputFactory ist eine Factory-Klasse, die Pull-Parser (XMLStreamReader) für das Lesen von XML-Daten erzeugt.
//
//            XMLStreamReader reader = factory.createXMLStreamReader(new FileReader("src/SAXParser.xml"));// Erstellt einen XMLStreamReader (reader), um die Datei SAXParser.xml zu lesen. Der XMLStreamReader liest die XML-Daten schrittweise und ruft dabei für jedes Ereignis next() auf.
//
//            while (reader.hasNext()) {
//                int event = reader.next();
//                //while (reader.hasNext()):
//                //Die Schleife läuft so lange, wie der reader noch weitere XML-Ereignisse hat.
//                //int event = reader.next();:
//                //next() liest das nächste Ereignis aus der XML-Datei (z.B. START_ELEMENT, END_ELEMENT, CHARACTERS).
//                //Die Ereignisse sind Konstanten, die in der Klasse XMLStreamConstants definiert sind (z.B. START_ELEMENT = 1, END_ELEMENT = 2 usw.).
//
//                switch (event) {
//                    case XMLStreamConstants.START_ELEMENT:
//                        System.out.println("Start Element: " + reader.getLocalName());
//                        break;// Tritt ein, wenn der Parser ein Start-Tag //reader.getLocalName() gibt den Namen des aktuellen Elements zurück (ohne Namespace).
//
//                    case XMLStreamConstants.END_ELEMENT:
//                        System.out.println("End Element: " + reader.getLocalName());
//                        break;// Tritt ein, wenn der Parser ein End-Tag
//
//                    case XMLStreamConstants.CHARACTERS:
//                        if (reader.hasText()) {// reader.hasText() überprüft, ob der aktuelle Abschnitt Text enthält.
//                            System.out.println("Text: " + reader.getText().trim());
//                        }//gibt den Text-Inhalt zurück und entfernt dabei alle überflüssigen Leerzeichen.
//
//                        break;// Tritt ein, wenn der Parser auf Text-Inhalt innerhalb eines Elements stößt.
//
//                }
//
//
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
////Vorteile des Pull-Parsers gegenüber SAX:
////Beim Pull-Parser entscheidet der Entwickler explizit, wann das nächste Element gelesen wird (reader.next()).
////Der SAX-Parser reagiert hingegen automatisch auf jedes Ereignis.
////Der Pull-Parser ist daher flexibler, um bestimmte Teile selektiv zu verarbeiten oder Ereignisse zu überspringen.
//
//
//


































//
//
//
////6. JAXB (Seite 365):
////JAXB (Java Architecture for XML Binding) ist eine API, die das Mapping von XML-Daten auf Java-Klassen ermöglicht.
////Vorteil: Bietet eine komfortable Möglichkeit, XML in Java-Objekte und umgekehrt zu konvertieren.
////Anwendungsfall: Wenn XML-Daten in objektorientierten Strukturen verarbeitet und gespeichert werden sollen.
////
////
////
////
////
////package org.example;
////// JAXB (Java Architecture for XML Binding), um XML-Daten in Java-Objekte zu konvertieren (Unmarshalling) und umgekehrt (Marshalling). Das ist eine leistungsstarke Methode, um XML-Daten in einer objektorientierten Weise zu verarbeiten.
//
//import javax.xml.bind.*;
//import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlRootElement;
//import java.io.File;
//// File: Wird verwendet, um die student.xml-Datei zu referenzieren.
//
//// Fangen wir an mit der definition unserer Annotations (Ganz unten)
//
//public class Main {
//    public static void main(String[] args) {
//        try {
//            // Erzeuge JAXB Kontext
//            JAXBContext context = JAXBContext.newInstance(Student.class);
//            // Ein JAXBContext ist eine Umgebung, in der die JAXB-Operationen wie Marshalling (Objekt -> XML) und Unmarshalling (XML -> Objekt) durchgeführt werden.
//
//            // XML in Java-Objekt umwandeln (Unmarshal) Ein Unmarshaller wird erstellt, um die Konvertierung von XML in ein Java-Objekt durchzuführen.
//            Unmarshaller unmarshaller = context.createUnmarshaller();
//            Student student = (Student) unmarshaller.unmarshal(new File("src/student.xml"));
//            // Der Unmarshaller liest die Datei student.xml ein und wandelt sie in ein Student-Objekt um. Der Rückgabewert wird in ein Student-Objekt gecastet.
//
//            System.out.println("Student Name: " + student.getName());
//            System.out.println("Student Age: " + student.getAge());
//
//            // Java-Objekt wieder in XML umwandeln (Marshal)
//            student.setAge(25); // Ändere das Alter
//
//            Marshaller marshaller = context.createMarshaller();
//            // Ein Marshaller wird erstellt, um das Student-Objekt wieder in XML umzuwandeln.
//
//            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
//            marshaller.marshal(student, System.out); // Das geänderte Student-Objekt wird in XML umgewandelt und in der Konsole ausgegeben.
////            Die XML-Struktur wird dabei erneut generiert, basierend auf dem geänderten Student-Objekt.
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
//
////// Zusammenfassung
//////Unmarshalling: Liest die student.xml ein und wandelt sie in ein Student-Objekt um.
//////Änderung: Setzt das Alter des Student-Objekts auf 25.
//////Marshalling: Wandelt das Student-Objekt wieder in XML um und gibt es in der Konsole aus.
////
//////Ausgabe in der Konsole:
//////Nach dem Ausführen des Programms und dem Laden der XML-Datei (student.xml) erhältst du folgende Ausgabe:
//////
////
//////Student Name: John Doe
//////Student Age: 22
////
////
//////Und nach der Änderung des Alters auf 25 gibt das Programm die neue XML-Struktur aus:
////
//////<?xml version="1.0" encoding="UTF-8" standalone="yes"?>
//////<student>
//////<name>John Doe</name>
//////    <age>25</age>
//////</student>
////
////
////
////
////
//
//@XmlRootElement // Diese Annotation gibt an, dass die Klasse Student als Wurzelelement des XML-Dokuments dient.
//class Student {
//    private String name;
//    private int age;
//
//    @XmlElement// Diese Annotation markiert die Felder name und age als XML-Elemente.
//
//    public String getName() { return name; }
//    public void setName(String name) { this.name = name; }
//
//    @XmlElement
//    public int getAge() { return age; }
//    public void setAge(int age) { this.age = age; }
//}// Die Klasse hat zwei Attribute: name (String) und age (int). Mit den get- und set-Methoden kannst du auf diese Felder zugreifen und sie ändern.
//
