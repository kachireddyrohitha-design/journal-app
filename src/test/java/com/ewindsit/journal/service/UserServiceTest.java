package com.ewindsit.journal.service;

import com.ewindsit.journal.entity.User;
import com.ewindsit.journal.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // This annotation tells Spring Boot to look for a main configuration class (one with @SpringBootApplication, for instance) and use that to start a Spring application context.
public class UserServiceTest {
	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;
    @Autowired
    private JournalEntryService journalEntryService;
    // we need to autowire the JournalEntryService to test the relationship between User and JournalEntry
    //we need to autowire the UserRepository to test the findByUsername method
    //we need to autowire the UserService to test the addUser method
@Disabled
	@Test
	public void testAdd(){
		assertEquals(4, 2+2);
        assertTrue(5 > 4);
	} //normal test cases


@Disabled
    @Test
	public void testFindByUserName(){ //db test cases
		// Test implementation here
		assertNotNull(userRepository.findByUsername("ram"));
      User user = userRepository.findByUsername("ram");
        assertTrue(!user.getJournalEntries().isEmpty());
	}
    @Disabled
    @ParameterizedTest
    @CsvSource({
        "1, 2, 3",
        "2, 3, 5", //a value, b value, expected
        "3, 5, 8",
            "4,7,11"
    })
    public void test(int a, int b, int expected){
      assertEquals(expected, a + b);
    }
    @ParameterizedTest
    @ArgumentsSource(UserArgumentsProvider.class)
    public void testFindByUserName(User user) {
        assertTrue(userService.saveNewUser(user));
}


    @ParameterizedTest
   @ValueSource(strings = { //same as csv source but only one parameter
            "ram",
            "shyam",
            "vipul"
    })
    //enumsource, methodsource, csvsource, valuesource annotations are used to run the same test with different parameters
    public void testFindByUserName2(String name) {
        assertNotNull(userRepository.findByUsername(name));
    }


}
