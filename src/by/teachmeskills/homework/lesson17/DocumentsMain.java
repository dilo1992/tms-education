package by.teachmeskills.homework.lesson17;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DocumentsMain {
    public static void main(String[] args) throws IOException, RuntimeException {
        Map<String, Document> mapOfDocuments = new HashMap<>();
        File[] listFiles;
        listFiles = setFolderName();

        String docNumberCheckerPattern = "(\\d{4}-)([a-zA-Z]{3}-)(\\d{4}-)([a-zA-Z]{3}-)(\\d[a-zA-Z]\\d[a-zA-Z])";
        String emailCheckerPattern = "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}";
        String phoneNumberCheckerPattern = "\\d{10}|(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\)\\d{3}-?\\d{2}-?\\|d{2}-?\\+?\\(\\d{2}\\)\\d{3}d{2}-?\\d{2}-?\\d{2}-?|\\+?(\\d{0,3})\\(\\d{2}\\)\\d{7}";
        Pattern pattern = Pattern.compile(docNumberCheckerPattern);
        Pattern pattern1 = Pattern.compile(emailCheckerPattern, Pattern.CASE_INSENSITIVE);
        Pattern pattern2 = Pattern.compile(phoneNumberCheckerPattern);
        for (File currentFile : listFiles) {
            StringBuilder sb = getKeyForMapFromFileName(currentFile);
            Document document = new Document();
            List<String> numberDoc = new ArrayList<>();
            getDocNumberForCycle(pattern, currentFile, numberDoc);
            document.setDocumentsNumber(numberDoc);
            getEmailForCycle(pattern1, currentFile, document);
            getPhoneNumbForCycle(pattern2, currentFile, document);
            mapOfDocuments.put(sb.toString(), document);
        }
        System.out.println(mapOfDocuments);
    }

    private static File[] setFolderName() {
        File[] listFiles;
        File file;
        do {
            System.out.println("Enter document folder name: ");
            Scanner scanner = new Scanner(System.in);
            file = new File(scanner.nextLine());
            if (!file.exists()) {
                System.out.println("This folder is not found");
                continue;
            }
            listFiles = file.listFiles(new MyNameFileFilter(".txt"));
            if (listFiles.length == 0) {
                System.out.println("This folder does not contain files of the required format");
                continue;
            } else break;
        } while (true);
        return listFiles;
    }

    private static StringBuilder getKeyForMapFromFileName(File currentFile) {
        String nameOfFile = currentFile.getName();
        StringBuilder sb = new StringBuilder(currentFile.getName());
        if (nameOfFile.endsWith(".txt")) {
            sb.delete(nameOfFile.lastIndexOf(".txt"), nameOfFile.length());
        }
        return sb;
    }

    private static void getPhoneNumbForCycle(Pattern pattern2, File currentFile, Document document) {
        try (FileReader fileReader = new FileReader(currentFile)) {
            Scanner scanner1 = new Scanner(fileReader);
            while (scanner1.hasNextLine()) {
                Matcher matcherPhoneNumb = pattern2.matcher(scanner1.nextLine());
                while (matcherPhoneNumb.find()) {
                    document.setPhoneNumber(matcherPhoneNumb.group());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getEmailForCycle(Pattern pattern1, File currentFile, Document document) {
        try (FileReader fileReader = new FileReader(currentFile)) {
            Scanner scanner1 = new Scanner(fileReader);
            while (scanner1.hasNextLine()) {
                Matcher matcherEmail = pattern1.matcher(scanner1.nextLine());
                while (matcherEmail.find()) {
                    document.setEmail(matcherEmail.group());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void getDocNumberForCycle(Pattern pattern, File currentFile, List<String> numberDoc) {
        try (FileReader fileReader = new FileReader(currentFile)) {
            Scanner scanner1 = new Scanner(fileReader);
            while (scanner1.hasNextLine()) {
                Matcher matcherDocNumb = pattern.matcher(scanner1.nextLine());
                while (matcherDocNumb.find()) {
                    numberDoc.add(matcherDocNumb.group());
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
