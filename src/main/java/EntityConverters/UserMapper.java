package EntityConverters;

import com.example.sberbank_project.model.Point;
import com.example.sberbank_project.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import simpleModel.SimplePoint;
import simpleModel.SimpleUser;

@Mapper(uses = {PointMapper.class})
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "points", target = "simplePoints")
    SimpleUser toDTO(User user);

}