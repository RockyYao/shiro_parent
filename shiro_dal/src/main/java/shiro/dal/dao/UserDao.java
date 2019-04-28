package shiro.dal.dao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import shiro.dal.base.BaseMapper;
import shiro.dal.dataobject.UserDo;

/**
 * tk mapper 注解 和 xml
 *
 */
@Mapper
public interface UserDao extends BaseMapper<UserDo> {
    UserDo selectByName(UserDo userDo);
    @Select("select * from shiro_user where id=#{id}")
    UserDo selectById(UserDo userDo);
}
