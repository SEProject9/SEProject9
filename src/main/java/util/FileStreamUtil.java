package util;

import java.io.*;

import org.apache.commons.io.FileUtils;

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
	/* public static void main(String[] args) {
		 StringBuffer s=new FileStreamUtil().readLogInfo("F://1.txt");
		 System.out.println(s);
		
	}*/
}
