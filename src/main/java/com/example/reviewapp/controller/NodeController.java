package com.example.reviewapp.controller;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.reviewapp.entity.Node;
import com.example.reviewapp.service.NodeService;

@Controller
@RequestMapping("/nodes")
public class NodeController {

    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping
    public String findAll(Model model){
        List<Node> nodes = nodeService.findAll();
        model.addAttribute("nodes", nodes);
        return "nodes/list";
    }
}