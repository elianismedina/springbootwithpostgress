package com.elianisded.ecommercecapp.controller;

import com.elianisded.ecommercecapp.dto.CommentDTO;
import com.elianisded.ecommercecapp.model.User;
import com.elianisded.ecommercecapp.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/product/{productId}")
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<CommentDTO> addComment(@PathVariable Long productId,
                                                 @AuthenticationPrincipal UserDetails userDetails,
                                                 @Valid @RequestBody CommentDTO commentDTO){
        Long userId = ((User) userDetails).getId();
        return ResponseEntity.ok(commentService.addComment(productId, userId, commentDTO));
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<CommentDTO>> getCommentsByProduct(@PathVariable Long productId){
        return ResponseEntity.ok(commentService.getCommentsByProduct(productId));
    }
}

