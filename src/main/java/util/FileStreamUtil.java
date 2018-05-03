package util;

import java.io.*;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

public class FileStreamUtil {
	 public static StringBuffer readLogInfo(String filePath) {
	        StringBuffer sb = new StringBuffer("");
	        // 创建文件输入流对象
	        Reader reader = null;
	        //
	        InputStreamReader inputStreamReader = null;
	        // 创建文件输入流缓存对象
	        BufferedReader bufferedReader = null;
	        try {
	            File file = new File(filePath);
	            FileUtils.touch(file);
	             
	            reader = new FileReader(file);
	            inputStreamReader = new InputStreamReader(new FileInputStream(file),"UTf-8");
	            bufferedReader = new BufferedReader(inputStreamReader);
	             
	            String lineString = bufferedReader.readLine();
	            while (lineString != null) {
	                sb.append(lineString);
	                lineString = bufferedReader.readLine();
	            }
	 
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (bufferedReader != null) {
	                    bufferedReader.close();
	                }
	                if(inputStreamReader!=null){
	                    inputStreamReader.close();
	                }
	                if (reader != null) {
	                    reader.close();
	                }
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }
	        return sb;
	    }
	 public static void displayPDF(HttpServletResponse response,String filePath) {
	        try {
	            File file = new File(filePath);
	            FileInputStream fileInputStream = new FileInputStream(file);
	            response.setHeader("Content-Disposition", "attachment;fileName=test.pdf");
	            response.setContentType("multipart/form-data");
	            OutputStream outputStream = response.getOutputStream();
	            IOUtils.write(IOUtils.toByteArray(fileInputStream), outputStream);
	        } catch(Exception e) {
	            e.printStackTrace();
	        }
	    }
	/* public static void main(String[] args) {
		 StringBuffer s=new FileStreamUtil().readLogInfo("F://1.txt");
		 System.out.println(s);
		
	}*/
}
