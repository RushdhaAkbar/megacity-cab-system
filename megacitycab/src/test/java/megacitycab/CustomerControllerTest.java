package megacitycab;


import junit.framework.TestCase;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.megacity.controller.CustomerController;
import com.megacity.model.Customer;
import com.megacity.service.CustomerService;


public class CustomerControllerTest extends TestCase {

    private CustomerController customerController;
    
    @Mock
    private CustomerService customerService; 

    protected void setUp() throws Exception {
    	MockitoAnnotations.openMocks(this);
        customerController = new CustomerController(); 
    }

    public void testRegisterCustomer_Success() {
       
        Customer customer = new Customer(01,"John Doe", "john@example.com", "password123", "123456789V", "123 Main St", "0712345678");
         //Mockito.when(customerService.addCustomer(Mockito.any(Customer.class))).thenReturn("Customer Registered Successfully!");
        // String result = customerController.addCustomer(customer);
        
        
        //assertEquals("Customer Registered Successfully!", result);
    }

    
}
