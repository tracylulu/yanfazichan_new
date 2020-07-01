package com.h3c.platform.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class FileUtil {

    public static byte[] readFile(String strFile) {
        byte[] bytes = null;
        InputStream is = null;
        try {
            is =  new FileInputStream(strFile);
            int iAvail = is.available();
            bytes = new byte[iAvail];
            is.read(bytes);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        return bytes;
    }
    
    public static List<String> readFileLineToList(MultipartFile multipartFile){
        List<String> list = new ArrayList<String>();
        Reader reader = null;
        BufferedReader br = null;
        try {
            reader = new InputStreamReader(multipartFile.getInputStream(), "utf-8");
            br = new BufferedReader( reader);
            
            String line;
            while((line = br.readLine()) != null){
                list.add(line);
            }
            reader.close();
            br.close();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
            }
        }
        return list;
    }
    public static void writeFile(String content, String path){
        File file = new File(path);
        FileWriter fileWritter = null;
        try {
            if(!file.exists()){
                file.createNewFile();
            }
     
            //使用true，即进行append file 
     
            fileWritter = new FileWriter(path, true);
     
     
            fileWritter.write(content);
     
            fileWritter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(fileWritter != null){
                try {
                    fileWritter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    
    public static void writeFile(String content, String path, String dir){
        File fileDir = new File(dir);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        writeFile(content, path);
    }
    public static void deleteFile(String path){
        File file = new File(path);
        if(file.exists()){
            file.delete();
        }
    }
    
    public static boolean renameFileName(final File file, final String newName){
     // file is null then return false
        if (file == null) return false;
        // file doesn't exist then return false
        if (!file.exists()) return false;
        // the new name is space then return false
        // the new name equals old name then return true
        if (newName.equals(file.getName())) return true;
        File newFile = new File(file.getParent() + File.separator + newName);
        // the new name of file exists then return false
        return !newFile.exists();
    }
}
