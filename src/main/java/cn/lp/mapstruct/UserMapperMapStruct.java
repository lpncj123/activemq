package cn.lp.mapstruct;

import cn.lp.model.User;
import cn.lp.model.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author lp
 */
@Mapper
public interface UserMapperMapStruct {
    UserMapperMapStruct INSTANCE = Mappers.getMapper(UserMapperMapStruct.class);
    @Mappings({})
    UserDTO convert(User user);
    @Mappings({})
    User convertUserVo(UserVO user);
}
