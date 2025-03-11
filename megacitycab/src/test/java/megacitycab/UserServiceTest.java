//package megacitycab;
//
//
//import com.megacity.model.User;
//import com.megacity.service.UserService;
//
//import junit.framework.TestCase;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//import org.mindrot.jbcrypt.BCrypt;
//
//public class UserServiceTest extends TestCase {
//
//    private UserServiceTest userServiceTest;
//
//    @Mock
//    private UserDAOTest userDAOTest;
//
//    protected void setUp() throws Exception {
//        MockitoAnnotations.openMocks(this);
//        userServiceTest = new UserServiceTest();
//    }
//
//    public void testValidateUser_Success() {
//        // Arrange
//        String hashedPassword = BCrypt.hashpw("password123", BCrypt.gensalt());
//        User mockUser = new User();
//        mockUser.setEmail("test@example.com");
//        mockUser.setPassword(hashedPassword);
//
//        Mockito.when(userDAOTest.getUserByEmail("test@example.com")).thenReturn(mockUser);
//
//        // Act
//        User result = userServiceTest.validateUser("test@example.com", "password123");
//
//        // Assert
//        assertNotNull(result);
//        assertEquals("test@example.com", result.getEmail());
//    }
//
//    private User validateUser(String string, String string2) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	
//    public void testValidateUser_UserNotFound() {
//        Mockito.when(userDAOTest.getUserByEmail("nonexistent@example.com")).thenReturn(null);
//
//        User result = userServiceTest.validateUser("nonexistent@example.com", "password");
//
//        assertNull(result);
//    }
//
//    public void testValidateUser_NullInput() {
//        User result = userServiceTest.validateUser(null, null);
//
//        assertNull(result);
//    }
//}
