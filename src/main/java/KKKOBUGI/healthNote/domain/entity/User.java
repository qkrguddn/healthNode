package KKKOBUGI.healthNote.domain.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    private String nickname;

    private String loginId;

    private String loginPw;

    @OneToMany(mappedBy = "user")
    private List<ExerciseLog> exerciseLogs = new ArrayList<>();

    //    게시판, 댓글은 단방향으로 해도 상관없으나 이후에 회원이 작성한 글만 따로 조회할 때 필요하기에 추가함.
    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();
    @OneToMany(mappedBy = "user")
    private List<Comment> comments = new ArrayList<>();
}

