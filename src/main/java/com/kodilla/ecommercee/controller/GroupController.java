package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.GroupDto;
import com.kodilla.ecommercee.domain.GroupNotFoundException;
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

    @GetMapping
    public List<GroupDto> getAll() {
        return service.getAllGroups();
    }

    @GetMapping("/{id}")
    public GroupDto get(@PathVariable(required = true) long id) throws GroupNotFoundException {
        return service.getGroup(id);
    }

    @PostMapping
    public void add(@RequestBody GroupDto groupDto) {
        service.saveGroup(groupDto);
    }

    @PutMapping
    public GroupDto update(@RequestBody GroupDto groupDto) {
        return service.updateGroup(groupDto);
    }

}
