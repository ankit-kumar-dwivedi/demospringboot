package com.example.demoapi.Service;

import com.example.demoapi.DTO.*;
import com.example.demoapi.Entity.Course;
import com.example.demoapi.Entity.User;
import com.example.demoapi.Repository.CourseRepository;
import com.example.demoapi.Repository.UserRepository;
import com.example.demoapi.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EntityManager em;

    @Autowired
    private CourseRepository courseRepository;

    public List<UserDTO> getAllUsers() {
        return Utils.userListToDTOList(userRepository.findAll());
    }

    public UserDTO createUser(UserDTO user) {
        return new UserDTO(userRepository.save(Utils.userDTOtoUser(user)));
    }

    public UserDTO getUser(Long userId) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isPresent())
            return new UserDTO(user.get());
        else
            return null;
    }

    public String updateUser(User user, Long id) {
        Optional<User> user1 = userRepository.findById(id);
        if (user1.isPresent()) {
            userRepository.save(user);
            return "Updated User";
        } else
            return "No such User";
    }

    public String deleteUser(Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isPresent()) {
            userRepository.delete(user.get());
            return "Deleted User";
        } else
            return "No such User";
    }

    public List<UserDTO> userSearch(String name) {
        return Utils.userListToDTOList(userRepository.findByNameContaining(name));
    }

    public List<CourseDTO> getCoursesForUserId(Long id) {
        return Utils.courseListToDTOList(userRepository.getAllCoursesById(id)); //extra-db hit-> convert to single query
    }

    public String enrollUser(Long courseId, Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            Optional<Course> courseOptional = courseRepository.findById(courseId);
            if (courseOptional.isPresent()) {
                User user = userOptional.get();
                Course course = courseOptional.get();
                Set<Course> courseSet = user.getCourses();
                if (courseSet.contains(course)) {
                    return "Already enrolled";
                } else {
                    courseSet.add(course);
                    user.setCourses(courseSet);
                    userRepository.save(user);
                    return "User enrolled";
                }
            } else {
                return "No such Course";
            }

        } else {
            return "No such User";
        }
    }

    public Object getFilteredData(UserCourseFilterRequest request){
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Object[]> c = cb.createQuery(Object[].class);
        Root<User> user = c.from(User.class);
        Root<Course> course = c.from(Course.class);
        if(request.getUserNames()!=null){
            c.where(user.get("name").in(request.getUserNames())).distinct(true);
        }
        if(request.getUserIds()!=null){
            c.where(user.get("id").in(request.getUserIds())).distinct(true);
        }
        if(request.getCourseIds()!=null){
            c.where(course.get("course_id").in(request.getCourseIds())).distinct(true);
        }
        if (request.getCourseTitles()!=null){
            c.where(course.get("title").in(request.getCourseTitles())).distinct(true);
        }

        if(request.getFeesCond()!=null)
        {
            List<Predicate> predicateList = new ArrayList<>();
            List<FeesCondition> conditionList = request.getFeesCond();
            for(FeesCondition feesCondition: conditionList){
                Predicate predicate = cb.between(course.get("fee"), feesCondition.getFrom(), feesCondition.getTo());
                predicateList.add(predicate);
            }
            cb.or(predicateList.toArray(Predicate[]::new));
        }
        TypedQuery<Object[]> query = em.createQuery(c.multiselect(user,course).distinct(true));
        UserCourseDTO userCourseDTO = new UserCourseDTO();
        List<UserDTO> userDTOList = new ArrayList<>();
        List<CourseDTO> courseDTOList = new ArrayList<>();
        List<Object[]> arrayList = query.getResultList();
        for(Object[] a :arrayList){
            User user1 = (User) a[0];
            Course course1 = (Course) a[1];
            CourseDTO courseDTO = new CourseDTO(course1);
            UserDTO userDTO = new UserDTO(user1);
            userDTOList.add(userDTO);
            courseDTOList.add(courseDTO);
        }
        userCourseDTO.setUserDTOList(userDTOList);
        userCourseDTO.setCourseDTOList(courseDTOList);
        return userCourseDTO;
    }

    }

