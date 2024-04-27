import java.util.ArrayList;
import java.util.Collections;

public class StringArrayListApp {

    // Phương thức chuyển đổi một chuỗi thành một danh sách các từ
    ArrayList<String> splitString(String text) {
        String[] words = text.split("\\s+"); // Tách chuỗi thành các từ dựa trên khoảng trắng
        ArrayList<String> wordList = new ArrayList<>();
        Collections.addAll(wordList, words); // Thêm từng từ vào danh sách
        return wordList;
    }

    // Phương thức đếm số lượng từ trong một danh sách
    int countWords(ArrayList<String> wordList) {
        return wordList.size();
    }

    // Phương thức sắp xếp danh sách các từ theo thứ tự bảng chữ cái
    void sortWords(ArrayList<String> wordList) {
        Collections.sort(wordList);
        System.out.println("Danh sach cac tu sau khi sap xep:");
        for (String word : wordList) {
            System.out.print(word + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StringArrayListApp app = new StringArrayListApp();
        String inputText = "This is a sample text for splitting and sorting words";

        long startTime = System.currentTimeMillis();

        ArrayList<String> words = app.splitString(inputText);
        int wordCount = app.countWords(words);

        System.out.println("So luong tu trong van ban: " + wordCount);

        app.sortWords(words);

        long endTime = System.currentTimeMillis();
        double executionTimeInSeconds = (endTime - startTime) / 1000.0;
        System.out.println("Thoi gian chay la: " + executionTimeInSeconds + " giay");
    }
}
