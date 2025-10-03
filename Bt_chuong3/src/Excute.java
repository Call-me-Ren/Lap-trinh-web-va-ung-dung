public class Excute {
    public static void main(String[] args) {
        try {
            DSBook dsBook = new DSBook();
            dsBook.ReadXML();
            dsBook.xuatDS();

            System.out.println("=== Sau khi sắp xếp theo giá ===");
            dsBook.sapXepDS();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
