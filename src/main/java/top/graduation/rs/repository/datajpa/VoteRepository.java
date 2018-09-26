package top.graduation.rs.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import top.graduation.rs.model.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * Created by Joanna Pakosh on Авг., 2018
 */

@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Integer> {

    @Override
    @Transactional
    Vote save(Vote vote);

    @Transactional(readOnly = true)  //AND YEAR(dateTime)=YEAR(NOW()) AND MONTH(dateTime)=MONTH(NOW()) AND DAY(dateTime)=DAY(NOW())")
    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId AND v.date=:date")
    Optional<Vote> getTodayUserVote(@Param("userId") int userId, @Param("date") LocalDate date);

    @Query("SELECT v.id, u.email, r.title, v.date FROM Vote v INNER JOIN v.user u " +
            "INNER JOIN v.restaurant r WHERE u.id=:userId")
    List<Vote> getUserVoteHistory(@Param("userId") int userId);
}
