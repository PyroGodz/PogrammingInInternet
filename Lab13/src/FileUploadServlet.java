import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;

@MultipartConfig
public class FileUploadServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        final String path = request.getServletContext().getInitParameter("doc-dir");
        final Part filePart = request.getPart("file");
        final String fileName = getFileName(filePart);
        OutputStream otpStream = null;
        InputStream iptStream = null;
        final PrintWriter writer = response.getWriter();
        try {
            otpStream = new FileOutputStream(new File(path + File.separator + fileName));
            iptStream = filePart.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];
            while ((read = iptStream.read(bytes)) != -1) {
                otpStream.write(bytes, 0, read);
            }
            writer.println("New file " + fileName + " created at " + path);
        }
        catch (FileNotFoundException fne){
            writer.println("You either did not specify a file to upload or are trying to upload a file to a protected or nonexistent location.");
            writer.println("<br/> ERROR: " + fne.getMessage());
        }
        finally {
            if (otpStream != null) {
                otpStream.close();
            }
            if (iptStream != null) {
                iptStream.close();
            }
            if (writer != null) {
                writer.close();
            }
        }
    }

    private String getFileName(final Part part) {
        for (String content : part.getHeader("content-disposition").split(";")) {
            if (content.trim().startsWith("filename")) {
                return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
}  