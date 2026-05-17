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

    public List<Node> findAll(String keyword) {
        if (keyword == null || keyword.isBlank()) {
            return nodeRepository.findAll();
        } else {
            return nodeRepository.findByTitleContainingOrContentContaining(
                keyword,
                keyword
            );
        }
    }

    public void create(String title, String content) {
        Node node = new Node();
        node.setTitle(title);
        node.setContent(content);
        nodeRepository.save(node);
    }

    public Node findById(Long id) {
        return nodeRepository.findById(id).orElse(null);
    }

    public void update(Long id, String title, String content){
        Node node = nodeRepository.findById(id).orElse(null);
        node.setTitle(title);
        node.setContent(content);
        nodeRepository.save(node);
    }

    public void delete(Long id) {
        nodeRepository.deleteById(id);
    }

}