package converter;

import entity.Degree;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import repository.DegreeRepository;

public class DegreeConverter implements Converter<String, Degree> {

    @Autowired
    DegreeRepository degreeRepository;

    @Override
    public Degree convert(String id) {
        return degreeRepository.findById( Long.valueOf(id) );
    }
}
