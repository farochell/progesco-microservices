/**
 *
 */
package com.progesco.pedagogy.service;

import java.util.List;
import java.util.Optional;

import com.progesco.pedagogy.exception.SpecialityForbiddenException;
import com.progesco.pedagogy.exception.SpecialityNotFoundException;
import com.progesco.pedagogy.utils.Constant;
import com.progesco.pedagogy.utils.Helpers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Speciality;
import com.progesco.pedagogy.repository.SpecialityRepository;

import javax.servlet.http.HttpServletRequest;

/**
 * @author emile
 *
 */
@Service("SpecialityService")
public class SpecialityService {
    @Autowired
    private SpecialityRepository specialityRepository;

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    /**
     * Return all specialities
     * @param request
     * @return
     */
    public List<Speciality> getAllSpecialities(HttpServletRequest request) {
        if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
                                                                                               Constant.ROLE_SPECIALITY_VIEW,
                                                                                               this.jwtSecret)) {
            throw new SpecialityForbiddenException(Constant.ACCESS_FORBIDDEN);
        }
        return specialityRepository.findAll();
    }

    /**
     * Add a new speciality
     * @param speciality
     * @param request
     */
    public Speciality addSpeciality(Speciality speciality, HttpServletRequest request) {
        if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
                                                                                               Constant.ROLE_SPECIALITY_ADD,
                                                                                               this.jwtSecret)) {
            throw new SpecialityForbiddenException(Constant.ACCESS_FORBIDDEN);
        }
        return specialityRepository.save(speciality);
    }

    /**
     * Retrieve speciality by ID
     * @param id
     * @return
     */
    public Optional<Speciality> findSpeciality(Long id) {
        return specialityRepository.findById(id);
    }

    /**
     * Allows to update a speciality
     * @param speciality
     * @param request
     * @return
     */
    public Speciality updateSpeciality(Speciality speciality, HttpServletRequest request) {
        if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
                                                                                               Constant.ROLE_SPECIALITY_UPD,
                                                                                               this.jwtSecret)) {
            throw new SpecialityForbiddenException(Constant.ACCESS_FORBIDDEN);
        }
        return specialityRepository.save(speciality);
    }

	/**
	 *
	 * @param id
	 * @param request
	 * @return
	 */
	public Speciality retrieveSpeciality(Long id, HttpServletRequest request) {
		if (!Helpers.hasRole(request, Constant.ROLE_ADMIN, this.jwtSecret) && !Helpers.hasRole(request,
																							   Constant.ROLE_SPECIALITY_VIEW,
																							   this.jwtSecret)) {
			throw new SpecialityForbiddenException(Constant.ACCESS_FORBIDDEN);
		}

		Optional<Speciality> speciality = this.findSpeciality(id);

		if (!speciality.isPresent())
			throw new SpecialityNotFoundException("id-" + id);

		return speciality.get();
	}
}
