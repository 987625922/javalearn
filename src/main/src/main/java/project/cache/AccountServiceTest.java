package project.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AccountServiceTest {
    private static AccountService accountService;

    private final static Logger logger = LoggerFactory.getLogger(AccountServiceTest.class);

    public static void main(String[] args) {
        accountService = new AccountService();
        accountService.getAccountByName("accountName");
        accountService.getAccountByName("accountName");

        accountService.reload();
        logger.info("after reload ....");

        accountService.getAccountByName("accountName");
        accountService.getAccountByName("accountName");
    }

}
