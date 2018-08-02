package converter;

import entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import repository.CourseRepository;

public class CourseConverter implements Converter<String, Course> {

    @Autowired
    CourseRepository courseRepository;

    @Override
    public Course convert(String id) {
        return courseRepository.findById( Long.valueOf(id) );
    }
}
