package project.cache;

import lombok.extern.slf4j.Slf4j;

/**
 * 缓存操作类
 * AccountService 缓存操作服务类
 * CacheContext 缓存类
 * Account 缓存的对象类
 */
@Slf4j
public class AccountServiceTest {
    private static AccountService accountService;

    public static void main(String[] args) {
        accountService = new AccountService();
        accountService.getAccountByName("accountName");
        accountService.getAccountByName("accountName");

        accountService.reload();
        log.info("after reload ....");

        accountService.getAccountByName("accountName");
        accountService.getAccountByName("accountName");
    }

}
