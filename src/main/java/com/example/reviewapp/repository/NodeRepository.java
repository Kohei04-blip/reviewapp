package com.example.reviewapp.repository;

import com.example.reviewapp.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface NodeRepository extends JpaRepository<Node, Long> {
    
    List<Node> findByTitleContainingOrContentContaining(
        String title,
        String content
    );

}
