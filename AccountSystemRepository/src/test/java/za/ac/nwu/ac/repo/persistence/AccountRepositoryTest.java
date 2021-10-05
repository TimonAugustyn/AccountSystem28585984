//package za.ac.nwu.ac.repo.persistence;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringRunner;
//import za.ac.nwu.ac.domain.persistence.Account;
//import za.ac.nwu.ac.repo.config.RepositoryConfigTest;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//
//
//import static org.junit.Assert.*;
//
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@ContextConfiguration(classes = {RepositoryConfigTest.class})
//public class AccountRepositoryTest {
//
//    @Autowired
//    AccountRepository accountRepository;
//
//    @Before
//    public void setUp() throws Exception {
//    }
//
//    @After
//    public void tearDown() throws Exception {
//    }
//
//    @Test
//    public void getMilesByMemberName() {
//        Account miles = accountRepository.getMilesByMemberName("Timon", "Augustyn");
//        assertNotNull(miles);
//        assertEquals("Timon", miles.getfName());
//        //assertEquals("Augustyn", miles.getlName());
//    }
//
//    @Test
//    public void add() {
//        Integer miles = accountRepository.add(20, "Timon", "Augustyn");
//        assertNotNull(miles);
//        assertEquals("FNAME", "Timon");
//        assertEquals("LNAME", "Augustyn");
//    }
//
//    @Test
//    public void sub() {
//        Integer miles = accountRepository.sub(20, "Timon", "Augustyn");
//        assertNotNull(miles);
//        assertEquals("FNAME", "Timon");
//        assertEquals("LNAME", "Augustyn");
//    }
//}