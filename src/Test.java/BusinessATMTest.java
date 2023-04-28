import org.junit.Test;
import static org.junit.Assert.*;

public class BusinessATMTest {
  
  @Test
  public void testAddAccount() {
    BusinessATM atm = new BusinessATM();
    BankAccount account = new SmallBusinessAccount("Small Business Account", "1", 1);
    atm.addAccount(account);
    assertTrue(atm.findAccount("1") == account);
  }
  
  @Test
  public void testDeposit() {
    BusinessATM atm = new BusinessATM();
    BankAccount account = new SmallBusinessAccount("Small Business Account", "1", 1);
    atm.addAccount(account);
    assertTrue(atm.deposit("1", 100.0));
    assertEquals(atm.checkBalance("1"), 100.0, 0.001);
  }
  
  @Test
  public void testCheckBalance() {
    BusinessATM atm = new BusinessATM();
    BankAccount account = new SmallBusinessAccount("Small Business Account", "1", 1);
    atm.addAccount(account);
    assertEquals(atm.checkBalance("1"), 0.0, 0.001);
    atm.deposit("1", 100.0);
    assertEquals(atm.checkBalance("1"), 100.0, 0.001);
  }
  
  @Test
  public void testFindAccount() {
    BusinessATM atm = new BusinessATM();
    BankAccount account1 = new SmallBusinessAccount("Small Business Account", "1", 1);
    BankAccount account2 = new CommunityAccount("Community Account", "2", 2);
    atm.addAccount(account1);
    atm.addAccount(account2);
    assertTrue(atm.findAccount("1") == account1);
    assertTrue(atm.findAccount("2") == account2);
    assertTrue(atm.findAccount("3") == null);
  }
}

