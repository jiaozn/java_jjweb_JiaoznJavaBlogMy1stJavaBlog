package com.jweb.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletResponse;

/**
 * @desc: 图片处理工具
 * @author: bingye
 * @createTime: 2015-3-17 下午04:25:32
 * @version: v1.0
 */
public class ImageUtil {
 
    /**
    * 将图片写到客户端
    * @author: bingye
    * @createTime: 2015-3-17 下午04:36:04
    * @history:
    * @param image
    * @param response void
    */
    public static void writeImage(byte[] image,HttpServletResponse response){
        if(image==null){
            return;
        }
        byte[] buffer=new byte[1024];
        InputStream is=null;
        OutputStream os=null;
        try {
            is=new ByteArrayInputStream(image);
            os=response.getOutputStream();
            while(is.read(buffer)!=-1){
                os.write(buffer);
                os.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                if(is!=null){is.close();}
                if(os!=null){os.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
     
    /**
    * 获取指定路劲图片
    * @author: bingye
    * @createTime: 2015-3-21 上午10:50:44
    * @param filePath
    * @param response void
    */
    public static void writeImage(String filePath,HttpServletResponse response){
        File imageFile=new File(filePath); 
        if(imageFile!=null && imageFile.exists()){
            byte[] buffer=new byte[1024];
            InputStream is=null;
            OutputStream os=null;
            try {
                is=new FileInputStream(imageFile);
                os=response.getOutputStream();
                while(is.read(buffer)!=-1){
                    os.write(buffer);
                    os.flush();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally{
                try {
                    if(is!=null){is.close();}
                    if(os!=null){os.close();}
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
     
    /**
    * 图片上传到文件夹
    * @author: bingye
    * @createTime: 2015-3-20 下午08:07:25
    * @param file
    * @param savePath
    * @return boolean
    */
//    public static ResultDto uploadToLocal(CommonsMultipartFile file,String savePath){
//        if(file!=null && !file.isEmpty()){
//            //获取文件名称
//            String fileName=file.getOriginalFilename();
//            //获取后缀名
//            String suffixName=fileName.substring(fileName.indexOf(".")+1);
//            //新名称
//            String newFileName=System.currentTimeMillis()+"."+suffixName;
//            //新文件路劲
//            String filePath=savePath+newFileName;
//            //获取存储文件路径
//            File fileDir=new File(savePath);
//            if(!fileDir.exists()){
//                //如果文件夹没有：新建
//                fileDir.mkdirs();
//            }
//            FileOutputStream fos=null;
//            try {
//                fos=new FileOutputStream(filePath);
//                fos.write(file.getBytes());
//                fos.flush();
//                return ResultUtil.success("UPLOAD_SUCCESS", URLEncoder.encode(newFileName,"utf-8"));
//            } catch (Exception e) {
//                e.printStackTrace();
//                return ResultUtil.fail("UPLOAD_ERROR");
//            } finally{
//                try {
//                    if(fos!=null){
//                        fos.close();
//                    }
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    return ResultUtil.fail("UPLOAD_ERROR");
//                }
//            }
//        }
//        return ResultUtil.fail("UPLOAD_ERROR");
//    }
//     
     
     
}
