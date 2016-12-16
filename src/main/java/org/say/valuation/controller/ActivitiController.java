package org.say.valuation.controller;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.say.valuation.entity.User;
import org.say.valuation.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by say on 09/12/2016.
 */
@RestController
@RequestMapping("activiti")
public class ActivitiController {

    @Resource
    private ProcessEngine processEngine;

    @Resource
    private RuntimeService runtimeService;

    @Resource
    private TaskService taskService;

    @Resource
    private UserService userService;

    @RequestMapping("start")
    public String start() {
        User user = this.userService.findByUsername("admin");
        Map<String, Object> variables = new HashMap<>();
        variables.put("user", user);
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("oneTaskProcess", variables);
        return "ok";
    }

    @RequestMapping("tasks")
    public String tasks() {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("1").list();
        System.out.println(tasks);
        for (Task task : tasks) {
            System.out.println(task.getId() + ":" + task.getName() + ":" + task.getAssignee());
        }
        return "ok";
    }

}