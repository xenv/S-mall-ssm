package tmall.service.impl;

import org.springframework.stereotype.Service;
import tmall.mapper.UserMapper;
import tmall.pojo.User;
import tmall.pojo.UserExample;
import tmall.service.UserService;
import tmall.util.PasswordUtil;


@Service
public class UserServiceImpl extends BaseServiceImpl<UserMapper, UserExample> implements UserService {
    @Override
    public boolean isExist(String username) throws Exception {
        return !list("name", username).isEmpty();
    }

    @Override
    public Integer add(User user) throws Exception {
        String rawPassword = user.getPassword();
        user.setPassword(PasswordUtil.encryptPassword(rawPassword));
        return super.add(user);
    }

    @Override
    public User get(String name, String password) {
        return (User) getOne("name", name, "password", PasswordUtil.encryptPassword(password), "order","id asc");
    }
}