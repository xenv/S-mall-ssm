package tmall.util;
/**
 * 处理 Controller 中文件保存的问题
 */

import org.apache.commons.io.FileUtils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;
import tmall.service.ConfigService;


import javax.annotation.PostConstruct;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.Map;

@Component
public class FileUtil implements ServletContextAware {
    @Autowired
    public ConfigService configService;

    private ServletContext servletContext;

    @Override
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    public void saveImg(UploadedImageFile uploadedImageFile, String type, String imgName) throws Exception {
        Map<String, String> config = configService.map();
        String relativeFolderPath = config.get("path_" + type + "_img");
        File imageFolder = new File(servletContext.getRealPath(relativeFolderPath));
        if (!imageFolder.exists())
            imageFolder.mkdirs();
        File imageFile = new File(imageFolder, imgName);
        uploadedImageFile.getImage().transferTo(imageFile);
    }
}
