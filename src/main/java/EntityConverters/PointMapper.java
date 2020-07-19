package EntityConverters;

import com.example.sberbank_project.model.Point;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import simpleModel.SimplePoint;

@Mapper(uses = {CarMapper.class})
public interface PointMapper {

    PointMapper INSTANCE = Mappers.getMapper(PointMapper.class);

    @Mapping(target = "carsSimple", source = "cars")
    SimplePoint toDTO(Point point);

}
