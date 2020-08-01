## String

1. ### 3大核心机制

   - #### 不变性

   - #### 常量池优化 

     ##### string创建之后会在常量池中进行缓存，下次创建同样字符串时会直接返回缓存引用

   - #### final

     #####  不可被继承，提高了系统安全性

 2. ### string赋值2种方式 

    - #### 直接赋值

      ```
      String s = "123"; //保存在string常量池中，下次创建时返回的是常量池引用
      ```

    - #### 构造函数赋值

      ```
      String s = new String("123"); //保存在堆内存中
      ```

      
