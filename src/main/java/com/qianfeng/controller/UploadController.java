package com.qianfeng.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.qianfeng.baiduapi.AdvancedGeneral;
import com.qianfeng.vo.GarbageInfoVO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("fileUpAndDown")
public class UploadController {
    @RequestMapping("fileUploadController")
    public Object fileUploadController(@RequestParam("file") CommonsMultipartFile file) throws IOException {

        File newData = new File("D:\\" + new Date().getTime() + file.getOriginalFilename());

        file.transferTo(newData);
        return "success";
    }

    @RequestMapping("textDownload")
    public ResponseEntity<byte[]> textDownload(@RequestParam(required = false, value = "fileName") String fileName) throws Exception {
        //获取文件
        File newFile = new File("d:\\" + fileName);

        if (!newFile.exists()) {
            throw new FileNotFoundException("无法找到文件" + newFile.getAbsolutePath());
        }
        //读取文件
        FileInputStream is = new FileInputStream(newFile);
        //创建容器接手读取文件
        byte[] destByArray = new byte[is.available()];
        //读取的东西给他写进byte数组
        is.read(destByArray);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Content-Disposition", "attchement;filename=" + fileName);
        //设置HTTP响应状态。
        HttpStatus statusCode = HttpStatus.OK;
        //创建响应实体对象
        ResponseEntity<byte[]> entity = new ResponseEntity<byte[]>(destByArray, httpHeaders, statusCode);
        return entity;
    }

    @RequestMapping("upload")
    public Map<String, Object> upload(MultipartFile dropzFile, HttpServletRequest request) throws IOException {
        System.out.println("inner upload");
        Map<String, Object> result = new HashMap<String, Object>();
        //设置文件上传路径
        String destPathName = request.getSession().getServletContext().getRealPath("/static/upload");
        File destPath = new File(destPathName);
        System.out.println(destPath);
        //如果目标文件夹不存在 我就创建它
        if (!destPath.exists()) {
            destPath.mkdirs();
        }
        //获取文件后缀                 获取原始文件名
        String fileSuffix = dropzFile.getOriginalFilename().substring(dropzFile.getOriginalFilename().lastIndexOf("."));
        String destFileName = UUID.randomUUID() + fileSuffix;
        File destFile = new File(destPath,destFileName);
        System.out.println(destFileName);
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        dropzFile.transferTo(destFile);
        result.put("status", 200);
        result.put("filePath", "http://localhost:8080/static/upload/"+destFileName);

        return result;
    }

    @RequestMapping("garbageDiscern")
    public Map<String, Object> garbageDiscern(MultipartFile dropzFile, HttpServletRequest request) throws IOException {
        System.out.println("inner upload");
        Map<String, Object> result = new HashMap<String, Object>();
        //设置文件上传路径
        String destPathName = request.getSession().getServletContext().getRealPath("/static/upload");
        File destPath = new File(destPathName);
        System.out.println(destPath);
        //如果目标文件夹不存在 我就创建它
        if (!destPath.exists()) {
            destPath.mkdirs();
        }
        //获取文件后缀                 获取原始文件名
        String fileSuffix = dropzFile.getOriginalFilename().substring(dropzFile.getOriginalFilename().lastIndexOf("."));
        String destFileName = UUID.randomUUID() + fileSuffix;
        File destFile = new File(destPath,destFileName);
        System.out.println(destFileName);
        if (!destFile.exists()) {
            destFile.createNewFile();
        }
        dropzFile.transferTo(destFile);

        String resultStr = AdvancedGeneral.advancedGeneral(destFile.getAbsolutePath());
        //调用百度接口然后获取回传值
        result.put("status",200);
        //将json字符串转对象
        Gson gson = new Gson();
        Object o = gson.fromJson(resultStr, new TypeToken<GarbageInfoVO>() {
        }.getType());
        result.put("resultObj",o);
        //http://localhost:8080/xxxxx/xxxx.jpg
        result.put("filePath","http://localhost:8080/static/upload/"+destFileName);
        return result;
    }

    static String UPLOAD_PATH = "/static/upload/";
    @RequestMapping(value = "upload1", method = RequestMethod.POST)
    public Map<String, Object> upload1(MultipartFile editorFile, HttpServletRequest request) {
        Map<String, Object> result = new HashMap<String, Object>();

        // 获取文件后缀
        String fileName = editorFile.getOriginalFilename();
        String fileSuffix = fileName.substring(fileName.lastIndexOf("."));

        // 文件存放路径
        String filePath = request.getSession().getServletContext().getRealPath(UPLOAD_PATH);
        InetAddress ia=null;
        try {
            ia = ia.getLocalHost();
            System.out.println(ia.getHostAddress());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        // 判断路径是否存在，不存在则创建文件夹
        File file = new File(filePath);
        if (!file.exists()) {
            file.mkdir();
        }

        // 将文件写入目标
        file = new File(filePath, UUID.randomUUID() + fileSuffix);
        try {
            editorFile.transferTo(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 获取服务端路径
        String serverPath = String.format("%s://%s:%s%s%s", request.getScheme(), ia.getHostAddress(), request.getServerPort(), request.getContextPath(), UPLOAD_PATH);
        System.out.println(serverPath);
        // 返回给 wangEditor 的数据格式
        result.put("errno", 0);
        result.put("data", new String[]{serverPath + file.getName()});
        return result;
    }
}
