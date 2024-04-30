        package com.example.demo.mapper;

        import com.example.demo.model.User;
        import org.apache.ibatis.annotations.Insert;
        import org.apache.ibatis.annotations.Options;
        import org.apache.ibatis.annotations.Select;

        @org.apache.ibatis.annotations.Mapper
        public interface Mapper {
            @Insert("INSERT INTO users (username, email, password, phonenumber) VALUES (#{username}, #{email}, #{password}, #{phonenumber})")
            @Options(useGeneratedKeys = true, keyProperty = "id")
            public void registerUser(User user);

        //userverification
            @Select("select * from users where email = #{email} AND password = #{password} ")
            public User verifyUserBasedOnEmail(String email, String password );

            //useremailverification for registration

            @Select("Select * from users where email = #{email}")
            public User checkUserExistance(String email);

        }

