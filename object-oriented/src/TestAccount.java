import com.tekheroes.bank.Account;
import com.tekheroes.bank.AccountFactory;

public class TestAccount {

	public static void main(String[] args) {
		
		Account checking = AccountFactory.openChecking("Ben"); // here we need checking account object;
		
		Account business = AccountFactory.openBusiness("Carl"); // here we need business account object
		
		checking.summary();
		
		business.summary();
		
	}
}
