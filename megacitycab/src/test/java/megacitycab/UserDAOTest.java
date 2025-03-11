package megacitycab;

import com.megacity.dao.UserDAO;
import com.megacity.model.User;

import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAOTest extends TestCase {

    private UserDAO userDAO;

    @Mock
    private Connection mockConnection;
    
    @Mock
    private PreparedStatement mockStatement;
    
    @Mock
    private ResultSet mockResultSet;

    protected void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        userDAO = new UserDAO(mockConnection); 
    }

    public void testGetUserByEmail_Success() throws Exception {
        
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);
        Mockito.when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        Mockito.when(mockResultSet.next()).thenReturn(true);

        Mockito.when(mockResultSet.getString("email")).thenReturn("test@example.com");
        Mockito.when(mockResultSet.getString("password")).thenReturn("password123");

       
        User result = userDAO.getUserByEmail("test@example.com");

       
        assertNotNull(result);
        assertEquals("test@example.com", result.getEmail());
        assertEquals("password123", result.getPassword());
    }

    public void testGetUserByEmail_NotFound() throws Exception {
      
        Mockito.when(mockConnection.prepareStatement(Mockito.anyString())).thenReturn(mockStatement);
        Mockito.when(mockStatement.executeQuery()).thenReturn(mockResultSet);
        Mockito.when(mockResultSet.next()).thenReturn(false);

        
        User result = userDAO.getUserByEmail("nonexistent@example.com");

       
        assertNull(result);
    }
}
