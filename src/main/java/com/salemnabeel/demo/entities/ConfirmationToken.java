package com.salemnabeel.demo.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "confirmation_token")
public class ConfirmationToken {

    @Id
    @SequenceGenerator(
        name = "confirmation_token_sequence",
        sequenceName = "confirmation_token_sequence",
        allocationSize = 1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "confirmation_token_sequence"
    )
    private Long id;

    @Column(nullable = false)
    private String token;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "expires_at", nullable = false)
    private LocalDateTime expiresAt;

    @Column(name = "confirmed_at")
    private LocalDateTime confirmedAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public ConfirmationToken(String token, LocalDateTime createdAt, LocalDateTime expiresAt, User user) {

        this.token = token;

        this.createdAt = createdAt;

        this.expiresAt = expiresAt;

        this.user = user;
    }
}