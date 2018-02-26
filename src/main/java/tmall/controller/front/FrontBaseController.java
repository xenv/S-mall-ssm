package tmall.controller.front;

import tmall.controller.BaseController;
import tmall.annotation.Auth;
import tmall.pojo.User;

@Auth(User.Group.unLogin)
public class FrontBaseController extends BaseController {

}
