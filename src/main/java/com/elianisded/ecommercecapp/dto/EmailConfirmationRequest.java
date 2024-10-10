package com.elianisded.ecommercecapp.dto;

import lombok.Data;

@Data
public class EmailConfirmationRequest {
    private String email;
    private String confirmationCode;
}
