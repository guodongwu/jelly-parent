package com.jelly.shiro.study.credentials;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;

import java.util.concurrent.atomic.AtomicInteger;

public class RetryLimitHashedCredentialsMatcher extends HashedCredentialsMatcher {
    private Ehcache passwordRetryCache;

    public  RetryLimitHashedCredentialsMatcher(){
        CacheManager cacheManager=CacheManager.create(CacheManager.class.getClassLoader().getResourceAsStream("classpath:ehcache.xml"));
        passwordRetryCache=cacheManager.getCache("passwordRetryCache");
    }
    @Override
    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        String username= (String) token.getPrincipal();
        Element element=passwordRetryCache.get(username);
        if(element==null){
            element=new Element(username,new AtomicInteger(0));

            passwordRetryCache.put(element);
        }
        AtomicInteger retryCount= (AtomicInteger) element.getObjectValue();
        if(retryCount.incrementAndGet()>5){
            throw  new ExcessiveAttemptsException();
        }
        boolean matches=super.doCredentialsMatch(token,info);
        if(matches){
            passwordRetryCache.remove(username);
        }
        return matches;
    }
}
