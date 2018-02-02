package com.bamboo.web;

import com.bamboo.bo.GenericService;
import com.bamboo.vo.User;
import com.common.base.BaseController;
import com.common.util.CheckUtil;
import com.common.util.ExportExcelUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * @author wangzi
 * @date 17/10/19 下午11:25.
 */
@Controller
@Scope("prototype")
@RequestMapping("/UserController")
public class UserController extends BaseController {
    private static Logger logger = Logger.getLogger(com.bamboo.web.UserController.class);

    /**
     * 注入业务接口层
     **/
    @Autowired
    private GenericService<User> genericService;

    public GenericService<User> getGenericService() {
        return genericService;
    }

    /**
     * 定义参数
     **/
    private User user;

    @ModelAttribute
    public void setParaVal(User user) {
        this.user = user;
    }

    @RequestMapping("/login.do")
    public void login() {
        User u = new User();
        u.setUsername(user.getUsername());
        List<User> resultArr = genericService.findByPojo(u);
        if (resultArr == null || resultArr.size() == 0) {
            setFailure("账号不存在");
            return;
        }
        CheckUtil.Look(resultArr.get(0));
        if (resultArr.get(0).getPassword().equals(user.getPassword())) {
            setSuccess("登录成功");
            session.setAttribute("user", resultArr.get(0));
            return;
        } else {
            setFailure("密码错误");
            return;
        }
    }

    @RequestMapping("/logout.do")
    public void logout() {
        session.removeAttribute("user");
        setSuccess("登出成功");
    }

    @RequestMapping("/findSessionByLogin.do")
    public void findSessionByLogin() {
        User u = (User) session.getAttribute("user");
        if (u == null) {
            setFailure("未登录");
            return;
        }
        setAjaxObject(u);
        return;
    }

    @RequestMapping("/findByPojo.do")
    public void findUserByPojo() {
        List<User> list = genericService.findByPojo(user);
        if (list == null || list.size() == 0) {
            setFailure("未发现users");
            return;
        }
        setAjaxObject(list);
        return;
    }

    @RequestMapping(value = "/generateExcel.do")
    public void generateExcel() {
        //得到所要导出的数据
        List<User> list = genericService.findByPojo(user);
        //定义导出excel的名字
        String excelName = "用户表";

        // 获取需要转出的excle表头的map字段
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<String, String>();
        fieldMap.put("id", "编号");
        fieldMap.put("username", "姓名");
        fieldMap.put("password", "密码");
        //导出用户相关信息
        ExportExcelUtils.export(excelName, list, fieldMap, response);
    }
}
