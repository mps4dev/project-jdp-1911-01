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
    private GroupService groupService;

    @GetMapping
    public List<GroupDto> getAll() {
        return groupService.getAll();
    }

    @GetMapping("/{groupId}")
    public GroupDto get(@PathVariable(required = true) long groupId) throws GroupNotFoundException {
        return groupService.get(groupId);
    }

    @PostMapping
    public void create(@RequestBody GroupDto groupDto) {
        groupService.create(groupDto);
    }

    @PutMapping
    public GroupDto update(@RequestBody GroupDto groupDto) {
        return groupService.update(groupDto);
    }

}
