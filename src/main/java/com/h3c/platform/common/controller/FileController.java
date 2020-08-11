package com.h3c.platform.common.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.eos.common.constant.StatusCodeEnum;
import com.eos.common.util.Result;
import com.h3c.platform.annotation.UserLoginToken;
import com.h3c.platform.common.commonconst.LogType;
import com.h3c.platform.common.entity.FileLog;
import com.h3c.platform.common.util.IPUtils;
import com.h3c.platform.response.ResponseResult;

@RequestMapping("/common/file")
@RestController
@Api(value = "文件导入接口",tags = {"文件导入相关接口"})
@CrossOrigin
public class FileController {

    private static final Logger logger = LoggerFactory.getLogger(FileController.class);

    private  String PATH;

    @Value("${file.tmpPath}")
    private  String filePath ;  
//    @Autowired
//    private FileLogService fileLogService;

   /* @PostConstruct
    public void intiPath(){
        String seperator = File.separator;
        PATH =  filePath+seperator;
    }*/



    @PostMapping(value="/uploadFile")
    @ApiOperation(value = "导入文件", notes = "需要有文件")
    @UserLoginToken(logType=LogType.IMPORT)
    public ResponseResult uploadFile(MultipartFile file, HttpServletRequest request) throws Exception{
        if(file.isEmpty()){
        	return ResponseResult.fail(StatusCodeEnum.REQ_UPLOAD_FAIL);
        }
        String fileName = file.getOriginalFilename();
        if(fileName.indexOf("\\")>-1){
            fileName = fileName.substring(fileName.lastIndexOf("\\")+1);
        }
        String fileId = UUID.randomUUID().toString();
        String extName = fileName.substring(fileName.lastIndexOf(".") );
        System.out.println(PATH+ fileId+extName);
        File dest = new File(PATH+ fileId+extName);
        if(!dest.exists()){
            dest.getParentFile().mkdirs();
            dest.createNewFile();
        }
        file.transferTo(dest);
        Map<String,Object> fileInfo = new HashMap<>();
        fileInfo.put("fileName", fileName);
        fileInfo.put("fileId", fileId+extName);
//            createLog(fileId, fileName, extName, new Long(file.getSize()).intValue(), IPUtils.getIpAddr(request), "1");
        return ResponseResult.success(fileInfo, "上传成功");
        //return ResponseResult.success(StatusCodeEnum.REQ_UPLOAD_SUCCESS);
 
    }
    
    /**
     * 上次附件多个
     * @param request
     * @return
     */
    @PostMapping(value="/uploadFileMulti")
    @ApiOperation(value = "导入多个文件", notes = "需要有文件")
    @ResponseBody
    @UserLoginToken(logType=LogType.IMPORT)
    public ResponseResult uploadFileMulti(
    		@RequestParam @ApiParam(name="files", value = "files", required = false) MultipartFile[] files,
            HttpServletRequest request) throws Exception{ 
    		
    		PATH =  filePath;
    			
        	Map<String,Object> fileInfo = new HashMap<>();
        	List<String> lstFileName=new ArrayList<String>();
        	List<String> lstFileId=new ArrayList<String>();
      
            if(files == null || files.length == 0){
            	return ResponseResult.fail(StatusCodeEnum.REQ_UPLOAD_FAIL);
            }          

            for(MultipartFile file:files){
            	
            	String fileName = file.getOriginalFilename();
                String fileId = UUID.randomUUID().toString();
                String extName = fileName.substring(fileName.lastIndexOf(".") );
                System.out.println(PATH+ fileId+extName);
                File dest = new File(PATH+ fileId+extName);
                //File dest = new File(PATH);
                if(!dest.exists()){
                    dest.getParentFile().mkdirs();
                    dest.createNewFile();
                }
                file.transferTo(dest);
                lstFileName.add(fileName);
                lstFileId.add(fileId+extName);
              
            }
            fileInfo.put("fileName", String.join(",", lstFileName));
            fileInfo.put("fileId",String.join(",", lstFileId));
            
            return ResponseResult.success(fileInfo, "上传成功");
    }

