package br.com.fredericci.springflix.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDate;


@Data
@Entity
@NoArgsConstructor
public class VideoEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String title;
    private String description;
    private String youtubeUrl;

    @CreatedDate
    private LocalDate createdDate;

    @CreatedBy
    @ManyToOne
    private UserEntity createdBy;
}
