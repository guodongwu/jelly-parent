###### 1.show processlist; 查看进程

###### 2.大数据下count(*)是瓶颈 需要优化

###### 3.replace into 必须有主键或者唯一索引

###### 4.临时表创建 TEMPORARY  TABLE 和limit 1 结合使用

###### 5.赋值变量

```mysql
set @xx=xx;
select @xx:=xx from table;
select xx into @xx from table;
-- 局部变量 存储过程中使用
declare i int default 0
set i=0;

```



###### 6 explain 使用

###### 7.CONCAT(连接字符串) 和 group_concat(连接分组，可以把某个列合并,隔开);

###### 8.动态语句的使用

      ```mysql
      PREPARE stmt1 FROM @xx;
      EXECUTE stmt1;
      DEALLOCATE PREPARE stmt1;
      
      ```
###### 9.循环语句的使用

```mysql
while xx<yy do
	-- 代码逻辑
end while;
```
```mysql
loop_name:loop
    -- 代码逻辑
   if xxx then 
       	leave loop_name; -- 退出循环
   end if;
end loop; 
```
```mysql
repeat
  -- 代码逻辑
until xx>yy end repeat;
```

###### 10.  mysql 变量之坑，全局变量