/**
 *
 */
package com.progesco.pedagogy.service;

import java.util.List;
import java.util.Optional;

import com.progesco.pedagogy.exception.DepartmentForbiddenException;
import com.progesco.pedagogy.exception.DepartmentNotFoundException;
import com.progesco.pedagogy.utils.Constant;
import com.progesco.pedagogy.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Resource;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Department;
import com.progesco.pedagogy.repository.DepartmentRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile
 *
 */
@Service("DepartmentService")
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    /**
     * Return all departments
     * @param request
     * @return
     */
    public List<Department> getAllDepartments(HttpServletRequest request) {
        if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
                                                                                               Constant.ROLE_DEPARTMENT_VIEW,
                                                                                               this.jwtSecret)) {
            throw new DepartmentForbiddenException(Constant.ACCESS_FORBIDDEN);
        }
        return departmentRepository.findAll();
    }

	/**
	 * Return department by id
	 * @param id
	 * @param request
	 * @return
	 */
	public Department retrieveDepartment(Long id, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_DEPARTMENT_VIEW,
																							   this.jwtSecret)) {
			throw new DepartmentForbiddenException(Constant.ACCESS_FORBIDDEN);
		}

		Optional<Department> department = this.findDepartment(id);

		if (!department.isPresent())
			throw new DepartmentNotFoundException("id-" + id);

		return department.get();
	}

    /**
     * Return department by id
     * @param id
     * @return
     */
    public Optional<Department> findDepartment(Long id) {

        return departmentRepository.findById(id);
    }

    /**
     * Add a new department
     * @param department
     * @param request
     * @return
     */
    public Department addDepartment(Department department, HttpServletRequest request) {
        if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
                                                                                               Constant.ROLE_DEPARTMENT_ADD,
                                                                                               this.jwtSecret)) {
            throw new DepartmentForbiddenException(Constant.ACCESS_FORBIDDEN);
        }
        return departmentRepository.save(department);
    }

    /**
     * Add a new department
     * @param department
     * @param request
     * @return
     */
    public Department updateDepartment(Department department, HttpServletRequest request) {
        if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
                                                                                               Constant.ROLE_DEPARTMENT_UPD,
                                                                                               this.jwtSecret)) {
            throw new DepartmentForbiddenException(Constant.ACCESS_FORBIDDEN);
        }
        return departmentRepository.save(department);
    }
}
