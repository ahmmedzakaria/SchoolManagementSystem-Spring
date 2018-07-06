/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.dao;

import com.school.domain.Guardian;
import java.util.List;

/**
 *
 * @author User
 */
public interface IGuardianDao {
    boolean add(Guardian user);
    boolean delete(int id);
    boolean update(Guardian user);
    List<Guardian> getAll();
    Guardian getById(int id);
}
