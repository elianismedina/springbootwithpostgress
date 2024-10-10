package com.elianisded.ecommercecapp.service;

import com.elianisded.ecommercecapp.dto.CommentDTO;
import com.elianisded.ecommercecapp.exception.ResourceNotFoundException;
import com.elianisded.ecommercecapp.mapper.CommentMapper;
import com.elianisded.ecommercecapp.model.Comment;
import com.elianisded.ecommercecapp.model.Product;
import com.elianisded.ecommercecapp.model.User;
import com.elianisded.ecommercecapp.repositories.CommentRepository;
import com.elianisded.ecommercecapp.repositories.ProductRepository;
import com.elianisded.ecommercecapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final CommentMapper commentMapper;

    public CommentDTO addComment(Long productId, Long userId, CommentDTO commentDTO){
        Product product = productRepository.findById(productId)
                .orElseThrow(()-> new ResourceNotFoundException("Product not found"));
        User user = userRepository.findById(userId)
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        Comment comment = commentMapper.toEntity(commentDTO);
        comment.setProduct(product);
        comment.setUser(user);
        Comment savedComment = commentRepository.save(comment);
        return commentMapper.toDTO(savedComment);

    }

    public List<CommentDTO> getCommentsByProduct(Long productId){
        List<Comment> comments = commentRepository.findByProductId(productId);
        return comments.stream()
                .map(commentMapper::toDTO)
                .collect(Collectors.toList());
    }

}