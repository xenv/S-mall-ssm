package tmall.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.HtmlUtils;
import tmall.annotation.Auth;
import tmall.annotation.Nullable;
import tmall.pojo.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/")
public class UserFrontController extends FrontBaseController {
    @RequestMapping("register")
    public String register(){
        return "register";
    }
    @RequestMapping("registerAdd")
    public String registerAdd(String name ,String password , Model model) throws Exception {
        String msg = null;
        if(!HtmlUtils.htmlEscape(name).equals(password)){
            msg = "用户名含有特殊字符，无法注册，请重新输入";
        }
        if(userService.isExist(name)){
            msg = "用户名已存在，无法注册，请重新输入";
        }
        if (msg != null ) {
            model.addAttribute("msg",msg);
            return "register";
        }
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.setGroup(User.Group.user);
        userService.add(user);
        return "registerSuccess";
    }
    @RequestMapping("login")
    public String login(@Nullable String refer, Model model, HttpSession session)
    {
        if (refer != null) {
            model.addAttribute("refer",refer);
        }
        if (session.getAttribute("user") != null ){
            return "redirect:/";
        }
        return "login";
    }
    @RequestMapping("loginIn")
    public String loginIn(String name ,String password , Model model, HttpSession session,String refer){
        User userFromDB = userService.get(name,password);
        if(userFromDB == null){
            String msg = "用户名密码错误，请重试";
            model.addAttribute("msg",msg);
            return "login";
        }
        session.setAttribute("user",userFromDB);
        return "redirect:"+refer;
    }
    @RequestMapping("logout")
    public String logout(@Nullable String refer,HttpSession session){
        session.removeAttribute("user");
        return "redirect:"+refer;
    }
    @RequestMapping("checkLogin")
    public String checkLogin(Model model,HttpSession session){
        String msg = session.getAttribute("user")!=null?"success":"fail";
        model.addAttribute("msg",msg);
        return "msg";
    }
    @Auth(User.Group.unLogin)
    @RequestMapping("noAuth")
    public String noAuth(Model model){
        String msg = "没有权限访问此页面";
        model.addAttribute("msg",msg);
        return "msg";
    }


}
