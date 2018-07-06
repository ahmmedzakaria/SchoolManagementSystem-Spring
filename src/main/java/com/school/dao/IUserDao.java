/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.domain.Users;
import java.util.List;

/**
 *
 * @author User
 */
public interface IUserDao {
    boolean add(Users user);
    boolean delete(int id);
    boolean update(Users user);
    List<Users> getAll();
    Users getById(int id);
}
