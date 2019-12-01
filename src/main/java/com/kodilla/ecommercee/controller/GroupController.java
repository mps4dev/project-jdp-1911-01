package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.GroupNotFoundException;
import com.kodilla.ecommercee.mapper.GroupMapper;
import com.kodilla.ecommercee.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/groups")
public class GroupController {
    @Autowired
    private GroupService service;
    @Autowired
    private GroupMapper groupMapper;

    @GetMapping
    public List<GroupDto> getAll() {
        return groupMapper.mapToGroupDtoList(service.getAllGroups());
    }

    @GetMapping("/{id}")
    public GroupDto get(@PathVariable(required = true) Long id) throws GroupNotFoundException {
        return groupMapper.mapToGroupDto(service.getGroup(id).orElseThrow(GroupNotFoundException::new));
    }

    @PostMapping
    public void add(@RequestBody GroupDto groupDto) {
        service.saveGroup(groupMapper.mapToGroup(groupDto));
    }

    @PutMapping
    public GroupDto update(@RequestBody GroupDto groupDto) {
        return groupMapper.mapToGroupDto(service.saveGroup(groupMapper.mapToGroup(groupDto)));
    }

}
