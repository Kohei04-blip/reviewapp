package com.example.reviewapp.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.reviewapp.entity.Node;
import com.example.reviewapp.repository.NodeRepository;

@Service
public class NodeService {

    private final NodeRepository nodeRepository;

    public NodeService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    public List<Node> findAll() {
        return nodeRepository.findAll();
    }
}