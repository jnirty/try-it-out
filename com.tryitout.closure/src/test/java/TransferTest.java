import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import com.agiledeveloper.pcj.Account;
import com.agiledeveloper.pcj.Transfer;

public class TransferTest {
	Account account1;
	Account account2;

	@Before
	public void initAccountBalance() {

		try {
			account1 = new Account(2000);
			account2 = new Account(100);
		} catch (Exception exc) {
			System.out.println("Test init failed " + exc.getLocalizedMessage());
			exc.printStackTrace();
		}

	}

	@Test
	public void shouldAllowTransactionfinishWhenEnoughMoney() throws Exception {
		// given - ballance setup

		// when
		transferAndPrint(account1, account2, 500);

		// then
		assertEquals(account1.getBalance(), 1500);
		assertEquals(account2.getBalance(), 600);
	}

	@Test
	public void shoudRollBackTransactionWhenNoMoneyLeft() {
		// given - ballance setup

		// when
		try {
			transferAndPrint(account1, account2, 5000);
			fail("Should not allow transfer more than on account");
		} catch (Exception exc) {

			// then should throw Exception and rollback transaction
			assertEquals(account1.getBalance(), 2000);
			assertEquals(account2.getBalance(), 100);
		}

	}

	public void transferAndPrint(final Account from, final Account to, final int amount) throws Exception {
		Transfer.transfer(from, to, amount);

		System.out.println("Balance of from account is " + from.getBalance());
		System.out.println("Balance of to account is " + to.getBalance());
	}
}
