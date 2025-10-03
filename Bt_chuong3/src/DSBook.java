import java.util.*;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class DSBook {
    ArrayList<Book> dsBook = new ArrayList<>();

    public ArrayList<Book> getDsBook() {
        return dsBook;
    }

    public void setDsBook(ArrayList<Book> dsBook) {
        this.dsBook = dsBook;
    }

    public DSBook() {
        super();
        this.dsBook = new ArrayList<>();
    }

    public void ReadXML() throws ParserConfigurationException, SAXException, IOException {
        File inputFile = new File("book.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(inputFile);
        doc.getDocumentElement().normalize();

        System.out.println("Root : " + doc.getDocumentElement().getNodeName());
        NodeList nList = doc.getElementsByTagName("book");

        for (int i = 0; i < nList.getLength(); i++) {
            Book b = new Book();
            Node nNode = nList.item(i);

            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nNode;
                b.setId(element.getElementsByTagName("id").item(0).getTextContent());
                b.setAuthor(element.getElementsByTagName("author").item(0).getTextContent());
                b.setTitle(element.getElementsByTagName("title").item(0).getTextContent());
                b.setPrice(Double.parseDouble(element.getElementsByTagName("price").item(0).getTextContent()));
            }
            dsBook.add(b);
        }
    }

    public void xuatDS() {
        for (Book b : dsBook) {
            System.out.println("Id: " + b.getId());
            System.out.println("Author: " + b.getAuthor());
            System.out.println("Title: " + b.getTitle());
            System.out.println("Price: " + b.getPrice());
            System.out.println("------------------");
        }
    }

    public void sapXepDS() {
        Collections.sort(dsBook, Book.BookPrice);
        xuatDS();
    }
}


