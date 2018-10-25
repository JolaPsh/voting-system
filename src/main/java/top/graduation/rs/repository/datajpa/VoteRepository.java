package top.graduation.rs.repository.datajpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import top.graduation.rs.model.Vote;

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

    @Transactional(readOnly = true)
    @Query("SELECT v FROM Vote v WHERE v.user.id=:userId AND v.date=CURRENT_DATE")
    Optional<Vote> getTodayUserVote(@Param("userId") int userId);

      @Query("SELECT v FROM Vote v WHERE v.user.id=?1")
    List<Vote> getVotesByUser(int id);
}
