package cn.ymxdy.springcachedemo.moudles.file.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author wf
 * @date 2022/5/9 16:34
 * @description
 */
@RestController
@RequestMapping("/file")
public class FileController {
    @PostMapping("/upload")
    public String fileUpload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
        // 获取文件的名称
        String filename = file.getOriginalFilename();
        //判断文件名是否为空
        if ("".equals(filename)) {
            return "文件名为空，请从小上传";
        }
        // 获取文件的输入流对象
        InputStream inputStream = file.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("/Users/wangfeng/Desktop/poi", filename));
        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
            fileOutputStream.flush();
        }
        fileOutputStream.close();
        inputStream.close();
        return "下载成功";
    }
}
