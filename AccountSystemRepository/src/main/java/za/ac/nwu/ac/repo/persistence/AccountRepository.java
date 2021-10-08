package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(
            value = "SELECT "+"MEMBER_ID,"+"FNAME,"+"LNAME,"+"MILES "+
                    "FROM "+"TIMON.ACCOUNT "+"WHERE FNAME = :fName "+"AND "+"LNAME = :lName", nativeQuery = true
    )
    Account getMilesByMemberName(String fName, String lName);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(
            value = "UPDATE "+"TIMON.ACCOUNT "+
                    "SET "+"Miles = Miles + :miles "+
                    "WHERE FNAME = :fName "+"AND "+"LNAME = :lName ", nativeQuery = true
    )
    Integer add(Integer miles, String fName, String lName);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(
            value = "UPDATE "+"TIMON.ACCOUNT "+
                    "SET "+"Miles = Miles - :miles "+
                    "WHERE FNAME = :fName "+"AND "+"LNAME = :lName", nativeQuery = true
    )
    Integer sub(Integer miles, String fName, String lName);
}