    @DeleteMapping(value="/deleteFile")
    @ApiOperation(value = "删除文件")
    @UserLoginToken(logType=LogType.DELETE)
    public ResponseResult deleteFile(HttpServletRequest request,
    		@RequestParam @ApiParam(name="fileId",value="存储的文件名",required=true)String fileId) throws Exception{
        //String fileId = request.getParameter("fileId");
        if(StringUtils.isBlank(fileId)) {
        	return ResponseResult.fail(StatusCodeEnum.REMVOE_FAIl);
        } 
        File file = new File(PATH+fileId);
        if(file.exists()){
            if(file.delete()){
                return ResponseResult.success(StatusCodeEnum.REMVOE_SUCCESS);
            }else{
            	return ResponseResult.fail(StatusCodeEnum.REMVOE_FAIl);
            }
        }else{
        	return ResponseResult.fail(StatusCodeEnum.REMVOE_FAIl);
        }
    }

    @GetMapping("/downloadFile")
    @ApiOperation(value = "下载文件")
    @UserLoginToken(logType=LogType.EXPORT)
    public void downloadFile(HttpServletRequest request,HttpServletResponse response,
    		@RequestParam @ApiParam(name="fileName",value="原始的文件名",required=true)String fileName,
    		@RequestParam @ApiParam(name="fileId",value="存储的文件名",required=true)String fileId) throws Exception {
    	fileName=URLDecoder.decode(fileName,"utf-8");
    	
    	String agent = request.getHeader("User-Agent");
    	if(agent.contains("Edge")){              
    		//处理空格转为加号的问题
    		fileName= URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+","%20");
    	}else if(agent.contains("Chrome")){                          
    		fileName= new String(fileName.getBytes(), "iso8859-1");
    	}else if(agent.contains("Firefox")){
    		fileName=new String(fileName.getBytes(), "iso8859-1");
    	}else if(agent.contains("MSIE") || agent.contains("Trident")){
    		//在IE8以后，微软使用了Trident来作为IE浏览器的标志，兼容老的版本
    		//处理空格转为加号的问题  
    		fileName= URLEncoder.encode(fileName,"UTF-8").replaceAll("\\+","%20");
    	}else{
    		//其余浏览器
    		fileName= URLEncoder.encode(fileName,"UTF-8");
    	}

        File file = new File(PATH+fileId);
        if(file.exists()){
            //response.setContentType("application/force-download");
            response.addHeader("Content-Disposition", "attachment;fileName=" +fileName );  //URLEncoder.encode(fileName,"UTF-8")
            byte[] buffer = new byte[1024];
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                fis = new FileInputStream(file);
                bis = new BufferedInputStream(fis);
                OutputStream os = response.getOutputStream();
                int i = bis.read(buffer);
                while (i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
//                createLog(fileId,new String(fileName.getBytes("iso8859-1"),"UTF-8") , fileName.substring(fileName.lastIndexOf(".")), new Long(file.length()).intValue(), IPUtils.getIpAddr(request), "2");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (bis != null) {
                    try {
                        bis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public void createLog(String fileId,String fileName,String extName,Integer fileSize,String userIp,String operateType){
        FileLog fileLog = new FileLog();
        // TODO 要加上登录人的信息
//        fileLog.setUserName(UserUtils.getCurrentUserId());
//        fileLog.setUserDesc(UserUtils.getCurrentUserId());
        fileLog.setFileId(fileId);
        fileLog.setFileName(fileName);
        fileLog.setFileType(extName);
        fileLog.setFileSize(fileSize);
        fileLog.setUserIp(userIp);
        fileLog.setOperateType(operateType);
//        fileLogService.create(fileLog);
    }
}
