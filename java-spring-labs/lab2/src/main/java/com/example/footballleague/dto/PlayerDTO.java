package com.example.footballleague.dto;

import com.example.footballleague.entity.Player;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDTO {
    private Long id;
    
    @NotBlank(message = "First name is required")
    private String firstName;
    
    @NotBlank(message = "Last name is required")
    private String lastName;
    
    private LocalDate birthDate;
    private String nationality;
    private Player.Position position;
    private int jerseyNumber;
    private PlayerStatisticsDTO statistics;
    private Long teamId;
}
