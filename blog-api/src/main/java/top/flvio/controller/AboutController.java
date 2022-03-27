package top.flvio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.flvio.annotation.VisitLogger;
import top.flvio.enums.VisitBehavior;
import top.flvio.model.vo.Result;
import top.flvio.service.AboutService;

/**
*@Author:flvio
*@Description:关于我 页面
*@Params:
*/
@RestController
public class AboutController {

    @Autowired
    private AboutService aboutService;

    /**
     * 获取 关于我 页面信息
     * @return
     */
    @VisitLogger(VisitBehavior.ABOUT)
    @GetMapping("/about")
    public Result about(){return Result.ok("获取成功",aboutService.getAboutInfo());}
}
