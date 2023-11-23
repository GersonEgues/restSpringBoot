package ms.sapa.usuarios.domain.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "user_detail")
public class UserDetail {
    @Id
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "birth_day")
    private Date birthDay;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Users users;

}
