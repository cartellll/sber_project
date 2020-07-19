package EntityConverters;


import com.example.sberbank_project.model.Car;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import simpleModel.SimpleCar;

@Mapper
public interface CarMapper {

    CarMapper INSTANCE = Mappers.getMapper(CarMapper.class);

    SimpleCar toDTO(Car car);

    @InheritInverseConfiguration
    Car toEntity(SimpleCar simpleCar);

}
