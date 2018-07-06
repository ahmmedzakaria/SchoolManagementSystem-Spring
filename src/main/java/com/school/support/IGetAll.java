/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.school.support;

import java.util.List;

@FunctionalInterface
public interface IGetAll<T> {
    List<T> get(String name);
}
