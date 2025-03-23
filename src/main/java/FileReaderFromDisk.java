import java.io.*;

public class FileReaderFromDisk {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/Acer/Desktop/winter.jpg");
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getName());
        try {
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("Exception " + e.getMessage()+"  handled");
        }
        File file1 = new File("C:\\Users\\Acer\\Documents\\demo.txt");//file outside the project - No short cut can be created
        File file3 = new File(System.getProperty("user.dir")+"/DemoText.txt");//file 3 and file 2 are the same and have the same path
          File file2 = new File("DemoText.txt");//short cut was created
// Reading file txt format
        try {
            FileReader fileReader =new FileReader(file3);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            System.out.println(bufferedReader.readLine());//Read first line
            // read file using loop
           String str;
            while ((str=bufferedReader.readLine())!=null){
               System.out.println(str);


            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
