package com.kodilla.ecommercee.service;

import com.kodilla.ecommercee.domain.Group;
import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class GroupService {
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private GroupMapper groupMapper;

    public List<GroupDto> getAllGroups() {
        return groupMapper.mapToGroupDtoList(groupRepository.findAll());
    }

    public GroupDto getGroup(long id) throws GroupNotFoundException  {
        return groupMapper.mapToGroupDto(groupRepository.findById(id).orElseThrow(GroupNotFoundException::new));
    }

    public Group saveGroup(GroupDto groupDto) {
        return groupRepository.save(groupMapper.mapToGroup(groupDto));
    }

    public GroupDto updateGroup(GroupDto groupDto) {
        return groupMapper.mapToGroupDto(groupRepository.save(groupMapper.mapToGroup(groupDto)));
    }
}

