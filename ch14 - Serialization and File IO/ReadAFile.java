import java.io.*;

class ReadAFile {
    public static void main(String[] args) {

        try {
            File myFile = new File("MyText.txt");
            // FileReader is a connection stream to read from txt file
            FileReader fileReader = new FileReader(myFile);

            // Chain filereader to bufferedreader for more efficient reads.
            // Go back to the file only when the buffer is empty.
            BufferedReader reader = new BufferedReader(fileReader);

            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println("line");
            }
            reader.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
