package br.com.fredericci.springflix.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
    private String password;

    @OneToMany(mappedBy = "createdBy")
    private List<VideoEntity> videos;

}
