package com.elianisded.ecommercecapp.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.util.List;

@Data
public class CommentDTO {
    private Long id;
    @NotBlank(message = "Content is required")
    private String content;
    @Min(value=1)
    @Max(value=5)
    private Integer score;
    private Long userId;
    private List<CommentDTO> comments;
}
