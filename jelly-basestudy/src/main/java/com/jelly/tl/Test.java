package com.jelly.tl;


import com.jelly.tl.mock.User;
import com.jelly.tl.mock.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    /**
     * 场景 1 session
     * 场景 2 线程隔离
     * 场景 3 数据链接
     * 场景 4 数据跨层传递
     * 场景 5 改变线程安全问题
     */
    private static ThreadLocal<Integer> threadLocal=new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return 0;
        }
    };

    public static void main(String[] args) {
        ApplicationContext context=new AnnotationConfigApplicationContext(UserService.class);
        UserService userService=context.getBean(UserService.class);
        User u=new User();
        u.setName("jelly");
        User user =userService.getUser(u);
        System.out.println(user);
        for (int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j=0;j<6;j++){
                        int n=threadLocal.get();
                        n++;
                        System.out.println(Thread.currentThread()+":"+n);
                        threadLocal.set(n);
                    }
                }
            }).start();
        }
        threadLocal.remove();



    }
}
