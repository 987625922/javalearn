package project.cache;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import com.google.common.base.Optional;

/**
 * 缓存操作服务类
 */
@Slf4j
public class AccountService {

    @Resource
    private CacheContext<Account> accountCacheContext;

    public Account getAccountByName(String accountName) {
        //从缓存中获取
        Account result = accountCacheContext.get(accountName);
        if (result != null) {
            log.info("get from cache... {}", accountName);
            return result;
        }
        //缓存中没有就从数据库中获取
        Optional<Account> accountOptional = getFromDB(accountName);
        if (!accountOptional.isPresent()) {
            throw new IllegalStateException(String.format("can not find account by account name : [%s]", accountName));
        }
        Account account = accountOptional.get();
        //把数据存入缓存中
        accountCacheContext.addOrUpdateCache(accountName, account);
        return account;
    }

    public void reload() {
        accountCacheContext.evictCache();
    }

    /**
     * 从数据库中取
     * @param accountName
     * @return
     */
    private Optional<Account> getFromDB(String accountName) {
        log.info("real querying db... {}", accountName);
        return Optional.fromNullable(new Account(accountName));
    }
}
