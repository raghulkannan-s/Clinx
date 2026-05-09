package com.raghul.clinx.data.dto;

public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private String role;
    private Long createdAt;

    public UserDTO(Long id, String name, String email, String role, Long createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.createdAt = createdAt;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public Long getCreatedAt() { return createdAt; }
}