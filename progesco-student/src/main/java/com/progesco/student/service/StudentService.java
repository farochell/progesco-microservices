/**
 *
 */
package com.progesco.student.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.progesco.student.exception.StudentForbiddenException;
import com.progesco.student.utils.Constant;
import com.thoughtworks.xstream.security.ForbiddenClassException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.progesco.student.entity.Student;
import com.progesco.student.exception.StudentNotFoundException;
import com.progesco.student.model.StudentCollectionModel;
import com.progesco.student.model.StudentModel;
import com.progesco.student.repository.StudentRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile
 *
 */
@Service("StudentService")
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    /**
     * Build student model from student entity
     * @param student
     * @return
     */
    private StudentModel buildStudentModel(Student student) {
        StudentModel studentModel = new StudentModel();

        studentModel.setId(student.getId());
        studentModel.setAddress(student.getAddress());
        studentModel.setBirthDate(student.getBirthDate());
        studentModel.setCreatedAt(student.getCreatedAt());
        studentModel.setCreatedBy(student.getCreatedBy());
        studentModel.setEmail(student.getEmail());
        studentModel.setFatherFirstname(student.getFatherFirstname());
        studentModel.setFatherLastname(student.getFatherLastname());
        studentModel.setFatherProfession(student.getFatherProfession());
        studentModel.setFirstName(student.getFirstName());
        studentModel.setGender(student.getGender());
        studentModel.setGuardianAddress(student.getGuardianAddress());
        studentModel.setGuardianFirstname(student.getGuardianFirstname());
        studentModel.setGuardianLastname(student.getGuardianLastname());
        studentModel.setGuardianMainPhone(student.getGuardianMainPhone());
        studentModel.setGuardianSecondPhone(student.getGuardianSecondPhone());
        studentModel.setLastName(student.getLastName());
        studentModel.setMainPhone(student.getMainPhone());
        studentModel.setMaritalStatus(student.getMaritalStatus());
        studentModel.setMotherFirstname(student.getMotherFirstname());
        studentModel.setMotherLastname(student.getMotherLastname());
        studentModel.setMotherProfession(student.getMotherProfession());
        studentModel.setNbChild(student.getNbChild());
        studentModel.setPlaceOfBirth(student.getPlaceOfBirth());
        studentModel.setRegistrationNumber(student.getRegistrationNumber());
        studentModel.setSecondPhone(student.getSecondPhone());

        return studentModel;
    }

    /**
     * Build student entity from student model
     * @param studentModel
     * @return
     */
    public Student buildStudent(StudentModel studentModel) {
        Student student = new Student();

        student.setId(studentModel.getId());
        student.setAddress(studentModel.getAddress());
        student.setBirthDate(studentModel.getBirthDate());
        student.setCreatedBy(studentModel.getCreatedBy());
        student.setEmail(studentModel.getEmail());
        student.setFatherFirstname(studentModel.getFatherFirstname());
        student.setFatherLastname(studentModel.getFatherLastname());
        student.setFatherProfession(studentModel.getFatherProfession());
        student.setFirstName(studentModel.getFirstName());
        student.setGender(studentModel.getGender());
        student.setGuardianAddress(studentModel.getGuardianAddress());
        student.setGuardianFirstname(studentModel.getGuardianFirstname());
        student.setGuardianLastname(studentModel.getGuardianLastname());
        student.setGuardianMainPhone(studentModel.getGuardianMainPhone());
        student.setGuardianSecondPhone(studentModel.getGuardianSecondPhone());
        student.setLastName(studentModel.getLastName());
        student.setMainPhone(studentModel.getMainPhone());
        student.setMaritalStatus(studentModel.getMaritalStatus());
        student.setMotherFirstname(studentModel.getMotherFirstname());
        student.setMotherLastname(studentModel.getMotherLastname());
        student.setMotherProfession(studentModel.getMotherProfession());
        student.setNbChild(studentModel.getNbChild());
        student.setPlaceOfBirth(studentModel.getPlaceOfBirth());
        student.setRegistrationNumber(studentModel.getRegistrationNumber());

        return student;
    }

    /**
     * Retrieve all students
     * @param pageable
     * @param request
     * @return
     */
    public StudentCollectionModel getAllStudents(Pageable pageable, HttpServletRequest request) {
		if (!hasRole(request, Constant.ROLE_ADMIN) || !hasRole(request, Constant.ROLE_PEDAGOGY_VIEW)) {
			throw new StudentForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
        StudentCollectionModel studentCollectionModel = new StudentCollectionModel();
        Page<Student> students = studentRepository.findAll(pageable);
        int totalPages = students.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages).boxed().collect(Collectors.toList());
            studentCollectionModel.setTotalItems(pageNumbers);
        }
        List<StudentModel> studentModels = new ArrayList<>();

        for (Student student : students.getContent()) {
            studentModels.add(buildStudentModel(student));
        }

        studentCollectionModel.setStudentModels(studentModels);

        return studentCollectionModel;
    }

	/**
	 * Allow to check role
	 * @param request
	 * @param role
	 * @return
	 */
    public Boolean hasRole(HttpServletRequest request, String role) {
        String[] tempArray;
        String bearerToken = request.getHeader("Authorization");
        Claims claims = Jwts.parser()
                .setSigningKey(this.jwtSecret)
                .parseClaimsJws(bearerToken.substring(7, bearerToken.length()))
                .getBody();
        String roles = (String) claims.get("scopes");
        tempArray = roles.split(",");

        return Arrays.asList(tempArray).contains(role);
    }

    /**
     * Add a new student
     * @param studentModel
     * @return
     */
    public StudentModel addStudent(StudentModel studentModel, HttpServletRequest request) {
		if (!hasRole(request, Constant.ROLE_ADMIN) || !hasRole(request, Constant.ROLE_PEDAGOGY_ADD)) {
			throw new StudentForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
        Student student = buildStudent(studentModel);
        studentRepository.save(student);
        String name = student.getFirstName().substring(0, 2).toUpperCase();
        String lname = student.getLastName().substring(0, 2).toUpperCase();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyyMMdd");
        String date = DATE_FORMAT.format(student.getCreatedAt());
        String registration = "ET-" + name + lname + "-" + date + student.getId();
        student.setRegistrationNumber(registration);
        studentRepository.save(student);

        studentModel = buildStudentModel(student);

        return studentModel;
    }

    /**
     * Update a record
     * @param studentModel
     * @return
     */
    public StudentModel updateStudent(StudentModel studentModel, HttpServletRequest request) {
		if (!hasRole(request, Constant.ROLE_ADMIN) || !hasRole(request, Constant.ROLE_PEDAGOGY_UPD)) {
			throw new StudentForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
        Student student = buildStudent(studentModel);
        studentRepository.save(student);
        studentModel = buildStudentModel(student);

        return studentModel;
    }

    /**
     * Find a student by given ID
     * @param id
     * @return
     */
    public StudentModel retrieveStudent(Long id, HttpServletRequest request) {
		if (!hasRole(request, Constant.ROLE_ADMIN) || !hasRole(request, Constant.ROLE_PEDAGOGY_VIEW)) {
			throw new StudentForbiddenException(Constant.ACCESS_FORBIDDEN);
		}
        Optional<Student> student = studentRepository.findById(id);
        StudentModel studentModel = new StudentModel();
        if (!student.isPresent()) {
            throw new StudentNotFoundException("Id not found: " + id);
        }
        studentModel = buildStudentModel(student.get());

        return studentModel;
    }


}
