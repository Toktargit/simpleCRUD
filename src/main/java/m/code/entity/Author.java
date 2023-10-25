package m.code.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Author")
public class Author {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String name;
    }

