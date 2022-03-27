package top.flvio.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.flvio.constant.RedisKeyConstants;
import top.flvio.entity.About;
import top.flvio.mapper.AboutMapper;
import top.flvio.service.AboutService;
import top.flvio.service.RedisService;
import top.flvio.util.markdown.MarkdownUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AboutServiceImpl implements AboutService {
    @Autowired
    private AboutMapper aboutMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public Map<String, String> getAboutInfo() {
        String redisKey = RedisKeyConstants.ABOUT_INFO_MAP;
        Map<String, String> aboutInfoMapFromRedis = redisService.getMapByValue(redisKey);
        if(aboutInfoMapFromRedis!=null){
            return aboutInfoMapFromRedis;
        }
        List<About> abouts = aboutMapper.getList();
        Map<String,String> aboutInfoMap = new HashMap<>();
        for(About about:abouts){
            if("content".equals(about.getNameEn())){
                about.setValue(MarkdownUtils.markdownToHtmlExtensions(about.getValue()));
            }
            aboutInfoMap.put(about.getNameEn(),about.getValue());
        }
        redisService.saveMapToValue(redisKey,aboutInfoMap);
        return aboutInfoMap;
    }
}
