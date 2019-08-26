/**
 * 
 */
package com.progesco.pedagogy.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.progesco.pedagogy.entity.Classroom;
import com.progesco.pedagogy.entity.Group;
import com.progesco.pedagogy.model.GroupModel;
import com.progesco.pedagogy.model.GroupModelCollection;
import com.progesco.pedagogy.repository.GroupRepository;

/**
 * @author emile.camara
 *
 */
@Service("GroupService")
public class GroupService {
	@Autowired
	private GroupRepository groupRepository;
	@Autowired
	private ClassroomService classroomService;
	
	/**
	 * Allow to build group model
	 * @param group
	 * @return
	 */
	public GroupModel buildGroupModel(Group group) {
		GroupModel groupModel = new GroupModel();
		groupModel.setId(group.getId());
		groupModel.setClassroomId(group.getClassroom().getId());
		groupModel.setLabel(group.getLabel());
		
		return groupModel;
	}
	
	/**
	 * Allow to build Group entity
	 * @param groupModel
	 * @return
	 */
	public Group buildGroup(GroupModel groupModel) {		
		Optional<Classroom> classroom = classroomService.findClassroom(groupModel.getClassroomId());
		Group group = new Group();		
		group.setLabel(groupModel.getLabel());
		group.setClassroom(classroom.get());
		
		return group;		
	}
	
	/**
	 * Return all group of given classroom ID
	 * @param id
	 * @return
	 */
	public List<GroupModel> getGroupByClassroom(Long id) {
		List<GroupModel> groupModels = new ArrayList<>();
		Optional<Classroom> classroom = classroomService.findClassroom(id);
		List<Group> groups = groupRepository.findByClassroom(classroom.get());
		for(Group group: groups) {
			groupModels.add(buildGroupModel(group));
		}
		return groupModels;
	}
	
	/**
	 * Add a new group
	 * @param groupModel
	 * @return
	 */
	public GroupModel addGroup(GroupModel groupModel) {
		Group group = buildGroup(groupModel);
		groupRepository.save(group);
		groupModel = buildGroupModel(group);
		
		return groupModel;
	}
	
	/**
	 * Update a group
	 * @param groupModel
	 * @return
	 */
	public GroupModel updateGroup(GroupModel groupModel) {
		Group group = buildGroup(groupModel);
		group.setId(groupModel.getId());
		groupRepository.save(group);
		groupModel = buildGroupModel(group);
		
		return groupModel;
	}
	
	/**
	 * Retrieve a group by its ID
	 * @param id
	 * @return
	 */
	public GroupModel retrieveGroup(Long id) {
		Optional<Group> group = groupRepository.findById(id);
		return buildGroupModel(group.get());
	}
	
	/**
	 * Retrieve all students
	 * @return
	 */	
	public GroupModelCollection getAllGroups(Pageable pageable) {
		GroupModelCollection groupModelCollection = new GroupModelCollection();
		Page<Group> groups = groupRepository.findAll(pageable);		
		int totalPages = groups.getTotalPages();
		if(totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1,totalPages).boxed().collect(Collectors.toList());
            groupModelCollection.setTotalItems(pageNumbers);
        }
		List<GroupModel> groupModels = new ArrayList<>();
		
		for(Group group: groups.getContent()) {
			
			groupModels.add(buildGroupModel(group));
		}
		
		groupModelCollection.setGroupModels(groupModels);
		
		return groupModelCollection;
	}
	
	/**
	 * Delete a group
	 * @param id
	 */
	public void deleteGroup(Long id) {
		Optional<Group> group = groupRepository.findById(id);
		groupRepository.delete(group.get());
	}
	
}
