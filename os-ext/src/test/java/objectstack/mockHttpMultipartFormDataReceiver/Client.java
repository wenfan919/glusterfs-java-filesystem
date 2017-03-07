/*
* http://www.codejava.net/java-se/networking/upload-files-by-sending-multipart-request-programmatically
*/

package objectstack.mockHttpMultipartFormDataReceiver;
 
import java.io.File;
import java.io.IOException;
import java.util.List;
 
/**
 * This program demonstrates a usage of the MultipartUtility class.
 * @author www.codejava.net
 *
 */
public class Client {
    public static void main(String[] args) {
        String charset = "UTF-8";
        File uploadFile1 = new File("/tmp/PIC1.JPG");
        File uploadFile2 = new File("d:/temp/PIC2.JPG");
        String requestURL = "http://localhost:9099/v1";
 
        try {
            MultipartUtility multipart = new MultipartUtility(requestURL, charset);
             
            multipart.addHeaderField("User-Agent", "CodeJava");
            multipart.addHeaderField("Test-Header", "Header-Value");
             
            multipart.addFormField("description", "Cool Pictures");
            multipart.addFormField("keywords", "Java,upload,Spring");
             
            multipart.addFilePart("files", uploadFile1);
            multipart.addFilePart("files", uploadFile2);
 
            List<String> response = multipart.finish();
             
            System.out.println("SERVER REPLIED:");
             
            for (String line : response) {
                System.out.println(line);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}