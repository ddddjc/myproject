package com.dspt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
      private String username;
      private String password;
      private String name;
      private Integer age;
      private String sex;
      private String addr;
      private String birth;
      private String phone;
      private String root;
      private String url;
}
