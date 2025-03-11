package megacitycab;

import com.megacity.model.User;
import com.megacity.service.UserService;
import com.megacity.dao.UserDAO;

import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class UserServiceTest extends TestCase {

    private UserService userService;

    @Mock
    private UserDAO userDAO;

    protected void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        userService = new UserService(userDAO);
    }

    public void testValidateUser_Success() {
        // Arrange
        User mockUser = new User();
        mockUser.setEmail("test@example.com");
        mockUser.setPassword("password123");  // No BCrypt

        Mockito.when(userDAO.getUserByEmail("test@example.com")).thenReturn(mockUser);

        // Act
        User result = userService.validateUser("test@example.com", "password123");

        // Assert
        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
    }

    public void testValidateUser_UserNotFound() {
        Mockito.when(userDAO.getUserByEmail("nonexistent@example.com")).thenReturn(null);

        User result = userService.validateUser("nonexistent@example.com", "password");

        assertNull(result);
    }

    public void testValidateUser_NullInput() {
        User result = userService.validateUser(null, null);

        assertNull(result);
    }
}
