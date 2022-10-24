package javaBasic;

public class Topic_11_String {
    public static void main(String[] args) {
        String schoolName = "Automation Testing";
        String courseName = "automation testing";
        String schoolAdd = "HCM";

        System.out.println("Độ dài = " + schoolName.length());
        System.out.println("Lấy ra 1 ký tự = " + schoolName.charAt(0));
        System.out.println("Nối 2 chuỗi = " + schoolName.concat(schoolAdd)); //Không dùng
        System.out.println("Nối 2 chuỗi = " + schoolName + schoolAdd);

        System.out.println("Kiểm tra 2 chuỗi bằng nhau tuyệt đối = " + schoolName.equals(schoolName));
        System.out.println("Kiểm tra 2 chuỗi bằng nhau tương đối = " + schoolName.equalsIgnoreCase(courseName));

        System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi ký tự = " + schoolName.startsWith("A"));
        System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi ký tự = " + schoolName.startsWith("Automation"));
        System.out.println("Có bắt đầu bằng 1 ký tự/ chuỗi ký tự = " + schoolName.startsWith("T"));

        System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi ký tự = " + schoolName.endsWith("T"));
        System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi ký tự = " + schoolName.endsWith("Testing"));
        System.out.println("Có kết thúc bằng 1 ký tự/ chuỗi ký tự = " + schoolName.endsWith("g"));

        System.out.println("Có chứa 1 ký tự/ chuỗi ký tự = " + schoolName.contains("Tes"));

        System.out.println("Vị trí 1 ký tự/ chuỗi ký tự = " + schoolName.indexOf("Automation"));
        System.out.println("Vị trí 1 ký tự/ chuỗi ký tự = " + schoolName.indexOf("A"));
        System.out.println("Vị trí 1 ký tự/ chuỗi ký tự = " + schoolName.indexOf("Testing"));

        System.out.println("Tách 1 ký tự/ chuỗi ký tự = " + schoolName.substring(11));
        System.out.println("Tách 1 ký tự/ chuỗi ký tự = " + schoolName.substring(11,15));

        String result = "Viewing 24 of 132 results";
        String results[] = result.split(" ");
        System.out.println(results[1]);

        String productPrice = "$100.00";
        productPrice = productPrice.replace("$", "");
        float productPriceF = Float.parseFloat(productPrice);
        System.out.println(productPriceF);

        String osName = System.getProperty("os.name");
        System.out.println(osName);

        //Dynamic locator
        String dynamicButtonXpath = "//button[@id='%s']";
        System.out.println(dynamicButtonXpath.format(dynamicButtonXpath, "register"));
    }
}
