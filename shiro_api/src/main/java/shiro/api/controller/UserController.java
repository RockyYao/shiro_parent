package shiro.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import shiro.dal.dao.UserDao;
import shiro.dal.dataobject.UserDo;

@RestController
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        UserDo userDo=new UserDo();
        userDo.setName("rocky");
        userDo.setPassword("123456");
        try {
            userDao.insert(userDo);
            return "success";
        }catch (Exception e){
            System.out.println(e);
            return "fail";
        }
    }

    @RequestMapping(value = "/test2",method = RequestMethod.GET)
    public UserDo test2(){
        UserDo userDo=new UserDo();
        userDo.setId(1);
        return userDao.selectByName(userDo);
    }
    @RequestMapping(value = "/test3",method = RequestMethod.GET)
    public UserDo test3(){
        UserDo userDo=new UserDo();
        userDo.setId(1);
        return userDao.selectById(userDo);
    }
}
